<%-- 
Document   : index
Created on : May 5, 2024, 1:05:13 AM
Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section class="container">
    <h1 class="text-center text-info m-1">DANH MỤC CHUYẾN XE</h1>
    <div class="row">
        <div class="col-md-2 col-12 bg-secondary">
            <c:url value="/" var="action" />
            <form action="${action}">
                <div class="mb-3 mt-3">
                    <label for="kw" class="form-label">Từ khóa:</label>
                    <input type="text" class="form-control" id="kw" placeholder="Từ khóa..." name="q">
                </div>
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
            <a class="btn btn-info m-1" href="<c:url value="/chuyenxes" />">Thêm chuyến xe</a>
            <table class="table table-striped">
                <tr>
                    <th></th>
                    <th>Id</th>
                    <th>Tên tuyến</th>
                    <th>Gía</th>
                    <th>Ngày giờ khởi hành</th>
                    <th>Số chỗ</th>
                    <th>Loai xe</th>
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
                        <td>
                            <c:url value="/chuyenxes/${cx.id}" var="u" />
                            <a href="${u}" class="btn btn-success">&orarr;</a>

                            <c:url value="/api/chuyenxes/${cx.id}" var="uD" />
                            <button onclick="deleteChuyenXe('${uD}', ${cx.id})" class="btn btn-danger">&times;</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section

