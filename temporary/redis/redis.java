/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/5/20
 */
package redis;

import redis.clients.jedis.Jedis;

class redis {
    public static void main( String[] args ) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis( "localhost", 25500 );

        // ��� Redis �������������룬��Ҫ�������У�û�оͲ���Ҫ
        // jedis.auth("123456");
        System.out.println( "���ӳɹ�" );
        //�鿴�����Ƿ�����
        System.out.println( "������������: " + jedis.ping() );

        jedis.close();

    }
}
