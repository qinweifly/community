##飞天欢乐社区(FlyingJoyCommunity)

##资料
[Spring文档](https://spring.io/guides)
[Spring Web](https://spring.io/guides/gs/serving-web-content/)
[es](https://elasticsearch.cn/explore)
[BootStrap](https://v3.bootcss.com/getting-started/)
[Github OAuth](https://developer.github.com/apps/building-github-apps/creating-a-github-app/)

##工具
[Git](https://git-scm.com/downloads)

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
mvn flyway:migrate