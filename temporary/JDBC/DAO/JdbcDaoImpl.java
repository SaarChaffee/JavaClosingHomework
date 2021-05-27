/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/5/27
 */
package JDBC.DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 能否解决高并发读写操作问题？
 * <p>
 * 如何利用工厂模式使用Dao？
 * <p>
 * ThreadLocal管理conn进行事务处理的案例:https://blog.csdn.net/weisubao/article/details/52575787
 * QueryRunner(DataSource ds)构造方法的实际用处:https://www.oschina.net/question/273800_55356
 * 利用反射搭建项目的dao层:http://www.mamicode.com/info-detail-1552193.html
 * JDBC中Dao层:https://blog.csdn.net/whycmpx/article/details/78901875
 * 关于JDBC和DAO模式使用:https://www.cnblogs.com/qi-dian/p/6185545.html
 *
 * @param <T> : 子类需传入的泛型类型.
 */
public class JdbcDaoImpl<T> implements Dao<T> {
    //QueryRunner是线程安全的
    private QueryRunner queryRunner = null;

    private Class<T> type;

    protected DataSource dataSource;

    public JdbcDaoImpl() {
        this.dataSource = null;
        this.init();
    }

    public JdbcDaoImpl( DataSource dataSource ) {
        this.dataSource = dataSource;
        this.init();
    }

    @SuppressWarnings( "unchecked" )
    protected void init() {
        this.queryRunner = new QueryRunner();
        // 通过反射, 获得 Class 定义中声明的父类的泛型参数类型
        // 如: CustomerDao extends JdbcDaoImpl<User>
        type = ( Class<T> ) ( ( ParameterizedType ) getClass().getGenericSuperclass() ).getActualTypeArguments()[0];
    }

    protected Connection prepareConnection() throws SQLException {
        if( this.getDataSource() == null ){
            throw new SQLException( "dataSource is null." );
        }
        else{
            return this.getDataSource().getConnection();
        }
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource( DataSource dataSource ) {
        this.dataSource = dataSource;
    }

    @Override
    public int update( String sql ) throws SQLException {
        Connection connection = this.prepareConnection();
        return this.update( connection, sql, ( Object[] ) null );

    }

    @Override
    public int update( Connection connection, String sql ) throws SQLException {
        return this.update( connection, sql, ( Object[] ) null );
    }

    @Override
    public int update( String sql, Object... args ) throws SQLException {
        Connection connection = this.prepareConnection();
        return this.update( connection, sql, args );
    }

    /**
     * UPDATE,INSERT,DELETE
     *
     * @param connection：数据库连接
     * @param sql：SQL语句
     * @param args：填充占位符的可变参数
     * @return
     * @throws SQLException
     */
    @Override
    public int update( Connection connection, String sql, Object... args ) throws SQLException {
        if( connection == null ){
            throw new SQLException( "Null connection" );
        }
        else if( sql == null ){
            this.closeConnection( connection );
            throw new SQLException( "Null SQL statement" );
        }
        int rows = 0;
        try{
            //事物开始
            rows = queryRunner.update( connection, sql, args );
            //事物提交
        }catch( Exception e ){
            //发生异常，事物回滚
            e.printStackTrace();
        }finally{
            this.closeConnection( connection );
        }
        return rows;
    }

    @Override
    public T queryObject(/*Class<T> clazz, */String sql ) throws SQLException {
        Connection connection = this.prepareConnection();
        return this.queryObject(/*clazz,*/connection, sql, ( Object[] ) null );
    }

    @Override
    public T queryObject(/*Class<T> clazz, */Connection connection, String sql ) throws SQLException {
        return this.queryObject(/*clazz,*/connection, sql, ( Object[] ) null );
    }

    @Override
    public T queryObject(/*Class<T> clazz, */String sql, Object... args ) throws SQLException {
        Connection connection = this.prepareConnection();
        return this.queryObject(/*clazz,*/connection, sql, args );
    }

    @Override
    public T queryObject(/*Class<T> clazz, */Connection connection, String sql, Object... args ) throws SQLException {
        if( connection == null ){
            throw new SQLException( "Null connection" );
        }
        else if( sql == null ){
            this.closeConnection( connection );
            throw new SQLException( "Null SQL statement" );
        }
        T entity = null;
        try{
            //可以通过反射, 获得 Class 定义中声明的父类的泛型参数类型, 因此就不再需要传入Class类型了.
            ResultSetHandler<T> rsh = new BeanHandler<T>(/*clazz*/type );
            boolean flag = args == null ? true : false;
            if( flag ){
                entity = queryRunner.query( connection, sql, rsh );
            }
            else{
                entity = queryRunner.query( connection, sql, rsh, args );
            }
        }catch( Exception e ){
            e.printStackTrace();
        }finally{
            this.closeConnection( connection );
        }
        return entity;
    }

    @Override
    public List<T> queryObjects(/*Class<T> clazz, */Connection connection, String sql, Object... args ) throws SQLException {
        if( connection == null ){
            throw new SQLException( "Null connection" );
        }
        else if( sql == null ){
            this.closeConnection( connection );
            throw new SQLException( "Null SQL statement" );
        }
        List<T> resultList = null;//new ArrayList<>();
        try{
            ResultSetHandler<List<T>> rsh = new BeanListHandler<T>(/*clazz*/type );
            boolean flag = args == null ? true : false;
            if( flag ){
                resultList = queryRunner.query( connection, sql, rsh );
            }
            else{
                resultList = queryRunner.query( connection, sql, rsh, args );
            }
        }catch( Exception e ){
            e.printStackTrace();
        }finally{
            this.closeConnection( connection );
        }
        return resultList;
    }

    @Override
    public <E> E getValue( Connection connection, String sql, Object... args ) throws SQLException {
        if( connection == null ){
            throw new SQLException( "Null connection" );
        }
        else if( sql == null ){
            this.closeConnection( connection );
            throw new SQLException( "Null SQL statement" );
        }

        E value = null;
        try{
            //第一行的第一列
            ResultSetHandler<E> rsh = new ScalarHandler<E>();
            value = queryRunner.query( connection, sql, rsh, args );
        }catch( Exception e ){
            e.printStackTrace();
        }finally{
            this.closeConnection( connection );
        }
        return value;
    }

    @Override
    public void batch( Connection connection, String sql, Object[]... args ) throws SQLException {
        if( connection == null ){
            throw new SQLException( "Null connection" );
        }
        else if( sql == null ){
            this.closeConnection( connection );
            throw new SQLException( "Null SQL statement" );
        }
        queryRunner.batch( connection, sql, args );
    }

    public void closeConnection( Connection connection ) throws SQLException {
        if( null != connection ){
            connection.close();
        }
    }
}
