package com.ac.service;

import java.util.ArrayList;

import com.ac.bean.Book;
import com.ac.dao.BookDao;

public class BookService {
	//creating addbookservice method with parameters
	public int addbookservice(int bookid, String booktitle, float bookprice) {
		//taking bookgrade as string
		String bookgrade = "";
		//apply if-else condition to check the grade
		if(bookprice >= 900) {
			bookgrade = "A";
		}
		else if(bookprice >= 700 && bookprice <= 900) {
			bookgrade = "B";
		}
		else if(bookprice >= 500 && bookprice <= 700) {
			bookgrade = "C";
		}
		else if(bookprice >= 300 && bookprice <= 500) {
			bookgrade = "D";
		}
		else if(bookprice >= 200 && bookprice <= 300) {
			bookgrade = "E";
		}
		else {
			bookgrade = "F";
		}
		//creating object og BookDao
		BookDao bdao = new BookDao();
		//creating object of Book
		Book book = new Book();
		//wrap up all the fields values into the entity
		book.setBookid(bookid);
		book.setBooktitle(booktitle);
		book.setBookprice(bookprice);
		book.setBookgrade(bookgrade);
		int updateResult = 0;
		//applying try-catch block to identify the Exception
		try {
			updateResult = bdao.addBook(book);
			return updateResult;
			}
			catch(Exception e) {
				System.out.println(e.toString());
				return 0;
			}
	}
	
}
