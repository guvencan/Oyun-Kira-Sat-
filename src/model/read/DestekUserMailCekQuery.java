/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.read;

import java.util.List;
import model.POJO.User;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author asaidpalamut
 */
public class DestekUserMailCekQuery {
    
    public String userMailAl(){
        
        List<User> result;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = null;
        
        try{
            
            transaction = session.beginTransaction();
            
            String sql = "SELECT userMail FROM user;";
            Query query = session.createSQLQuery(sql);
            result = query.list();
            
            String mail = String.valueOf(result.get(0));
            
            transaction.commit();
            
            return mail;
        }
        
        catch(HibernateException e){
            
            transaction.rollback();
            e.printStackTrace();
        }
        
        finally{
            
            session.flush();
            session.close();
        }
        
        return null;
        
    }
    
}
