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
public class KategoriListele {
    
    public List kategoriListele(String arananKelime) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Kategori E WHERE E.kategoriAdi like " +" '" +arananKelime + "%" + "'";
        Query query = session.createQuery(hql);
        List results = query.list();
        
        return results;
    }
    
    public void kategoriSil(int param) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "delete from Kategori E where E.kategoriId = :kategori";
        Query query = session.createQuery(hql);
        query.setParameter("kategori", param);
        query.executeUpdate();
        
        session.getTransaction().commit();
        session.close();
        
    }
    
    
}
