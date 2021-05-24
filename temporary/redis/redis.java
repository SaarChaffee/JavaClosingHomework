/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/5/20
 */
package redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

class redis {
    public static void main( String[] args ) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis( "localhost", 25500 );

        // ��� Redis �������������룬��Ҫ�������У�û�оͲ���Ҫ
        // jedis.auth("123456");
        System.out.println( "���ӳɹ�" );
        //�鿴�����Ƿ�����
        System.out.println( "������������: " + jedis.ping() );
        //�洢���ݵ��б���
        jedis.lpush( "site-list", "Runoob" );
        jedis.lpush( "site-list", "Google" );
        jedis.lpush( "site-list", "Taobao" );
        // ��ȡ�洢�����ݲ����
        List<String> list = jedis.lrange( "site-list", 0, 2 );
        for( int i = 0; i < list.size(); i++ ){
            System.out.println( "�б���Ϊ: " + list.get( i ) );
        }
        // ��ȡ���ݲ����
        Set<String> keys = jedis.keys( "" );
        Iterator<String> it = keys.iterator();
        while( it.hasNext() ){
            String key = it.next();
            System.out.println( key );
        }
        jedis.close();
    }


}
