package com.SJlibrary.service;
import java.util.List;

//import com.SJlibrary.db.DBOperateTosae;
import com.SJlibrary.db.DBOperate;
import com.SJlibrary.domain.Author;
import com.SJlibrary.domain.Book;
public class authorService {
	
	public List<Book> sqlSearchAuthorID(String authorName) {//��֪��������
		DBOperate ope=new DBOperate();
		//DBOperateTosae ope=new DBOperateTosae();
		return ope.getBookOfAuthor(authorName);
	}

	public Author sqlSearchAuthorObject(String title) {//��֪����������
		DBOperate ope=new DBOperate();
		//DBOperateTosae ope=new DBOperateTosae();
		return ope.getAuthorOfBook(title);
	}

	
}