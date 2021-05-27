/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/5/27
 */
package JDBC.DAO;

import java.lang.reflect.*;

/**
 * ͨ������, ��ö��� Class ʱ�����ĸ���ķ��Ͳ���������
 * ��: public EmployeeDao extends BaseDao<Employee, String>
 *
 * @param clazz
 * @param index
 * @return
 */
@SuppressWarnings( "unchecked" )
public static Class getSuperClassGenricType(Class clazz,int index){
        Type genType=clazz.getGenericSuperclass();

        if(!(genType instanceof ParameterizedType)){
        return Object.class;
		}

                Type[]params=((ParameterizedType)genType).getActualTypeArguments();

                if(index>=params.length||index< 0){
        return Object.class;
		}

                if(!(params[index]instanceof Class)){
                return Object.class;
		}

                return(Class)params[index];
                }