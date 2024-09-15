package com.dv.pojo;

import com.dv.pojo.ChuyenXe;
import com.dv.pojo.DatVe;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-09-16T02:27:42")
@StaticMetamodel(TuyenXe.class)
public class TuyenXe_ { 

    public static volatile SetAttribute<TuyenXe, DatVe> datVeSet;
    public static volatile SingularAttribute<TuyenXe, String> khoangCach;
    public static volatile SingularAttribute<TuyenXe, String> tanSuat;
    public static volatile SingularAttribute<TuyenXe, String> diemDi;
    public static volatile SingularAttribute<TuyenXe, Integer> id;
    public static volatile SingularAttribute<TuyenXe, String> tenTuyen;
    public static volatile SingularAttribute<TuyenXe, String> diemDen;
    public static volatile SetAttribute<TuyenXe, ChuyenXe> chuyenXeSet;

}