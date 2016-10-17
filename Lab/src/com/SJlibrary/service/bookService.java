package com.SJlibrary.service;

import com.SJlibrary.db.DBOperate;
import com.SJlibrary.db.DBOperateTosae;
//import com.SJlibrary.db.DBOperateTosae;
import com.SJlibrary.domain.Author;
import com.SJlibrary.domain.Book;

public class bookService {

	public Book sqlSearchBookObject(String title) {//已知书名找书
		//DBOperate ope=new DBOperate();
		DBOperateTosae ope=new DBOperateTosae();
		return ope.getBookFromTitle(title);
	}
	
	public int sqlDeleteBookObject(String title) {//已知书名删书
		//DBOperate ope=new DBOperate();
		DBOperateTosae ope=new DBOperateTosae();
		Book book=new Book();
		if((book=ope.getBookFromTitle(title))==null)//找不着就返回
			return 0;
		ope.deleteBook(book.getId());
		return 1;
	}

	public void sqlUpdateBookObject(Book book, Author author) {
		//DBOperate ope=new DBOperate();
		DBOperateTosae ope=new DBOperateTosae();
		Author at=new Author();
		int authorID=0;
		Book booktemp=new Book();
		at = ope.getAuthor(author.getName());
		if(at==null){//库中无该作者
			authorID=ope.insertAuthor(author);//插入
		}
		else
			authorID=at.getAuthorID();
		book.setAuthorID(authorID);
		booktemp=ope.getBookFromTitle(book.getTitle());
		if(booktemp==null){
			ope.insertBook(book);
		}
		else{
			ope.updateBook(booktemp.getId(), book);
		}
		
	}
	public int sqlUpdateBookObject(Book book) {
		//DBOperate ope=new DBOperate();
		DBOperateTosae ope=new DBOperateTosae();
		Book booktemp=new Book();
		booktemp=ope.getBookFromTitle(book.getTitle());
		if(booktemp==null){
			return 0;
		}
		else{
			book.setAuthorID(booktemp.getAuthorID());
			ope.updateBook(booktemp.getId(), book);
		}
		return 1;
	}
	
	
	
	
}
