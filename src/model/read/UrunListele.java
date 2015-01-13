/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.read;

import java.util.List;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author cryptex
 */
public class UrunListele {
    
    public List urunListele(String arananKelime) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Urun E WHERE E.urunAdi like " +" '" +arananKelime + "%" + "'";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        return results;
    }
    
    
    public List urunListele() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Urun";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        return results;
    }
    
     public void urunSil(int param) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "delete from Urun E where E.urunId = :urun";
        Query query = session.createQuery(hql);
        query.setParameter("urun", param);
        query.executeUpdate();
        
        session.getTransaction().commit();
        session.close();
        
    }
     
         public List urunTableCek() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Urun ";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        return results;
    }
         
      public List urunCokSatan() {

      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();

      String hql = "SELECT UrunID,count(UrunID),sum(S.SatisFiyat) FROM Satisgecmis S group by UrunID";
      SQLQuery query = session.createSQLQuery(hql);
      List results = query.list();

      return results;
      
    }
      
      public List urunListeleKatID(int id) {
          
          Session session = HibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
          
          String hql = "From Urun where kategoriId = "+id;
          Query query =session.createQuery(hql);
         // query.setParameter("id", id);
          List results = query.list();
          
          return results;
          
      }
      
      public List urunListelePlatID(int id) {
          
          Session session = HibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
          
          String hql = "From Urun where platformId = "+id;
          Query query =session.createQuery(hql);
         // query.setParameter("id", id);
          List results = query.list();
          
          return results;
          
      }
      
      public List urunAnasayfa() {
          
          Session session = HibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
          
////          INNER JOIN u.platform p   , p.platformAdi
        
        String hql = " FROM Urun ";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        return results;
          
      }

    
}
