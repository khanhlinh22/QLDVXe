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
