<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
    </head>
    <body>
                
        <h1>${title}</h1>
        <form:form method="POST" action="/SpringHibernate/trainers/save" modelAttribute="trainer">
            <form:hidden path="trainerId" />
            Name: <form:input path="firstName" name="name" type="text" /><br />
            Surname: <form:input path="lastName" name="lastName" type="text" /><br />
            Subject <form:input path="subject" name="subject" type="text" /><br />
            <input type="Submit" value="Save Trainer" /><br />
        </form:form>
    </body>
</html>
