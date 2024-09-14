package com.dv.pojo;

import com.dv.pojo.DatVe;
import com.dv.pojo.NguoiDung;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-09-14T13:23:11")
@StaticMetamodel(KhachHang.class)
public class KhachHang_ { 

    public static volatile SingularAttribute<KhachHang, String> thongTinThanhToan;
    public static volatile CollectionAttribute<KhachHang, DatVe> datVeCollection;
    public static volatile SingularAttribute<KhachHang, NguoiDung> nguoiDungKhId;
    public static volatile SingularAttribute<KhachHang, Integer> id;

}