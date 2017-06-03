<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Gia
  Date: 03.06.2017
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title2$</title>
</head>
<body> this is second page
${request}

<%
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 2; i++) {
        numbers.add(i + 1);
    }
%>

<%=numbers %>
<% //for (Integer i : numbers) {
    out.println(numbers.toString());
  //  out.println("<br>");

//}

%>
</body>
</html>
