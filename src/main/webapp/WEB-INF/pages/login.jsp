<%-- 
    Document   : login
    Created on : Sep 14, 2024, 3:06:48 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>ĐĂNG NHẬP</h1>

<c:if test="${param.error!=null}">
    <div class="alert alert-danger" >
        Đăng nhập không thành công
    </div>
</c:if>

<c:if  test="${param.accessDenied != null}"> 
    <div class="alert alert-danger">
        Bạn không có quyền truy cập
    </div>
</c:if>

<c:url value="/login" var="action" />

<form method="post" action="${action}">
    <div class="form-group mt-3">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control">
    </div>
    <div class="form-group mt-3">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control">
    </div>
    <div class="mt-3">
        <input class="btn btn-info" type="submit" value="Đăng nhập">
    </div>
</form>