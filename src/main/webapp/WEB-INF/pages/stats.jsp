<%-- 
    Document   : stats
    Created on : Sep 18, 2024, 12:10:29 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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