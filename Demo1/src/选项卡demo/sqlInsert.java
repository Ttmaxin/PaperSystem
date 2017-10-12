package 选项卡demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class sqlInsert {
	//static int j=1;
	public static void sqlInsert(String nandu,String zsd1,String tigan, String zsd2,String zsd3) {
	 //声明Connection对象
    Connection con;
    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名sqltestdb
    String url = "jdbc:mysql://localhost:3306/sqltestdb";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "zoey520";
    //遍历查询结果集
    try {
        //加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// 2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();
			// 要执行的SQL语句
			String uuid = UUID.randomUUID().toString(); 
			String sql = "insert into lib(id, diff, zsd1, tg, zsd2, zsd3) values('"+uuid+"','"+nandu+"','"+zsd1+"','"+tigan+"','"+zsd2+"','"+zsd3+"')";
			
			// 3.ResultSet类，用来存放获取的结果集！！
			int rs = statement.executeUpdate(sql);
			System.out.println("-----------------");
      
    } catch(ClassNotFoundException e) {   
        //数据库驱动类异常处理
        System.out.println("Sorry,can`t find the Driver!");   
        e.printStackTrace();   
        } catch(SQLException e) {
        //数据库连接失败异常处理
        e.printStackTrace();  
        }catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }finally{
        System.out.println("数据库数据成功获取！！");
    }
	}
	
	
	public static void main(String args[])
	{
		sqlInsert.sqlInsert("简单", "追及问题", "测试test","111","11111");
	}
}
