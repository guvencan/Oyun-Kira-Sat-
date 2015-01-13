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
 * @author cryptex
 */
public class PlatformListele {
    
     public List platformListele(String arananKelime) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Platform E WHERE E.platformAdi like " +" '" +arananKelime + "%" + "'";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        return results;
    }
     
     
         public void platformSil(int param) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "delete from Platform E where E.platformId = :platform";
        Query query = session.createQuery(hql);
        query.setParameter("platform", param);
        query.executeUpdate();
        
        session.getTransaction().commit();
        session.close();
        
    }
    
    
}
