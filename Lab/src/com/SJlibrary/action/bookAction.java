package com.SJlibrary.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.SJlibrary.domain.Author;
import com.SJlibrary.domain.Book;
import com.SJlibrary.service.authorService;
import com.SJlibrary.service.bookService;
import com.opensymphony.xwork2.ActionSupport;

public class bookAction extends ActionSupport {
    private Book book;
    private Book tempbook;
	private Author author;
	private List<Book> booklist;
	
	public Book getTempbook() {
		return tempbook;
	}
	public void setTempbook(Book tempbook) {
		this.tempbook = tempbook;
	}
    public List<Book> getBooklist() {
		return booklist;
	}
	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
    public String searchAuthor(){//查询作者的书籍
    	authorService a= new authorService();
    	setBooklist(a.sqlSearchAuthorID(author.getName()));
    	if(this.booklist!=null)
    		return SUCCESS;
    	else 
    		return ERROR;
    }
    
    public String searchBook1() throws UnsupportedEncodingException{//查询书籍的相关信息,超链接(本地测试时转码)
    	bookService b=new bookService();
    	authorService a= new authorService();
    	String title=new String(tempbook.getTitle().getBytes("ISO-8859-1"),"utf-8"); 
    	Book bookTemp = b.sqlSearchBookObject(title);
    	setAuthor(a.sqlSearchAuthorObject(title));
    	setBook(bookTemp);
    	return SUCCESS;
    }
    public String searchBook(){//查询书籍的相关信息
    	bookService b=new bookService();
    	authorService a= new authorService();
    	Book bookTemp=new Book();
    	bookTemp = b.sqlSearchBookObject(book.getTitle());
    	setAuthor(a.sqlSearchAuthorObject(book.getTitle()));
    	setBook(bookTemp);
    	return SUCCESS;
    }
    

    public String deleteBook(){//删除书籍
    	bookService b=new bookService();
    	if(b.sqlDeleteBookObject(book.getTitle())==1){
    		return SUCCESS;
    	}
    	else
    		return ERROR;
    }
    
    
    public String addBook(){//增加书籍和作者
    	bookService b=new bookService();
    	b.sqlUpdateBookObject(book, author);
    	return SUCCESS;
    }
    
    public String updateBook(){//更新书籍
    	bookService b=new bookService();
    	if(b.sqlUpdateBookObject(book)==1)
    		return SUCCESS;
    	else 
    		return ERROR;
    }
    
    
    
}
