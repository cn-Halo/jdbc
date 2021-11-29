package io.github.halo.jdbc;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created on 2021/11/26.
 *
 * @author yzm
 */
@FunctionalInterface
public interface StatementCallback<T> {


    T doInStatement(Statement statement) throws SQLException;
}
