<%-- 
    Document   : delete
    Created on : 4 Ιουλ 2019, 8:56:58 μμ
    Author     : Dimitris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${message}</h1>
        <p><a href="/SpringHibernate/trainers">back to Trainers</a>
            <script>
  setTimeout(function() {
      document.location = "/SpringHibernate/trainers";
  }, 1000); // <-- this is the delay in milliseconds
</script>
    </body>
</html>
