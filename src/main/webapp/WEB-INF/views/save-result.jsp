<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="io.servlet.servlet.model.Member" %>
<!DOCTYPE html>
<html>
<head>
    <title>Front Controller - Save Result</title>
</head>
<body>
<h1>Save Result</h1>
<%
    Member member = (Member) request.getAttribute("member");
    if (member == null) {
        out.println("<p>No member data found.</p>");
    } else {
%>
<p>username = <%= member.getUsername() %></p>
<p>password = <%= member.getPassword() %></p>
<%
    }
%>
<a href="/front-controller/members/list">Member List</a>
</body>
</html>