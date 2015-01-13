/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.create;

import java.util.Date;

import model.POJO.Musteri;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author SEFACAN
 */
public class MusteriEkle {
    
    public void ekle(long musteriTc,String musteriAd,String musteriSoyad,String musteriMail,long musteriTel,String musteriAdres,Date musteriTarih,Integer musteriPuan)
    {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction t=session.beginTransaction();
        
        
        Musteri m=new Musteri();
        m.setMusteriTc(musteriTc);
        m.setMusteriAd(musteriAd);
        m.setMusteriSoyad(musteriSoyad);
        m.setMusteriMail(musteriMail);
        m.setMusteriTel(musteriTel);
        m.setMusteriAdres(musteriAdres);
        m.setMusteriTarih(musteriTarih);
        m.setMusteriPuan(musteriPuan);
        
        
        
        
        session.saveOrUpdate(null, m);
        session.getTransaction().commit();
        session.close();
        
        
    
    }
    
}
