package com.tongwen.Interceptor;


import com.tongwen.common.ErrorCode;
import com.tongwen.common.LoggerHelper;
import com.tongwen.common.LoggerHelperFactory;
import com.tongwen.common.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by tongwen on 2017/4/7.
 */
@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {
    //private Logger logger = org.slf4j.LoggerFactory.getLogger(SessionInterceptor.class);
    private LoggerHelper loggerHelper = LoggerHelperFactory.getLoggerHelper(SessionInterceptor.class);

    private final String SESSION_KEY = "SessionId";
    private final int SESSION_MAX_TIME_LEN = 30;    //session超时时长：30分钟

    /*
        此处StringRedisTemplate自动绑定的定义，必须放置在logger定义之后
        否则会导致Autowired失败，stringRedisTemplate为null。
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        loggerHelper.info("enter session interceptor...");
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if(null == cookieMap){
            return false;
        }

        if(!cookieMap.containsKey(SESSION_KEY)){
            //no cookie found, set cookie
            UUID uuid = UUID.randomUUID();
            Cookie cookie = new Cookie(SESSION_KEY, uuid.toString());
            response.addCookie(cookie);
            loggerHelper.info("no cookie found, set cookie:" + uuid.toString());
            return false;
        }

        Cookie cookie = cookieMap.get(SESSION_KEY);
        String sessionId = cookie.getValue();

        ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
        String sessionVal = valueOps.get(sessionId);
        if(StringHelper.isStringNullOrEmpty(sessionVal)){
            //maybe session is time out.
            loggerHelper.error(ErrorCode.ErrSessionTimeout, "session is time out, need to log in.");
            return false;
        }

        stringRedisTemplate.opsForValue().set(sessionId, sessionVal, SESSION_MAX_TIME_LEN, TimeUnit.MINUTES);
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    /*
        读取Request中的Cookie头部
     */
    private Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null == cookies){
            return cookieMap;
        }

        for(Cookie cookie : cookies){
            cookieMap.put(cookie.getName(), cookie);
        }
        return cookieMap;
    }
}
