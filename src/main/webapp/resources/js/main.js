function deleteChuyenXe(endpoint, chuyenXeId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "DELETE"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`chuyenxe${chuyenXeId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}
function deleteNguoiDung(endpoint, nguoiDungId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "DELETE"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`nguoidung${nguoiDungId}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}
function drawChartRevenue(ctx, labels, data, title="Doanh thu") {
    let colors = [];
    for (let i = 0; i < data.length; i++)
        colors.push(`rgba(${parseInt(Math.random()*255)}, 
        ${parseInt(Math.random()*255)}, 
        ${parseInt(Math.random()*255)}, 0.7)`);
    
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: title,
                    data: data,
                    borderWidth: 1,
                    backgroundColor: colors
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