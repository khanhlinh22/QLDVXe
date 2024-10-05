<%-- 
    Document   : header
    Created on : Aug 30, 2024, 12:08:59 AM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand">
            <img width="100px" src="<c:url value='/images/logo.jpg' />" alt="Logo">
        </a>        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">

                <c:forEach items="${tuyenXes}" var="c">
                    <li class="nav-item"style="font-size: 12px;">
                        <c:url var="myUrl" value="/">
                            <c:param name="tuyenXeId" value="${c.id}"/>
                        </c:url>
                        <a class="nav-link" href="${myUrl}">Tuyến Xe ${c.tenTuyen}</a>
                    </li> 
                </c:forEach>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Tính năng</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value="/" />">Bảng tin</a></li>
                        <li><a class="dropdown-item" href="#">Hỏi đáp</a></li>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <li><a class="dropdown-item btn-info" href="<c:url value="/stats" />">Thống kê</a></li>
                            <li><a class="dropdown-item btn-info" href="<c:url value="/indexuser" />">Quản lý Nhân Viên</a></li>
                            </sec:authorize>
                    </ul>
                </li>


                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li class="nav-item ">
                            <a class=" btn btn-info  " href="<c:url value="/login" />">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class=" btn btn-info ms-1" href="<c:url value="/register" />">Đăng ký</a>
                        </li>
                    </c:when>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class=" btn btn-danger me-1 " href="<c:url value="/" />">Chào ${pageContext.request.userPrincipal.name}!</a>
                        </li>
                        <li class="nav-item">
                            <a class=" btn btn-info " href="<c:url value="/logout" />">Đăng xuất</a>
                        </li>
                    </c:when>

                </c:choose>

            </ul>
            <form action="<c:url value="/" />" class="d-flex">
                <input class="form-control me-2" name="kw" type="text" placeholder="Search">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

