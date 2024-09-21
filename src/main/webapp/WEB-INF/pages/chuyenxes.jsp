<%-- 
    Document   : chuyenxes
    Created on : Sep 9, 2024, 4:46:17 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:formatDate value="${chuyenXe.ngayGioKhoiHanh}" pattern="yyyy-MM-dd'T'HH:mm" var="formattedDate" />


<h1 class="text-center text-primary mt-1">QUẢN LÝ CHUYẾN XE</h1>
<c:url value="/admin/chuyenxes" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}s
    </div>
</c:if>

<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="chuyenXe">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />


    <div class="mb-3 mt-3">
        <label for="file" class="form-label">Ảnh chuyến xe:</label>
        <form:input path="file" type="file" accept=".jpg,.png" class="form-control" id="file" name="file" />
        <c:if test="${chuyenXe.image != null}">
            <img class="mt-1" src="${chuyenXe.image}" alt="${chuyenXe.image}" width="120" />
        </c:if>
    </div>
 <div class="mb-3 mt-3">
    <label for="trangThai" class="form-label">Trạng thái sản phẩm:</label>
    <form:select path="trangThai" class="form-control" id="trangThai">
        <form:options items="${trangThaiList}" itemValue="name" itemLabel="displayName" />
    </form:select>
</div>
    <div class="mb-3 mt-3">
        <label for="giaVe" class="form-label">Gía vé:</label>
        <form:input path="giaVe" type="number" class="form-control" id="giaVe" placeholder="Gía vé..." name="giaVe" />
    </div>
    <div class="mb-3 mt-3">
        <label for="ngayGioKhoiHanh" class="form-label">Ngày và giờ:</label>
        <form:input path="ngayGioKhoiHanh" type="datetime-local" class="form-control" id="ngayGioKhoiHanh" />
    </div>
     <div class="mb-3 mt-3">
        <label for="soCho" class="form-label">Số chỗ:</label>
        <form:input path="soCho" type="number" class="form-control" id="soCho" placeholder="Số chỗ..." name="soCho" />
    </div>
   <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="tuyenXe" path="tuyenXeId">
            <c:forEach items="${tuyenXes}" var="c">
                <c:choose>
                    <c:when test="${c.id==chuyenXe.tuyenXeId.id}">
                        <option value="${c.id}" selected>${c.tenTuyen}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.tenTuyen}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="tuyenXe" class="form-label">Tuyến Xe</label>
    </div>
    
    <div class="mb-3 mt-3">
        <form:hidden path="id" />
        <form:hidden path="image" />
        <button class="btn btn-success" type="submit">

            <c:choose>
                <c:when test="${chuyenXe.id != null}">
                    <option value="${c.id}" selected>Cập nhật chuyến xe</option>
                </c:when>
                <c:otherwise>
                    Thêm chuyến xe
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>