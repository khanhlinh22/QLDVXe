<%-- 
    Document   : stats
    Created on : Sep 18, 2024, 12:10:29 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.math.RoundingMode" %>

<h1 class="text-center text-primary mt-1">THỐNG KÊ DOANH THU</h1>

<div class="row">
    <div class="col-md-5 col-12">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Tên chuyến xe</th>
                <th>Tổng doanh thu</th>
            </tr>
            <c:forEach items="${revenues}" var="r">
                <tr>
                    <td>${r[0]}</td>
                    <td>${r[1]}</td>
                    <td>${String.format("%.2f", r[2])} VNĐ</td>
      
                </tr>

            </c:forEach>
        </table>
    </div>
    <div class="col-md-7 col-12">
        <canvas id="myChart"></canvas>
    </div>
</div>

<hr class="hr" />
<div class="row">
    <div class="col-md-5 col-12">
        <form>
            <div class="form-floating mb-3 mt-3">
                <input type="text" value="${param.year}" class="form-control" id="year" placeholder="Năm" name="year">
                <label for="year">Năm</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <select class="form-select" id="period" name="period">
                    <option value="MONTH" selected>Theo tháng</option>
                    <c:choose>
                        <c:when test="${param.period=='QUARTER'}">
                            <option value="QUARTER" selected>Theo quý</option>
                        </c:when>
                        <c:otherwise>
                            <option value="QUARTER">Theo quý</option>
                        </c:otherwise>
                    </c:choose>
                </select>
                <label for="period" class="form-label">Chọn thời gian:</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <button class="btn btn-success">Lọc</button>
            </div>
        </form>
        <%@ page import="java.util.Date" %>
        <jsp:useBean id="now" class="java.util.Date" />
        <c:if test="${param.year != null}">
            <div class="alert alert-info">
                <h4>Năm: ${param.year}</h4>
                <h4>Thời gian: ${param.period}</h4>
            </div>
        </c:if>
        <table class="table table-striped">
            <tr>
                <th>Thời gian</th>
                <th>Doanh thu</th>
            </tr>
            <c:forEach items="${revenueByPeriod}" var="p">
                <tr>
                    <td>${p[0]}</td>
                    <td>  <fmt:formatNumber value="${p[1]}" type="currency" maxFractionDigits="2" /></td>
                 
                </tr>
            </c:forEach>
        </table>


    </div>


    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        let labels = [];
        let data = [];
        <c:forEach items="${revenues}" var="r">
        labels.push('${r[1]}');
        data.push(${r[2]});
        </c:forEach>

        window.onload = function () {
            const ctx = document.getElementById('myChart');

            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                            label: '# Doanh thu',
                            data: data,
                            borderWidth: 1
                        }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });

        }
    </script>