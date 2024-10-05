<%-- 
    Document   : qlnvs
    Created on : Oct 5, 2024, 10:51:14 AM
    Author     : ADMIN
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<h1 class="text-center text-primary mt-1">THÊM MỚI NHÂN VIÊN</h1>
<c:url value="/admin/qlnvs" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}s
    </div>
</c:if>

<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="NguoiDung" >
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

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
        <label for="roleName">Role:</label>
        <select id="roleName" name="roleName" required>
            <option value="ROLE_ADMIN">Admin</option>
            <option value="ROLE_NHANVIEN">Nhân Viên</option>
            <option value="ROLE_KHACHHANG">Khách Hàng</option>
            <option value="ROLE_TAIXE">Tài Xế</option>
        </select><br><br>
    </div>
    <div class="mb-3 mt-3">
        <form:hidden path="id" />
        <form:hidden path="avatar" />
        <button class="btn btn-success" type="submit">

            <c:choose>
                <c:when test="${NguoiDung.id != null}">
                    <option value="${c.id}" selected>CẬP NHẬT NHÂN VIÊN</option>
                </c:when>
                <c:otherwise>
                    THÊM MỚI NHÂN VIÊN
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>