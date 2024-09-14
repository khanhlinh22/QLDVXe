package com.dv.pojo;

import com.dv.pojo.ChuyenXe;
import com.dv.pojo.KhachHang;
import com.dv.pojo.ThanhToan;
import com.dv.pojo.TuyenXe;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-09-14T13:23:11")
@StaticMetamodel(DatVe.class)
public class DatVe_ { 

    public static volatile SingularAttribute<DatVe, TuyenXe> tuyenXeDvId;
    public static volatile SingularAttribute<DatVe, Integer> soChoDat;
    public static volatile SingularAttribute<DatVe, String> trangThai;
    public static volatile SingularAttribute<DatVe, KhachHang> khachHangId;
    public static volatile SingularAttribute<DatVe, Date> ngayDat;
    public static volatile CollectionAttribute<DatVe, ThanhToan> thanhToanCollection;
    public static volatile SingularAttribute<DatVe, Integer> id;
    public static volatile SingularAttribute<DatVe, ChuyenXe> chuyenXeDvId;

}