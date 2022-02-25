package com.ac.Ui;
import java.util.Scanner;
import com.ac.service.BookService;
public class BookUI {
	//main method
	public static void main(String[] args) {
		int bookid = 0;
		String booktitle = "";
		float bookprice = 0;
		//taking input from end user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Book id");
	    bookid = sc.nextInt();
	    System.out.println("Enter Book title");
	    booktitle = sc.next();
	    System.out.println("Enter Book price");
	    bookprice = sc.nextFloat();
	    //creating object of BookService
	    BookService bookservice = new BookService();
	    int updateCount = bookservice.addbookservice(bookid, booktitle, bookprice);
	    System.out.println("inserted "+updateCount+" record   Success");
}
}
