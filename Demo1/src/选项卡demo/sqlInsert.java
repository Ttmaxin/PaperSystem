package 选项卡demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class sqlInsert {
	//static int j=1;
	public static void sqlInsert(String nandu,String zhishidian,String tigan) {
	 //声明Connection对象
    Connection con;
    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
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
			// String sql = "select * from lib where 难度='"+difficulty+"' order by rand()
			// limit "+num;
			//UUID uuid = UUID.randomUUID();
			String uuid = UUID.randomUUID().toString(); 
			
			// String sql ="insert into lib
			// values(100,'"+nandu+"','"+zhishidian+"','"+tigan+"')";
			// sqlInsert.sqlInsert("简单", "追及问题", "测试test");
			String sql = "insert into lib(id, diff, zsd, tg) values('"+uuid+"','"+nandu+"','"+zhishidian+"','"+tigan+"')";
			
			// 3.ResultSet类，用来存放获取的结果集！！
			int rs = statement.executeUpdate(sql);
			System.out.println("-----------------");
      
      /*
        String zhishidian = null;
        String tigan = null;
        int i=1;
        while(rs.next()){
        	
            //获取stuname这列数据
        	zhishidian = rs.getString("三级知识点");
        
            //获取stuid这列数据
        	tigan = rs.getString("题干");
         

            //输出结果
           // System.out.println(zhishidian + "*************" + tigan+"\n");
            ForFile.writeFileContent(path,"【"+i+"】  " +tigan+"\r\n\r\n\r\n\r\n\r\n");
            i++;
        }
        rs.close();
        con.close();*/
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
		//sqlInsert.sqlInsert("1", "1", "1");
		sqlInsert.sqlInsert("简单", "追及问题", "测试test");
	}
}
