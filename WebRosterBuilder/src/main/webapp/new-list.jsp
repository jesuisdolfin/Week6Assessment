<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New List</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
	List Name: <input type="text" name="listName"><br />
	Coach Name: <input type="text" name="coachName"><br />
	Team Name: <input type="text" name="teamName"><br />
	
	Available Players: <br />
	<select name="allItemsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allItems }" var="currentplayer">
	<option value="${currentplayer.id}">${currentplayer.name }, #${currentplayer.number }</option>
	</c:forEach></select>
	<br />
	<input type="submit" value="Create Team and Add Players">
	</form>
	<a href="index.html">Add more Players</a>
</body>
</html>