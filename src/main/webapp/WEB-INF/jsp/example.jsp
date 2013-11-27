<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Coding Dojo : Elitepartner</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/app.css">
</head>
<body>

<p>JSP Test</p>
<li>${data.name}</li>
<li>${data.number}</li>
<ol>
<c:forEach var="entry" items="${data.entries}">
    <li>${entry}</li>
</c:forEach>
</ol>
</body>
</html>