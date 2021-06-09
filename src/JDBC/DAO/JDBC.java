/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2021 2021/6/5
 */
package JDBC.DAO;

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
 * where in|exists|not exists(select * from table where ����) --����
 * and a.key between 1 and 2
 * and a.key like '1'
 * and ...
 * ORDER BY key ASC | DESC
 * GROUP BY key
 * HAVING 公式条件:avg(),sum(),max(),min(),first(),last(),count()
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
