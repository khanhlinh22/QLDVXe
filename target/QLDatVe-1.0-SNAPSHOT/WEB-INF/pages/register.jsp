<%-- 
    Document   : register
    Created on : Sep 16, 2024, 3:30:35 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">ĐĂNG KÝ</h1>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg} 
    </div>
</c:if>
<c:url value="/register" var="action" />

<form:form method="post" action="${action}" modelAttribute="NguoiDung" enctype="multipart/form-data">
<!--    <div class="form-group mt-3">
        <label for="id">ID (if required)</label>
        <form:input type="text" id="id" path="id" class="form-control" />
    </div>-->
    <div class="form-group mt-3">
        <label for="ten">Tên</label>
        <form:input type="text" id="ten" path="ten" class="form-control" /> 
    </div>
    <div class="form-group mt-3">
        <label for="ho">Họ</label>
        <form:input type="text" id="ho" path="ho" class="form-control" />
    </div>
    <div class="form-group mt-3">
        <label for="namSinh">Năm Sinh</label>
        <form:input type="number" id="namSinh" path="namSinh" class="form-control" />
    </div>
    <div class="form-group mt-3">
        <label for="cccd">CCCD</label>
        <form:input type="text" id="cccd" path="cccd" class="form-control" />
    </div>
    <div class="form-group mt-3">
        <label for="sdt">SDT</label>
        <form:input type="text" id="sdt" path="sdt" class="form-control" />
    </div>
    <div class="form-group mt-3">
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" class="form-control" />
    </div>
  <div class="mb-3 mt-3">
        <label for="file" class="form-label">Ảnh đại diện</label>
        <form:input path="file" type="file" accept=".jpg,.png" class="form-control" id="file" name="file" />
        <c:if test="${NguoiDung.avatar != null}">
            <img class="mt-1" src="${NguoiDung.avatar}" alt="${NguoiDung.avatar}" width="120" />
        </c:if>
    </div>
    <div class="form-group mt-3">
        <label for="username">Username</label>
        <form:input type="text" id="username" path="username" class="form-control" />
    </div>
    <div class="form-group mt-3">
        <label for="password">Password</label>
        <form:input type="password" id="password" path="password" class="form-control" />
    </div>
    <div class="form-group mt-3">
        <label for="confirm-password">Confirm Password</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control" />
    </div>
     <div class="form-group mt-3">
        <label for="roleName">Role:</label>
        <select id="roleName" name="roleName" required>
<!--            <option value="ADMIN">Admin</option>-->
<!--            <option value="NHANVIEN">Nhân Viên</option>-->
            <option value="KHACHHANG">Khách Hàng</option>
<!--            <option value="TAIXE">Tài Xế</option>-->
        </select><br><br>
    </div>
    <div class="mt-3">
        <input class="btn btn-info" type="submit" value="Đăng ký">
    </div>
</form:form>