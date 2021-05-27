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
 * �������ݿ��Dao�ӿڡ�
 * ���ж����˷������ݿ�ķ�����DELETE,UPDATE,QUERY,INSERT,BATCH
 */
public interface Dao<T> {
    /**
     * INSERT,UPDATE,DELETE
     *
     * @param sql��SQL���
     * @param connection�����ݿ�����
     * @param args�����ռλ���Ŀɱ����
     */
    int update( Connection connection, String sql, Object... args ) throws SQLException;

    /**
     * INSERT,UPDATE,DELETE
     *
     * @param sql��SQL���
     * @param args�����ռλ���Ŀɱ����
     */
    int update( String sql, Object... args ) throws SQLException;

    /**
     * INSERT,UPDATE,DELETE
     *
     * @param sql��SQL���
     */
    int update( String sql ) throws SQLException;

    /**
     * INSERT,UPDATE,DELETE
     *
     * @param sql��SQL���
     * @param connection�����ݿ�����
     */
    int update( Connection connection, String sql ) throws SQLException;

    /**
     * ����һ�� T �Ķ���
     *
     * @param sql��SQL���
     * @return
     */
    T queryObject(/*Class<T> clazz, */String sql ) throws SQLException;

    /**
     * ����һ�� T �Ķ���
     *
     * @param sql��SQL���
     * @return
     */
    T queryObject(/*Class<T> clazz, */Connection connection, String sql ) throws SQLException;

    /**
     * ����һ�� T �Ķ���
     *
     * @param sql��SQL���
     * @param args�����ռλ���Ŀɱ����
     * @return
     */
    T queryObject(/*Class<T> clazz, */String sql, Object... args ) throws SQLException;

    /**
     * ����һ�� T �Ķ���
     *
     * @param sql��SQL���
     * @param args�����ռλ���Ŀɱ����
     * @return
     */
    T queryObject(/*Class<T> clazz, */Connection connection, String sql, Object... args ) throws SQLException;

    /**
     * ���� T ��һ������
     *
     * @param sql��SQL���
     * @param args�����ռλ���Ŀɱ����
     * @return
     */
    List<T> queryObjects(/*Class<T> clazz, */Connection connection, String sql, Object... args ) throws SQLException;

    /**
     * ����һ�������ֵ
     *
     * @param sql��SQL���
     * @param args�����ռλ���Ŀɱ����
     * @return
     */
    <E> E getValue( Connection connection, String sql, Object... args ) throws SQLException;

    /**
     * ����������
     *
     * @param sql��SQL���
     * @param args�����ռλ����Object[]���͵Ŀɱ����
     * @return
     */
    void batch( Connection connection, String sql, Object[]... args ) throws SQLException;
}
