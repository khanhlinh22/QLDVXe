package com.dv.pojo;

import com.dv.pojo.KhachHang;
import com.dv.pojo.NhanVien;
import com.dv.pojo.TaiXe;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-09-18T02:38:25")
@StaticMetamodel(NguoiDung.class)
public class NguoiDung_ { 

    public static volatile SetAttribute<NguoiDung, TaiXe> taiXeSet;
    public static volatile SingularAttribute<NguoiDung, String> sdt;
    public static volatile SingularAttribute<NguoiDung, String> ho;
    public static volatile SingularAttribute<NguoiDung, String> avatar;
    public static volatile SetAttribute<NguoiDung, NhanVien> nhanVienSet;
    public static volatile SingularAttribute<NguoiDung, String> cccd;
    public static volatile SingularAttribute<NguoiDung, Integer> namSinh;
    public static volatile SingularAttribute<NguoiDung, String> password;
    public static volatile SetAttribute<NguoiDung, KhachHang> khachHangSet;
    public static volatile SingularAttribute<NguoiDung, String> roleName;
    public static volatile SingularAttribute<NguoiDung, Integer> id;
    public static volatile SingularAttribute<NguoiDung, String> ten;
    public static volatile SingularAttribute<NguoiDung, String> email;
    public static volatile SingularAttribute<NguoiDung, String> username;

}