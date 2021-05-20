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
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis( "localhost", 25500 );

        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        // jedis.auth("123456");
        System.out.println( "连接成功" );
        //查看服务是否运行
        System.out.println( "服务正在运行: " + jedis.ping() );

        jedis.close();

    }
}
