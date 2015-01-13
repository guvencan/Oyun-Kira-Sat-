/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.read;

import java.util.Iterator;
import java.util.List;
import model.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author siyah-pc
 */
public class CokSatList {

    public Iterator CokSatList() {
              
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    String SQL_QUERY ="SELECT U.UrunAdi,count(S.UrunID),sum(S.SatisFiyat) FROM Satisgecmis S   inner join Urun U on  S.UrunId = U.UrunId group by U.UrunId";
      
    //String SQL_QUERY = "SELECT UrunID,count(UrunID),sum(S.SatisFiyat) FROM Satisgecmis S group by UrunID";
     List results = session.createSQLQuery(SQL_QUERY).list(); 
     
    session.getTransaction().commit();  
     
     
     return (Iterator) results;   
    }

    
    
}
