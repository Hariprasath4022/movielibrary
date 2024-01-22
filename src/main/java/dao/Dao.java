package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import dto.Admin;
import dto.Movie;

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
	
	public int SaveMovie(Movie movie) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		
		PreparedStatement pst=conn.prepareStatement("insert into movie values(?,?,?,?,?,?,?)");
		pst.setInt(1, movie.getMovieid());
		pst.setString(2, movie.getMoviename());
		pst.setDouble(3, movie.getMovieprice());
		pst.setDouble(4, movie.getMovierating());
		pst.setString(5, movie.getMoviegenre());
		pst.setString(6, movie.getMovielanguage());
		Blob imgblob=new SerialBlob(movie.getMovieimage());
		pst.setBlob(7, imgblob);
		
		return pst.executeUpdate();
		
	}
	public List<Movie> GetAllMovies() throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		
		PreparedStatement pst=conn.prepareStatement("select * from movie");
		ResultSet rs=pst.executeQuery();
		List<Movie> movies=new ArrayList<Movie>();
		while(rs.next())
		{
			Movie m=new Movie();
			m.setMovieid(rs.getInt(1));
			m.setMoviename(rs.getString(2));
			m.setMovieprice(rs.getDouble(3));
			m.setMovierating(rs.getDouble(4));
			m.setMoviegenre(rs.getString(5));
			m.setMovielanguage(rs.getString(6));
			Blob b=rs.getBlob(7);
			byte[] img=b.getBytes(1, (int)b.length());
			m.setMovieimage(img);
			movies.add(m);
		}
		return movies;
		
	}
	
	public int DeleteMovie(int movieid) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		
		PreparedStatement pst=conn.prepareStatement("delete from movie where movieid = ?");
		pst.setInt(1, movieid);
		
		return pst.executeUpdate();
		
	}
	
	public Movie FindMovieById(int movieid) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		
		PreparedStatement pst=conn.prepareStatement("select * from movie where movieid = ?");
		pst.setInt(1, movieid);
		ResultSet rs=pst.executeQuery();
		rs.next();
		
		Movie m=new Movie();
		m.setMovieid(rs.getInt(1));
		m.setMoviename(rs.getString(2));
		m.setMovieprice(rs.getDouble(3));
		m.setMovierating(rs.getDouble(4));
		m.setMoviegenre(rs.getString(5));
		m.setMovielanguage(rs.getString(6));
		Blob b=rs.getBlob(7);
		byte[] img=b.getBytes(1, (int)b.length());
		m.setMovieimage(img);
		
		return m;
		
	}
	public int UpdateMovie(Movie movie) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("update movie set moviename=?,movieprice=?,movierating=?,moviegenre=?,movielanguage=?,movieimage=? where movieid=?");
		
		pst.setInt(7, movie.getMovieid());
		pst.setString(1, movie.getMoviename());
		pst.setDouble(2, movie.getMovieprice());
		pst.setDouble(3, movie.getMovierating());
		pst.setString(4, movie.getMoviegenre());
		pst.setString(5, movie.getMovielanguage());
		Blob imgBlob=new SerialBlob(movie.getMovieimage());
		pst.setBlob(6, imgBlob);
		
		return pst.executeUpdate();
	}
	
}
