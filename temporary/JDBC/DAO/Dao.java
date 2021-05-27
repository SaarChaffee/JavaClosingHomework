package JDBC.DAO;

import java.sql.Connection;
import java.util.List;
import java.sql.SQLException;
/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/5/27
 */

/**
 * 访问数据库的Dao接口。
 * 其中定义了访问数据库的方法：DELETE,UPDATE,QUERY,INSERT,BATCH
 */
public interface Dao<T> {
    /**
     * INSERT,UPDATE,DELETE
     *
     * @param sql：SQL语句
     * @param connection：数据库连接
     * @param args：填充占位符的可变参数
     */
    int update( Connection connection, String sql, Object... args ) throws SQLException;

    /**
     * INSERT,UPDATE,DELETE
     *
     * @param sql：SQL语句
     * @param args：填充占位符的可变参数
     */
    int update( String sql, Object... args ) throws SQLException;

    /**
     * INSERT,UPDATE,DELETE
     *
     * @param sql：SQL语句
     */
    int update( String sql ) throws SQLException;

    /**
     * INSERT,UPDATE,DELETE
     *
     * @param sql：SQL语句
     * @param connection：数据库连接
     */
    int update( Connection connection, String sql ) throws SQLException;

    /**
     * 返回一个 T 的对象
     *
     * @param sql：SQL语句
     * @return
     */
    T queryObject(/*Class<T> clazz, */String sql ) throws SQLException;

    /**
     * 返回一个 T 的对象
     *
     * @param sql：SQL语句
     * @return
     */
    T queryObject(/*Class<T> clazz, */Connection connection, String sql ) throws SQLException;

    /**
     * 返回一个 T 的对象
     *
     * @param sql：SQL语句
     * @param args：填充占位符的可变参数
     * @return
     */
    T queryObject(/*Class<T> clazz, */String sql, Object... args ) throws SQLException;

    /**
     * 返回一个 T 的对象
     *
     * @param sql：SQL语句
     * @param args：填充占位符的可变参数
     * @return
     */
    T queryObject(/*Class<T> clazz, */Connection connection, String sql, Object... args ) throws SQLException;

    /**
     * 返回 T 的一个集合
     *
     * @param sql：SQL语句
     * @param args：填充占位符的可变参数
     * @return
     */
    List<T> queryObjects(/*Class<T> clazz, */Connection connection, String sql, Object... args ) throws SQLException;

    /**
     * 返回一个具体的值
     *
     * @param sql：SQL语句
     * @param args：填充占位符的可变参数
     * @return
     */
    <E> E getValue( Connection connection, String sql, Object... args ) throws SQLException;

    /**
     * 批量处理方法
     *
     * @param sql：SQL语句
     * @param args：填充占位符的Object[]类型的可变参数
     * @return
     */
    void batch( Connection connection, String sql, Object[]... args ) throws SQLException;
}
