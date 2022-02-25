package com.ac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ac.bean.Book;

public class BookDao {
	//create addBook method with parameter
	public int addBook(Book book) {
		//Connection statement
		Connection connet = null;
		//prepared statement
		PreparedStatement ps = null;
		try {
		connet = BookDB.getConnection();
		//insert query to insert data into the database
		String insrt = "insert into book values(?,?,?,?)";
		ps = connet.prepareStatement(insrt);
		ps.setInt(1, book.getBookid());
		ps.setString(2, book.getBooktitle());
		ps.setFloat(3, book.getBookprice());
		ps.setString(4, book.getBookgrade());
		int updateCount = ps.executeUpdate();
		connet.close();
		return updateCount;
	}
		catch(Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}
	public ArrayList getBookDetailsByID(int bookid) throws ClassNotFoundException, SQLException {
		Connection connet = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		connet = BookDB.getConnection();
		//selet query with where clause
		String sel_str = "select booktitle, bookprice form book where bookid = ?";
		connet.prepareStatement(sel_str);
		ps.setInt(1, bookid);
		rs = ps.executeQuery();
		//creating arraylist object 
		ArrayList result = new ArrayList();
		//applying if-else condition
		if(rs.next()) {
			result.add(rs.getString(1));
			result.add(rs.getString(2));
		}
		else {
			result.add("invalid id");
		}
		return result;
	}
}
