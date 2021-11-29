package io.github.halo.jdbc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Map;

/**
 * @author yzm
 * @date 2021/11/29 10:07
 */
public class Test {

    public static void main(String[] args) throws PropertyVetoException {

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

    }
}