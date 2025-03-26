<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="order" method="post">
  <table>
   <tr>
    <td>CustomerId</td>
    <td><input type="text" name="cid" /></td>
   </tr>
   
     <tr>
    <td>ItemId</td>
    <td><input type="text" name="itemId" /></td>
   </tr>
   
   <tr>
    <td>Quantity</td>
    <td><input type="text" name="quantity" /></td>
   </tr>
   
   <tr>
 <td colspan="2">
     <input name="action" value="Add" type="submit"/>
     <input name="action" value="Cancel" type="submit"/>
   
     </td>
  </tr>
  </table>
  
  
  </form>
  
  
</body>
</html>