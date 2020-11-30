# Getting Started

## Project Information

[Project Guide](./src/site/mkdocs/docs/index.md)

### Project Layout
프로젝트 레이아웃은 CoC(Convention over Configuration)를 기반으로, 
별도의 설명 없이도 프로젝트/패키지/리소스 구조와 Naming 룰을 살펴 보고, 개발자가 적절한 구현을 하도록 가이드 합니다.

```bash
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── demo
│   │   │       └── oauth
│   │   │           └── server
│   │   │               └── example
│   │   │                   ├── config
│   │   │                   │   ├── AuthorizationServerConfig.java
│   │   │                   │   └── SecurityConfig.java
│   │   │                   └── OAuthServerApplication.java
│   │   └── resources
│   │       ├── static
│   │       ├── templates
│   │       └── application.yml
│   ├── site
│   │   └── mkdocs
│   │       ├── docs
│   │       │   ├── images
│   │       │   │   └── oauth-1001.png
│   │       │   └── index.md
│   │       └── mkdocs.yml
│   └── test
│       └── java
│           └── demo
│               └── oauth
│                   └── server
│                       └── example
│                           └── AuthenticationServiceApplicationTests.java
├── README.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```


### Reference Documentation
For further reference, please consider the following sections:

* [Spring Authorization Server](https://github.com/spring-projects-experimental/spring-authorization-server)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.0/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.4.0/reference/htmlsingle/#boot-features-security)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.4.0/reference/htmlsingle/#production-ready)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

