<%-- 
    Document   : indexuser
    Created on : Oct 4, 2024, 2:50:33 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" />


<section class="container">
    <h1 class="text-center text-info m-1">DANH MỤC NHÂN VIÊN</h1>
    <c:url value="indexuser" var="action" />

    <div class="row">

        <div class="col-md-10 col-12">



            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <div>
                    <a class="btn btn-info m-1" href="<c:url value='/admin/qlnvs' />">THÊM MỚI NHÂN VIÊN</a>              
                </div>
            </sec:authorize>



            <table class="table table-striped">
                <tr>
                    <th></th>
                    <th>Id</th>
                    <th>Tên Và Tên </th>
                    <th>Email</th>
                    <th>Role</th>
                    <th></th>
                </tr>
                <c:forEach items="${nguoiDungs}" var="nd">
                    <tr id="nguoidung${nd.id}">
                        <td>
                            <img src="${nd.avatar}" width="120" />
                        </td>
                        <td>${nd.id}</td>
                        <td>${nd.ho} ${nd.ten}</td>
                        <td>${nd.email}</td>
                        <td>${nd.roleName}</td>
                        <td>    
                            <c:url value="/admin/qlnvs/${nd.id}" var="u" />
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="${u}" class="btn btn-success">&orarr;</a>
                            </sec:authorize>
                            <c:url value="/api/qlnvs/${nd.id}" var="uD" />
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <button onclick="deleteNguoiDung('${uD}', ${nd.id})" class="btn btn-danger">&times;</button>
                            </sec:authorize>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>

