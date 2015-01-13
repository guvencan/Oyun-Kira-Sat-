/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.create;

import java.util.Date;
import model.POJO.Musteri;
import model.POJO.Satisgecmis;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author siyah-pc
 */
public class SatisgecmisEkle {
    
        public void ekle(Satisgecmis satisgecmis){
            
            
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        
        session.saveOrUpdate(null,satisgecmis);
        
        session.getTransaction().commit();
        session.close();
        
        
    
    }
    
}
