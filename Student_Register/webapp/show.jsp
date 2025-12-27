<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registered Students</title>
</head>
<body>

<h2 style="text-align:center;">Registered Students</h2>

<table border="1" align="center" cellpadding="10">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Year</th>
    </tr>

    <%
        List<String[]> students =
                (List<String[]>) request.getAttribute("students");

        for (String[] s : students) {
    %>
    <tr>
        <td><%= s[0] %></td>
        <td><%= s[1] %></td>
        <td><%= s[2] %></td>
    </tr>
    <% } %>
</table>

<br>
<div style="text-align:center;">
    <a href="register.jsp">Add New Student</a>
</div>

</body>
</html>
