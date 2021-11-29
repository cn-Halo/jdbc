# jdbc template

## 学习spring jdbcTemplate实现

## 设计模式

- 模版方法模式。

## 使用

```
        /**
         * 构建JdbcTemplate 方法一
         * 采用c3p0的ComboPooledDataSource来构建javax.sql.DataSource，然后传递给jdbcTemplate。
         */
        C3p0DataSourceMetaData c3p0DataSourceMetaData = new C3p0DataSourceMetaData() {
            @Override
            public String driverClassName() {
                return "com.mysql.jdbc.Driver";
            }

            @Override
            public String jdbcUrl() {
                return "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
            }

            @Override
            public String username() {
                return "root";
            }

            @Override
            public String password() {
                return "123";
            }
        };
        JdbcTemplate jdbcTemplate = new JdbcTemplate(c3p0DataSourceMetaData);

        /**
         * 构建JdbcTemplate 方法二
         * 自定义javax.sql.DataSource的实现。
         */
        DataSource dataSource = null;
        jdbcTemplate = new JdbcTemplate(dataSource);


        /**
         * 成功之后就可以
         * 利用JdbcTemplate来进行查询
         */
        String sql = "select * from tableName";
        List<Map<String, Object>> list = jdbcTemplate.queryForListMap(sql);
        
       /**
         * 插入、删除、创建、查询...
         */
        sql = "create table table(id varchar(255) primary key ,name varchar(255))";
        sql = "insert into tableName values('1','zs') ";
        sql = "delete from tableName where id = '1'";
        jdbcTemplate.execute(sql);
        
```

## github 
- https://github.com/cn-Halo/jdbc.git
