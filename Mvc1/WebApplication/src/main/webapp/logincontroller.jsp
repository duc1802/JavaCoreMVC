<%@ page import="com.example.webapplication.LoginBean" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/10/2024
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Controller</title>
    <%
        //Step 1: Gọi Controller
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //Step 2: Xác thực thông tin đăng nhập
        LoginBean loginBean = new LoginBean();
        boolean status = false;
        status = loginBean.checkLogin(username, password);

        //Step 3: Chuyển hướng đến trang tương ứng
        if (status) {
            // Đăng nhập thành công, chuyển hướng đến trang success.jsp
            response.sendRedirect("success.jsp");
        } else {
            // Đăng nhập thất bại, chuyển hướng đến trang fail.jsp
            response.sendRedirect("fail.jsp");
        }
    %>

</head>
<body>

</body>
</html>
