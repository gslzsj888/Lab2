package com.SJlibrary.service;
import java.util.List;

//import com.SJlibrary.db.DBOperateTosae;
import com.SJlibrary.db.DBOperate;
import com.SJlibrary.domain.Author;
import com.SJlibrary.domain.Book;
public class authorService {
	
	public List<Book> sqlSearchAuthorID(String authorName) {//已知作者找书
		DBOperate ope=new DBOperate();
		//DBOperateTosae ope=new DBOperateTosae();
		return ope.getBookOfAuthor(authorName);
	}

	public Author sqlSearchAuthorObject(String title) {//已知书名找作者
		DBOperate ope=new DBOperate();
		//DBOperateTosae ope=new DBOperateTosae();
		return ope.getAuthorOfBook(title);
	}

	
}