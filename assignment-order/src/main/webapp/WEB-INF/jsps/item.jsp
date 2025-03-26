<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="item">
<table>
<tr>
   <td>ID</td>
   <td><input type="text" name="itemId" value="0"/></td>
 </tr>
 <tr>
<tr>
 <td>ItemName</td>
 <td><input type="text" name="name" value=""/></td>
</tr>

<tr>
 <td>Description</td>
 <td><input type="text" name="descrip" value=""/></td>
</tr>

<tr>
 <td>CurrentQuantity</td>
 <td><input type="text" name="currQuant" value=""/></td>
</tr>
<tr>
 <td>ReOrderQuantity</td>
 <td><input type="number" name="reOrderQuant" value=""/></td>
</tr>
<tr>
 <td>MaxQuantity</td>
 <td><input type="number" name="maxQuant" value=""/></td>
</tr>

<tr>
 <td colspan="2">
     <input name="action" value="Submit" type="submit"/>
   
     </td>
  </tr>
</table>

</form>

<table>
  <th>ItemID</th>
  <th>Name</th>
  <th>Description</th>
  <th>CurrentQuantity</th>
  <th>ReOrderQuantity</th>
  <th>MaxQuantity</th>
  
  
  <c:forEach items="${ivo}" var="i">
  
  <tr>
  <td>${i.itemId}</td>
   <td>${i.name}</td>
    <td>${i.descrip}</td>
     <td>${i.currQuant}</td>
      <td>${i.reOrderQuant}</td>
      <td>${i.maxQuant}</td>
  </tr>
  </c:forEach>
  
</table>

</body>
</html>