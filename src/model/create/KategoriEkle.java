/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.create;

import model.POJO.Kategori;
import model.POJO.Urun;
import model.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author cryptex
 */
public class KategoriEkle {
    
    public void kategoriEkle(String kategoriAdi) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Kategori kategori = new Kategori(kategoriAdi);
        session.save(kategori);
         session.getTransaction().commit();
        
    }
    
}
