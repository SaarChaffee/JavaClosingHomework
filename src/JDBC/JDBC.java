/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/6/5
 */
package JDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    private static Statement stat;
    private static Connection conn;
    private static ComboPooledDataSource cp = new ComboPooledDataSource();

    public static Connection getConn() {
        try{
            conn = cp.getConnection();
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return conn;
    }

    public static Statement getStat() {
        try{
            stat = getConn().createStatement();
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return stat;
    }
}

//public class JDBC {
//    private static Statement stat;
//
//    static {
//        //1.加载驱动
//        try{
//            Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
//            String url = "jdbc:sqlserver://localhost:1433";
//            String username = "Java";
//            String password = "111";
//            Connection conn = null;
//
//            //2.获取与数据库的链接
//            conn = DriverManager.getConnection( url, username, password );
//            stat = conn.createStatement();
//        }catch( ClassNotFoundException | SQLException e ){
//            e.printStackTrace();
//        }
//
//    }
//
//    public static Statement getStat() {
//        return stat;
//    }
//}
/**
 * drop database db
 * create database db
 * (
 * name = 'db'
 * filename = 'db.db'
 * size = 2
 * maxsize = 5
 * filegrowth = 1
 * )
 * <p>
 * drop table t1
 * create table t1
 * (
 * key char(30) NOT NULL default'1',--key
 * check(key ='1'or key ='2'),
 * unique(key),
 * primary key(key),
 * foreign key (key) references another(key)
 * )
 * <p>
 * alter table t1 add primary key(key),
 * alter table t1 drop primary key(key),
 * alter table t1 key int(30),
 * <p>
 * insert into t1 value('value'),
 * <p>
 * update t1
 * set key=1
 * where key=1
 * <p>
 * delete from t1
 * where key = 1
 * <p>
 * select * as value
 * from t1 a
 * join t1
 * right outer join t1
 * left outer join t1
 * full outer join t1
 * where in|exists|not exists(select * from table where 条件) --套娃
 * and a.key between 1 and 2
 * and a.key like '1'
 * and ...
 * ORDER BY key ASC | DESC
 * GROUP BY key
 * HAVING 公式条件：avg(),sum(),max(),min(),first(),last(),count()
 * <p>
 * union all
 * select *
 * from t1
 * where ...
 * <p>
 * <p>
 * create login [name] with password='123'
 * create user name for name
 * grant all privileges on t1 from name with grant option
 * revoke all privileges on t1 from name with grant option
 */
