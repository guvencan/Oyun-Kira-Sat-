/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.read;

import java.util.List;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author siyah-pc
 */
public class MusteriListele {

    public List MusteriListele() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        
        String hql = "FROM Musteri";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        session.getTransaction().commit();
        
        return results;
    }
    
    public List MusteriBul(String aranan) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        
        String hql = "FROM Musteri Where musteriId ="+aranan;
        Query query = session.createQuery(hql);
        List results = query.list();
        
        session.getTransaction().commit();
        
        return results;
        
    }
    
    
    
}
