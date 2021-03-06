package com.SJlibrary.domain;


public class Author {
	private int authorID;
	private String name;
	private int age;
	private String country;
	
	public Author(){}
	public Author(int authorID, String name, int age, String country) {
		super();
		this.authorID = authorID;
		this.name = name;
		this.age = age;
		this.country = country;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public boolean equals(Object obj) {//作者名一致算同一个人
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	
}
