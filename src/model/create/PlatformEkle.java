/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.create;

import model.POJO.Kategori;
import model.POJO.Platform;
import model.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author cryptex
 */
public class PlatformEkle {
    
      public void platformEkle(String platformAdi) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Platform platform = new Platform(platformAdi);
        session.save(platform);
         session.getTransaction().commit();
        
    }
    
}
