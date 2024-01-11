package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Admin;

public class Dao
{
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb","root","root");
		
	}
	public int SaveAdmin(Admin admin) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		
		PreparedStatement pst=conn.prepareStatement("insert into admin values(?,?,?,?,?)");
		
		pst.setInt(1, admin.getAdminid());
		pst.setString(2, admin.getAdminname());
		pst.setLong(3, admin.getAdmincontact());
		pst.setString(4, admin.getAdminemail());
		pst.setString(5, admin.getAdminpassword());
		
		return pst.executeUpdate();
		
	}
	public Admin FindByEmail(String adminemail) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		
		PreparedStatement pst=conn.prepareStatement("select * from admin where adminemail=?");
		pst.setString(1, adminemail);
		
		ResultSet res=pst.executeQuery();
		//res.first();
		Admin admin=null;
		if(res.next())
		{
			admin=new Admin();
		
			admin.setAdminid(res.getInt(1));
			admin.setAdminname(res.getString(2));
			admin.setAdmincontact(res.getLong(3));
			admin.setAdminemail(res.getString(4));
			admin.setAdminpassword(res.getString(5));
		}
		
		return admin;
		
	}
}
