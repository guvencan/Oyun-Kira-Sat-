/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.create;

import model.POJO.Sepet;
import model.POJO.Sepetkira;
import model.POJO.Urun;
import model.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author siyah-pc
 */
public class SepetEkle {
    
        public void SepetEkle(Urun urunid) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Sepet sepet = new Sepet();
        sepet.setUrun(urunid);
        session.save(sepet);
        session.getTransaction().commit();
        
    }
        
     public void SepetKiraEkle(Urun urunid) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Sepetkira sepet = new Sepetkira();
        sepet.setUrun(urunid);
        session.save(sepet);
        session.getTransaction().commit();
        
    }    
    
}
