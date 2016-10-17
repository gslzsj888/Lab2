<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset=UTF-8>
<title>图书</title>
<style type="text/css"> 
body,table{ font-size:12px; } 
table{ table-layout:fixed; empty-cells:show; border-collapse: collapse; margin:0 auto; } 
td{ height:30px; } 
h1,h2,h3{ font-size:12px; margin:0; padding:0; } 
.table{ border:1px solid #cad9ea; color:#666; } 
.table th { background-repeat:repeat-x; height:30px; } 
.table td,.table th{ border:1px solid #cad9ea; padding:0 1em 0; } 
.table tr.alter{ background-color:#f5fafe; } 
</style> 
</head>
<body>
  <table width="90%" align="CENTER" class="table" border="1"  valign="MIDDLE" rules="rows" style="background-color: #E3E3E3;"> 
    <tr>
        <th>图书书名</th>
        <th>选项</th>
    </tr>
    <s:iterator value="booklist" var="b">
    <tr>
  		<td >
  			<a href="viewBookDetail?book.title=${b.getTitle()}">${b.title}</a>
        </td>
        <td>
            <form action="deleteBook" method="post">
              	     <input type="hidden" name="book.title" value="${b.title}"/><br/>
     			 	 <input type="submit" value="删除"/>
  			 </form>
        </td>
    </tr>
    <tr>
    </tr>
    </s:iterator>
  </table>

</body>
</html>