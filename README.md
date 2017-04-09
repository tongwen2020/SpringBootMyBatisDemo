## Spring Boot Demo

#1.主要功能点：

- ORM 使用MyBatis
- 增加session管理，Session统一保存在Redis中
- 利用拦截器(Interceptor)验证用户合法性
- 基于slf4j log库封装了LogHelper类，日志区分info，error，fatal三个打印级别