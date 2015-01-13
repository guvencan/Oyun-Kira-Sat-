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
 * @author siyah-pc
 */
public class SatisGecmisiListele {
    
    public List urunListele() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Satisgecmis";
        Query query = session.createQuery(hql);
        List results = query.list();
        //session.getTransaction().commit();
        return results;
    }
    
    public List SatisAra (String arananKelime) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "from Satisgecmis S where S. satisKiraTarih like " + "'"+ "%" +arananKelime + "%" +"'"+
                                        " OR " +"S. satisFiyat like " + "'"+ "%" +arananKelime + "%" +"'"+
                                        " OR " +"S.musteri.musteriAd like " + "'"+ "%" +arananKelime + "%" +"'"+
                                         " OR " +"S.urun.urunAdi like " + "'"+ "%" +arananKelime + "%" +"'";
                        
        Query query = session.createQuery(hql);
        List results = query.list();
        
        return results;
    }
    
    public List KiraListele() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "FROM Kirahareket";
        Query query = session.createQuery(hql);
        List results = query.list();
        //session.getTransaction().commit();
        return results;
    }
    
    public List KiraAra(String arananKelime){
        
         Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hql = "from Kirahareket S where S. kiraBaslangicTarih like " + "'"+ "%" +arananKelime + "%" +"'"+
                                        " OR " +"S. kiraSonTarih like " + "'"+ "%" +arananKelime + "%" +"'"+
                                        " OR " +"S.musteri.musteriAd like " + "'"+ "%" +arananKelime + "%" +"'"+
                                         " OR " +"S.urun.urunAdi like " + "'"+ "%" +arananKelime + "%" +"'";
                        
        Query query = session.createQuery(hql);
        List results = query.list();
        
        return results;
        
        
    }
    
    
}
