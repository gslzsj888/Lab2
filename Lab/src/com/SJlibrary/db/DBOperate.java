package com.SJlibrary.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.SJlibrary.domain.Author;
import com.SJlibrary.domain.Book;
public class DBOperate {
	//根据作者名得到作者对象，如返回null表示作者不存在
	public Author getAuthor(String name){
		Connection con=null;
		Statement sm=null;
		ResultSet rs=null;
		try{
			con= ConnectManage.getConnection();
			sm= con.createStatement();
			//System.out.println("select * from author where Name="+"'"+name+"'"+"");
			rs=sm.executeQuery("select * from author where Name="+"'"+name+"'"+"");
			if(rs.next()){
				Author author=new Author();
				author.setAuthorID(rs.getInt("AuthorID"));
				author.setAge(rs.getInt("Age"));
				author.setCountry(rs.getString("Country"));
				author.setName(rs.getString("Name"));
				return author;
			}
		}catch(SQLException e){e.printStackTrace();}
		finally{
			close(rs);
			close(sm);
			close(con);
		}
		return null;
	}
	
	//根据书名得到作者对象，如返回null表示作者不存在
	public Author getAuthorOfBook(String title){
		Connection con=null;
		Statement sm=null;
		ResultSet rs=null;
		int authorID=-1;
		try{
			con= ConnectManage.getConnection();
			sm= con.createStatement();
			//System.out.println("select * from book where Title="+"'"+title+"'"+"");
			rs=sm.executeQuery("select * from book where Title="+"'"+title+"'"+"");
			if(rs.next()){
				authorID=rs.getInt("AuthorID");
			}
		}catch(SQLException e){e.printStackTrace();}
		if(authorID>0)
		try{
			rs=sm.executeQuery("select * from author where AuthorID="+authorID+"");
			if(rs.next()){
				Author author=new Author();
				author.setAuthorID(rs.getInt("AuthorID"));
				author.setAge(rs.getInt("Age"));
				author.setCountry(rs.getString("Country"));
				author.setName(rs.getString("Name"));
				return author;
				}
		}catch(SQLException e){e.printStackTrace();}
		finally{
			close(rs);
			close(sm);
			close(con);
		}
		return null;
	}
	
	//根据书名得到书对象，如返回null表示书不存在
	public Book getBookFromTitle(String title){
		Connection con=null;
		Statement sm=null;
		ResultSet rs=null;
		try{
			con= ConnectManage.getConnection();
			sm= con.createStatement();
			//System.out.println("select * from book where Title="+"'"+title+"'"+"");
			rs=sm.executeQuery("select * from book where Title="+"'"+title+"'"+"");
			if(rs.next()){
				Book book=new Book();
				book.setId(rs.getInt("ID"));
				book.setISBN(rs.getString("ISBN"));
				book.setTitle(title);
				book.setAuthorID(rs.getInt("AuthorID"));
				book.setPublisher(rs.getString("Publisher"));
				book.setPublishDate(rs.getDate("PublishDate"));
				book.setPrice(rs.getDouble("Price"));
				return book;
			}
		}catch(SQLException e){e.printStackTrace();}
		finally{
			close(rs);
			close(sm);
			close(con);
		}
		return null;
	}
	//根据作者名得到书库，如返回null表示书不存在
	public List<Book> getBookOfAuthor(String name){
		Connection con=null;
		Statement sm=null;
		ResultSet rs=null;
		int authorID=-1;
		List<Book> booklist;
		booklist = new ArrayList<Book>();
		try{
			con= ConnectManage.getConnection();
			sm= con.createStatement();
			rs=sm.executeQuery("select * from author where Name="+"'"+name+"'"+"");
			if(rs.next()){
				authorID=rs.getInt("AuthorID");
			}
		}catch(SQLException e){e.printStackTrace();}
		if(authorID>0){
			try{
				rs=sm.executeQuery("select * from book where AuthorID="+authorID+"");
				while(rs.next()){
					Book book=new Book();
					book.setId(rs.getInt("ID"));
					book.setISBN(rs.getString("ISBN"));
					book.setTitle(rs.getString("Title"));
					book.setAuthorID(rs.getInt("AuthorID"));
					book.setPublisher(rs.getString("Publisher"));
					book.setPublishDate(rs.getDate("PublishDate"));
					book.setPrice(rs.getDouble("Price"));
					booklist.add(book);
				}
				return booklist;
			}catch(SQLException e){e.printStackTrace();}
			finally{
				close(rs);
				close(sm);
				close(con);
			}
	  	}
	
		return null;
	}
	//删除书籍
	public void deleteBook(int ID){
		Connection con=null;
		Statement sm=null;
		int rs=0;
		try{
			con= ConnectManage.getConnection();
			sm= con.createStatement();
			//System.out.println(ID);
			System.out.println("delete from book where ID="+ID+";");
			rs=sm.executeUpdate("delete from book where ID="+ID+";");
			
		}catch(SQLException e){e.printStackTrace();}
		finally{
			close(sm);
			close(con);
		}
	}
	//更新书籍
	public void updateBook(int ID, Book newBook){
			Connection con=null;
			Statement sm=null;
			Pattern pat1=Pattern.compile("[0-9][0-9][0-9][0-9]\\-[0-9][0-9]\\-[0-9][0-9]");
			int rs=0;
			try{
				con= ConnectManage.getConnection();
				sm= con.createStatement();
				if(newBook.getPublishDate()!=null){//出版日期填了
					if( pat1.matcher(newBook.getPublishDate().toString()).matches()){//出版日期格式正确
						//System.out.println("update book set ISBN="+"'"+newBook.getISBN()+"'"
								//+", AuthorID="+newBook.getAuthorID()
								//+", Publisher="+"'"+newBook.getPublisher()+"'"
								//+", PublishDate="+"'"+newBook.getPublishDate()+"'"
								//+", Price="+newBook.getPrice()
								//+" where ID="+ID+";");
						rs=sm.executeUpdate("update book set ISBN="+"'"+newBook.getISBN()+"'"
								+", AuthorID="+newBook.getAuthorID()
								+", Publisher="+"'"+newBook.getPublisher()+"'"
								+", PublishDate="+"'"+newBook.getPublishDate()+"'"
								+", Price="+newBook.getPrice()
								+" where ID="+ID+";");
					}
				}
				else{
					//System.out.println("update book set ISBN="+"'"+newBook.getISBN()+"'"
							//+", AuthorID="+newBook.getAuthorID()
							//+", Publisher="+"'"+newBook.getPublisher()+"'"
							//+", Price="+newBook.getPrice()
							//+" where ID="+ID+";");
					rs=sm.executeUpdate("update book set ISBN="+"'"+newBook.getISBN()+"'"
							+", AuthorID="+newBook.getAuthorID()
							+", Publisher="+"'"+newBook.getPublisher()+"'"
							+", Price="+newBook.getPrice()
							+" where ID="+ID+";");
				}
			}catch(SQLException e){e.printStackTrace();}
			finally{
				close(sm);
				close(con);
			}
	}
	
