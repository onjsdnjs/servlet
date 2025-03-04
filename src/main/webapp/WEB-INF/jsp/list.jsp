<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="io.servlet.servlet.model.Member" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Front Controller - Member List</title>
</head>
<body>
<h1>Member List (Front Controller)</h1>
<%
    List<Member> members = (List<Member>) request.getAttribute("members");
%>
<ul>
    <%
        for (Member m : members) {
    %>
    <li><%= m.getUsername() %> / <%= m.getPassword() %></li>
    <%
        }
    %>
</ul>
<a href="/front-controller/members/new-form">Go to Register Form</a>
</body>
</html>