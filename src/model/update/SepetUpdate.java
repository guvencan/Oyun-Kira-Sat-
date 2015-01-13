/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.update;

import model.POJO.Kategori;
import model.POJO.Sepet;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author siyah-pc
 */
public class SepetUpdate {
    
        public void SepetEkle(int id,int sayac) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        
         String hql = "UPDATE Musteri SET MusteriId=:musteriId WHERE MusteriId = :as";
            Query query = session.createQuery(hql);
            query.setParameter("as", id);
            query.executeUpdate();
        
       
        
         //session.save();
         session.getTransaction().commit();
        
    }
    
}
