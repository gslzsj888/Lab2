package com.SJlibrary.domain;

import java.sql.Date;

public class Book {
	public Book(int id, String iSBN, String title, int authorID, String publisher, Date publishDate, double price) {
		super();
		this.id = id;
		ISBN = iSBN;
		this.title = title;
		this.authorID = authorID;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.price = price;
	}

	private int id;
	private String ISBN;
	private String title;
	private int authorID;
	private String publisher;
	private Date publishDate;
	private double price;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public boolean equals(Object obj) {//书名相同，即认为是同一本书
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
