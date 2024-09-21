/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;
import com.dv.pojo.NguoiDung;
import com.dv.repositoties.NguoiDungRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class NguoiDungRepositoryImpl implements  NguoiDungRepository{
  @Autowired
    private LocalSessionFactoryBean factory;
  @Autowired
  private BCryptPasswordEncoder PasswordEncoder;
   
    
    @Override
    public boolean addUser(NguoiDung nguoiDung) {
         Session s = this.factory.getObject().getCurrentSession();
        try{
             s.save(nguoiDung);
             return true;
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<NguoiDung> getUsers(String username) {
        Session s = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = s.getCriteriaBuilder();//Muốn lấy điều kiện

            CriteriaQuery<NguoiDung> q = b.createQuery(NguoiDung.class);//Tạo những lệnh truy vấn đến bảng nào

            Root r = q.from(NguoiDung.class);//Muốn lấy trường (column)
            q = q.select(r);
            if(!username.isEmpty()){
                Predicate p = b.equal(r.get("username").as(String.class), username.trim());
                q = q.where(p);
            }
            org.hibernate.query.Query query = s.createQuery(q);
            return query.getResultList();
    }
    @Override
    public NguoiDung getNguoiDungByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        org.hibernate.query.Query query = s.createQuery("FROM nguoi_dung WHERE username = :username");
        query.setParameter("username", username);
        return (NguoiDung) query.getSingleResult();
    }
    
    @Override
    public void addNguoiDung(NguoiDung nd) {
       
       
    }

   

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean authUser(String username, String password) {
        NguoiDung nd = this.getNguoiDungByUsername(username);
        return this.PasswordEncoder.matches(password,nd.getPassword());
    }
    
    
}
