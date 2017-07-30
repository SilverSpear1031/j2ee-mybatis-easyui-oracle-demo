# j2ee-mybatis-easyui-oracle-demo
基于普通j2ee&amp;mybatis&amp;easyui&amp;oracle的物业管理系统（实训作业）

1.mybatis对oracle，example中的sql语句拼接需要添加转义双引号，正确sql应如select "xx","xx" from xx where ("xx"=xx and "xx"=xx)

2.普通j2ee项目中使用mybatis，需要设置一个工具类，之后在每个service中调用工具类获得sqlsession并由其获取所需要的mapper

3.普通j2ee项目中使用log4j，需要在一个servlet的init中调用lgo4j启动，并且设置servlet随tomcat服务器启动

4.普通j2ee项目中使用mybatis，插入数据后需要通过SQLSession.commit()保存到数据库，否则仅在内存中，sql语句可以能查到但是数据库是没有的
