/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.NguoiDung;
import com.dv.repositoties.NguoiDungRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class NguoiDungRepositoryImpl implements NguoiDungRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder PasswordEncoder;

    @Override
    public boolean addUser(NguoiDung nguoiDung) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(nguoiDung);
            return true;
        } catch (HibernateException ex) {
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
        if (!username.isEmpty()) {
            Predicate p = b.equal(r.get("username").as(String.class), username.trim());
            q = q.where(p);
        }
        org.hibernate.query.Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public NguoiDung getNguoiDungByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        org.hibernate.query.Query query = s.createQuery("FROM NguoiDung WHERE username = :username");
        query.setParameter("username", username);
        return (NguoiDung) query.getSingleResult();
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NguoiDung addNguoiDung(NguoiDung nguoiDung) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(nguoiDung);
        return nguoiDung;
    }

    @Override
    public boolean authUser(String username, String password) {
        NguoiDung nd = this.getNguoiDungByUsername(username);
        if (nd == null) {
            return false; // Hoặc ném một ngoại lệ tùy chỉnh
        }
        return this.PasswordEncoder.matches(password, nd.getPassword());
    }

    @Override
    public List<NguoiDung> getNguoiDungs(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Tạo một CriteriaQuery cho NguoiDung
        CriteriaQuery<NguoiDung> query = builder.createQuery(NguoiDung.class);
        Root<NguoiDung> root = query.from(NguoiDung.class);
        query.select(root);

        // Tạo danh sách các điều kiện (Predicate)
        List<Predicate> predicates = new ArrayList<>();

        // Kiểm tra các tham số trong map và thêm điều kiện vào danh sách predicates
        if (params.containsKey("username") && !params.get("username").isEmpty()) {
            Predicate usernamePredicate = builder.equal(root.get("username"), params.get("username").trim());
            predicates.add(usernamePredicate);
        }

        if (params.containsKey("email") && !params.get("email").isEmpty()) {
            Predicate emailPredicate = builder.equal(root.get("email"), params.get("email").trim());
            predicates.add(emailPredicate);
        }

        if (params.containsKey("role") && !params.get("role").isEmpty()) {
            Predicate rolePredicate = builder.equal(root.get("roleName"), params.get("role").trim());
            predicates.add(rolePredicate);
        }

        // Nếu có ít nhất một predicate, thêm vào điều kiện where
        if (!predicates.isEmpty()) {
            query.where(builder.and(predicates.toArray(new Predicate[0])));
        }

        // Thực hiện truy vấn
        org.hibernate.query.Query<NguoiDung> hQuery = session.createQuery(query);
        return hQuery.getResultList();
    }

    @Override
    public void addOrUpdate(NguoiDung nd) {
        Session s = this.factory.getObject().getCurrentSession();
        if (nd.getId() != null) {
            s.update(nd);
        } else {
            s.save(nd);
        }
    }

    @Override
    public NguoiDung getNguoiDungById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(NguoiDung.class, id);
    }

    @Override
    public void deleteNguoiDung(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        NguoiDung nd = this.getNguoiDungById(id);
        s.delete(nd);
    }

}
