<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit List</title>
</head>
<body>
	<form action="editListDetailsServlet" method="post">
	<input type="hidden" name="id" value="${listToEdit.id }">
	List Name: <input type="text" name="listName" value="${listToEdit.listName }"><br />
	
	Coach Name: <input type="text" name="coachName" value="${listToEdit.coachName}"><br />
	
	Team Name: <input type="text" name="teamName" value="${listToEdit.team.teamName }"><br />
	
	Available Items:<br />
	
	<select name="allItemsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allItems }" var="currentitem">
		<option value="${currentitem.id}">${currentitem.name } | ${currentitem.number } | ${currentitem.position }</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Edit List and Add Items">
	</form>
	<a href="index.html">Add New Items</a>

</body>
</html>