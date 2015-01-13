/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.create;

import model.POJO.Kategori;
import model.POJO.Platform;
import model.POJO.Urun;
import model.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author cryptex
 */
public class UrunEkle {
    
    
    
    public void urunEkle(Kategori kategori, Platform platform, String urunAdi, int urunKiraFiyat, int urunSatisFiyat, byte[] urunResim, int urunAdet) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Urun urun = new Urun(kategori,platform,urunAdi,urunKiraFiyat,urunSatisFiyat,urunResim,urunAdet);
        session.save(urun);
         session.getTransaction().commit();
        
    }
    
}
