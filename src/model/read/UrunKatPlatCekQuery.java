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
public class UrunKatPlatCekQuery {
    
    public List kategoriSorgu() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "select E.kategoriAdi from Kategori E";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        session.getTransaction().commit();
        
        return results;
    }
    
    
    public List platformSorgu() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "select E.platformAdi from Platform E";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        session.getTransaction().commit();
        
        return results;
    }
    
    public List kategoriCek(String string) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "from Kategori E where E.kategoriAdi like '"+string+"%'";
       
        Query query = session.createQuery(hql);
        
        List results = query.list();
        
        session.getTransaction().commit();
        
        return results;
    }
    
    
    public List kategoriCekID(String string) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "select E.kategoriId from Kategori E where E.kategoriAdi like '"+string+"%'";
       
        Query query = session.createQuery(hql);
        
        List results = query.list();
        
        session.getTransaction().commit();
        
        return results;
    }
    
     public List platformCek(String string) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "from Platform E where E.platformAdi like '"+string+"%'";
       
        Query query = session.createQuery(hql);
        
        List results = query.list();
        
        session.getTransaction().commit();
        
        return results;
    }
     
     public List platformCekID(String string) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "select E.platformId from Platform E where E.platformAdi like '"+string+"%'";
       
        Query query = session.createQuery(hql);
        
        List results = query.list();
        
        session.getTransaction().commit();
        
        return results;
    }
    
}
