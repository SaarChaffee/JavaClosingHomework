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
 * �ܷ����߲�����д�������⣿
 * <p>
 * ������ù���ģʽʹ��Dao��
 * <p>
 * ThreadLocal����conn����������İ���:https://blog.csdn.net/weisubao/article/details/52575787
 * QueryRunner(DataSource ds)���췽����ʵ���ô�:https://www.oschina.net/question/273800_55356
 * ���÷�����Ŀ��dao��:http://www.mamicode.com/info-detail-1552193.html
 * JDBC��Dao��:https://blog.csdn.net/whycmpx/article/details/78901875
 * ����JDBC��DAOģʽʹ��:https://www.cnblogs.com/qi-dian/p/6185545.html
 *
 * @param <T> : �����贫��ķ�������.
 */
public class JdbcDaoImpl<T> implements Dao<T> {
    //QueryRunner���̰߳�ȫ��
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
        // ͨ������, ��� Class �����������ĸ���ķ��Ͳ�������
        // ��: CustomerDao extends JdbcDaoImpl<User>
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
     * @param connection�����ݿ�����
     * @param sql��SQL���
     * @param args�����ռλ���Ŀɱ����
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
            //���￪ʼ
            rows = queryRunner.update( connection, sql, args );
            //�����ύ
        }catch( Exception e ){
            //�����쳣������ع�
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
            //����ͨ������, ��� Class �����������ĸ���ķ��Ͳ�������, ��˾Ͳ�����Ҫ����Class������.
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
            //��һ�еĵ�һ��
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