	//插入书籍
	public void insertBook(Book book){
		Connection con=null;
		Statement sm=null;
		Pattern pat1=Pattern.compile("[0-9][0-9][0-9][0-9]\\-[0-9][0-9]\\-[0-9][0-9]");
		int rs=0;
		try{
			con= ConnectManage.getConnection();
			sm= con.createStatement();
			if(book.getPublishDate()!=null){//出版日期填了
				if( pat1.matcher(book.getPublishDate().toString()).matches()){//出版日期格式正确
					//System.out.println("insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values("
					//+"'"+book.getISBN()+"'"+","
						//+"'"+book.getTitle()+"'"+","
						//+book.getAuthorID()+","
						//+"'"+book.getPublisher()+"'"+","
						//+"'"+book.getPublishDate()+"'"+","
						//+book.getPrice()+");");
					rs=sm.executeUpdate("insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values("
						+"'"+book.getISBN()+"'"+","
						+"'"+book.getTitle()+"'"+","
						+book.getAuthorID()+","
						+"'"+book.getPublisher()+"'"+","
						+"'"+book.getPublishDate()+"'"+","
						+book.getPrice()+");");
				}
			}
			else{
				//System.out.println("insert into book(ISBN,Title,AuthorID,Publisher,Price) values("
						//+"'"+book.getISBN()+"'"+","
						//+"'"+book.getTitle()+"'"+","
						//+book.getAuthorID()+","
						//+"'"+book.getPublisher()+"'"+","
						//+book.getPrice()+");");
					rs=sm.executeUpdate("insert into book(ISBN,Title,AuthorID,Publisher,Price) values("
						+"'"+book.getISBN()+"'"+","
						+"'"+book.getTitle()+"'"+","
						+book.getAuthorID()+","
						+"'"+book.getPublisher()+"'"+","
						+book.getPrice()+");");
			}
			
		}catch(SQLException e){e.printStackTrace();}
		finally{
			close(sm);
			close(con);
		}
	}
	//插入作者
	public int insertAuthor(Author author){
		Connection con=null;
		Statement sm=null;
		int rs=0;
		try{
			con= ConnectManage.getConnection();
			sm= con.createStatement();
			//System.out.println("insert into author(Name, Age, Country) values("
			//+"'"+author.getName()+"'"+","
			//+author.getAge()+","
			//+"'"+author.getCountry()+"'"+");");
			rs=sm.executeUpdate("insert into author(Name, Age, Country) values("
			+"'"+author.getName()+"'"+","
			+author.getAge()+","
			+"'"+author.getCountry()+"'"+");");
		}catch(SQLException e){e.printStackTrace();}
		finally{
			close(sm);
			close(con);
		}
		return getAuthor(author.getName()).getAuthorID();
	}
	//关闭方法
	void close(ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){e.printStackTrace();}
			rs=null;
		}
	}
	
	void close(Statement sm){
		if(sm!=null){
			try{
				sm.close();
			}catch(SQLException e){e.printStackTrace();}
			sm=null;
		}
	}
	
	void close(Connection con){}
}
