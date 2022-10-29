<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new list</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
	List Name: <input type="text" name="listName"><br />
	Coach Name: <input type="text" name="coachName"><br />
	Team Name: <input type="text" name="teamName"><br />
	
	Available Items:<br />
	<select name="allItemsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allPlayers }" var="currentitem">
		<option value="${currentitem.id}">${currentitem.name} | ${currentitem.number} | ${currentitem.position}</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Create List and Add Players">
	</form>
	<a href="index.html">Add new items</a>
</body>
</html>