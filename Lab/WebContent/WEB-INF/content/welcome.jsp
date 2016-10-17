<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>欢迎</title>
</head>
  <body>
   <h1>Welcome to SJ library!</h1>
   <table width="400pm" align="CENTER" class="table" border="1"  valign="MIDDLE"  style="background-color: #EEE685;"> 
    <tr>
      <td>
      	 查询：
  	 	<form action="searchAuthor" method="post">
                 	  作者名：<input type="text" name="author.name"/><br/>
      	<input type="submit" value="查询作者"/>
   		</form>
   	  </td>
    </tr>
    <tr>
    </table>
    <table width="400pm" align="CENTER" class="table" border="1"  valign="MIDDLE"  style="background-color: #CAE1FF;"> 
     <tr>
   			<td>增加图书：(信息尽可能完整规范)
   				<form action="addBook" method="post">
				<input type="text" name="book.title"/>书        名<br/>
      			<input type="text" name="book.ISBN"/>ISBN<br/>
                <input type="text" name="book.publisher"/>出版社<br/>
                <input type="text" name="book.publishDate"/>出版日期<br/>
                <input type="text" name="book.price"/>价        格<br/>
                <input type="text" name="author.name"/>作者名<br/>
                <input type="text" name="author.age"/>作者年龄<br/>
                <input type="text" name="author.country"/>作者国家<br/>
     					 <input type="submit" value="增加图书"/>
   				</form>
   			</td>
   </tr>
   </table>
   
    <table width="400pm" align="CENTER" class="table" border="1"  valign="MIDDLE" rules="rows"  style="background-color: #b9d8f3;"> 
    <tr>
    <td>
        修改图书：
   <%--根据书名修改出版社，出版日期和价格，如果没有图书则添加图书 --%>
   <form action="updateBook" method="post">
       <input type="text" name="book.title"/>书        名<br/>
      	 修改为：<br/>
       <input type="text" name="book.ISBN"/>ISBN<br/>
       <input type="text" name="book.publisher"/>出版社<br/>
       <input type="text" name="book.publishDate"/>出版日期<br/>
       <input type="text" name="book.price"/>价        格<br/>
      <input type="submit" value="修改"/>
   </form>
    	</td>
   </tr>
   </table>
  </body>
</html>