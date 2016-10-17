<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>书的详细信息</title>
</head>
<body>
    <h1>书的详细信息</h1>
    <table width="60%" border='0.1' table width="200pm" class="table" cellpadding="2" cellspacing="0"  style="background-color: #b9d8f3;"> 
    		 <tr> </tr>
             <tr>
                 <td>书名：</td>
                 <td><s:property value="book.title"/></td>
             </tr>
             <tr>
             	 <td>ISBN： </td>
             	 <td><s:property value="book.ISBN"/></td>
             </tr>
             <tr>
             	 <td>出版商：</td>
             	 <td><s:property value="book.publisher"/></td>
             </tr>
             <tr>
             	 <td>出版日期：</td>
             	 <td><s:property value="book.publishDate"/></td>
             </tr>
             <tr>
             	 <td>价格（元）：</td>
             	 <td><s:property value="book.price"/></td>
             </tr>
             <tr>
             	 <td>作者姓名：</td>
             	 <td><s:property value="author.name"/></td>
             </tr>
             <tr>
             	 <td>作者年龄：</td><td>
             	 <s:property value="author.age"/></td>
             </tr>
             <tr>
             	 <td>作者国籍：</td><td>
             	 <s:property value="author.country"/></td>
             </tr>
    
    </table>
</body>
</html>