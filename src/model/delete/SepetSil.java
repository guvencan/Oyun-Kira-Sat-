/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.delete;

import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author siyah-pc
 */
public class SepetSil {

    public void Sil() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
           
        session.beginTransaction();
            
            String hql = "TRUNCATE TABLE sepet";
            SQLQuery query = session.createSQLQuery(hql);
            query.executeUpdate();
            


        
    }
    
    
}
