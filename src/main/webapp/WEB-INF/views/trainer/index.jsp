<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <a href="trainers/create">Create Trainer</a>
        <c:forEach items="${trainers}" var="trainer">
            <p>${trainer.firstName} ${trainer.lastName} ${trainer.subject} <a href='trainers/update/${trainer.trainerId}' > Update</a><a href='trainers/delete/${trainer.trainerId}' > Delete</a></p>
        </c:forEach>
        <p><%= org.springframework.core.SpringVersion.getVersion()%></p>
    </body>
</html>
