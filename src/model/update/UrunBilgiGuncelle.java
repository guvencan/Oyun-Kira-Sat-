/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.update;

import java.util.List;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author cryptex
 */
public class UrunBilgiGuncelle {
    
    
    public void urunBilgiGuncelle(String urunAdi,int kategori,int platform,int satisFiyat,int kiraFiyat,int adet,int urunId) throws HibernateException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
         System.err.println(kategori);
         
        
        String hql = "UPDATE Urun set urunAdi = :urunAdi, kategoriId = :kategori, platformId = :platform, urunSatisFiyat = :satisFiyat, urunKiraFiyat = :kiraFiyat, "
                + "urunAdet = :adet "  + 
             "WHERE urunId = :urunId";
        
        System.out.println(hql);
        

        Query query = session.createQuery(hql);
        query.setParameter("urunAdi", urunAdi);
        query.setParameter("kategori", kategori);
        query.setParameter("platform", platform);
        query.setParameter("satisFiyat", satisFiyat);
        query.setParameter("kiraFiyat", kiraFiyat);
        query.setParameter("adet", adet);
        query.setParameter("urunId", urunId);
        query.executeUpdate();
        
        
        session.getTransaction().commit();
        
       
    }
    
}
