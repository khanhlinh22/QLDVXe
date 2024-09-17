<%-- 
Document   : index
Created on : May 5, 2024, 1:05:13 AM
Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<section class="container">
    <h1 class="text-center text-info m-1">DANH MỤC CHUYẾN XE</h1>
    <div class="row">
        <div class="col-md-2 col-12 bg-secondary">
            <c:url value="/" var="action" />
            <form action="${action}">

                <div class="mb-3 mt-3">
                    <label for="fromPrice" class="form-label">Từ giá (VNĐ):</label>
                    <input type="number" class="form-control" id="fromPrice" placeholder="Từ giá..." name="fromPrice">
                </div>
                <div class="mb-3 mt-3">
                    <label for="toPrice" class="form-label">Đến giá (VNĐ):</label>
                    <input type="number" class="form-control" id="toPrice" placeholder="Đến giá..." name="toPrice">
                </div>
                <div class="mb-3 mt-3">
                    <button class="btn btn-info" type="submit">Tìm kiếm</button>
                </div>
            </form>
        </div>
        <div class="col-md-10 col-12">



            <sec:authorize access="hasRole('ADMIN')">
                <div>
                    <a class="btn btn-info m-1" href="<c:url value='/admin/chuyenxes' />">Thêm chuyến xe</a>              
                </div>
            </sec:authorize>



            <table class="table table-striped">
                <tr>
                    <th></th>
                    <th>Id</th>
                    <th>Tên tuyến</th>
                    <th>Giá</th>
                    <th>Ngày Giờ Khởi Hành</th>
                    <th>Số Chỗ</th>
                    <th>Trạng Thái</th>
                    <th></th>
                </tr>
                <c:forEach items="${chuyenXes}" var="cx">
                    <tr id="chuyenxe${cx.id}">
                        <td>
                            <img src="${cx.image}" width="120" />
                        </td>
                        <td>${cx.id}</td>
                        <td>${cx.tuyenXeId.getTenTuyen()}</td>
                        <td>${String.format("%,.2f", cx.giaVe)} VND</td>
                        <td>${cx.ngayGioKhoiHanh}</td>
                        <td>${cx.soCho}</td>
                        <td>${cx.trangThai}</td>
                        <td>    
                            <c:url value="/admin/chuyenxes/${cx.id}" var="u" />
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="${u}" class="btn btn-success">&orarr;</a>
                            </sec:authorize>
                            <c:url value="/api/chuyenxes/${cx.id}" var="uD" />

                            <!-- Use sec:authorize to conditionally display the button based on role -->
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <button onclick="deleteChuyenXe('${uD}', ${cx.id})" class="btn btn-danger">&times;</button>
                            </sec:authorize>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>

