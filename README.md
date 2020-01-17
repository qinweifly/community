##欢乐社区(FlyingJoyCommunity)

##部署
###依赖
- Git
- JDK
- Maven
- MySQL

##步骤
- yum update
- yum install git
- mkdir App
- cd App
- git clone https://github.com/qinweifly/community.git
- yum install maven
- mvn -v
- mvn clean compile package
- more src/main/resources/application.properties
- cp src/main/resources/application.properties src/main/resources/application-production.properties
- vi src/main/resources/application-production.properties
- mvn package
- java -jar -Dspring.profiles.active=production target/community-0.0.1-SNAPSHOT.jar

##资料
[Spring文档](https://spring.io/guides)
[Spring Web](https://spring.io/guides/gs/serving-web-content/)
[es](https://elasticsearch.cn/explore)
[BootStrap](https://v3.bootcss.com/getting-started/)
[Github OAuth](https://developer.github.com/apps/building-github-apps/creating-a-github-app/)
[Markdown 插件](https://pandao.github.io/editor.md/)
[UFile SDK](https://github.com/ucloud/ufile-sdk-java)
[iconfont](https://www.iconfont.cn/)

##工具
[Git](https://git-scm.com/downloads)
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)

##脚本
```sql
create table USER
(
    ID           INT auto_increment,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_PK
        primary key (ID)
);
```

```bash
mvn flyway:migrate

mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```