/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/5/24
 */
package redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class test1 {
    public static void main( String[] args ) {
        Jedis je = new Jedis( "localhost", 25500 );
//        List<String> list = je.lrange( "site-list", 0, 100 );
//        for( int i = 0; i < list.size(); i++ ){
//            System.out.println( "�б���Ϊ: " + list.get( i ) );
//        }
        String keyName = new String();
        keyName = "site-list";
        for( int i = 0; i < je.llen( keyName ); i++ ){
            System.out.println( keyName + ":" + je.lindex( keyName, i ) );
        }

        // ��ȡ���ݲ����
        Set<String> keys = je.keys( "" );
        Iterator<String> it = keys.iterator();
        while( it.hasNext() ){
            String key = it.next();
            System.out.println( key );
        }
        je.close();

    }
}
