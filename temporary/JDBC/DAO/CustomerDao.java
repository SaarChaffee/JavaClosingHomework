/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/5/27
 */
package JDBC.DAO;

public class CustomerDao extends JdbcDaoImpl<User> {
    public CustomerDao(){
        super();
    }

    public User getUser() throws Exception {
        String selectSql = "SELECT * FROM userinfos WHERE userName = ?";
        return super.queryObject(JdbcUtils.getConnection(),selectSql,"aerfa");
    }

    public int update() throws Exception {
        String updateSql = "UPDATE userinfos SET userName='Tom',password='admin123' WHERE id=?";
        return super.update(JdbcUtils.getConnection(),updateSql,19);
    }

    public int insert() throws Exception {
        String insertSql = "INSERT INTO userinfos(userName,password,address) VALUES(?,?,?)";
        return super.update(JdbcUtils.getConnection(),insertSql,"hq","heqiang123","chengdu");
    }

    public int delete() throws Exception {
        String deleteSql = "DELETE FROM userinfos WHERE id = ?";
        return super.update(JdbcUtils.getConnection(),deleteSql,21);
    }

    public Object getValue() throws Exception {
        String getSql = "SELECT password FROM userinfos WHERE userName = ?";
        return super.getValue(JdbcUtils.getConnection(),getSql,"Tom");
    }

}
