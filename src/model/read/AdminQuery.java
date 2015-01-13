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
public class AdminQuery {
    
    public String userNameAl(){
        
        String uN;
        List<User> result;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try{
            
            transaction = session.beginTransaction();
            String sql = "SELECT userName from user;";
            Query query = session.createSQLQuery(sql);
            result = query.list();
            
            uN = String.valueOf(result.get(0));
            transaction.commit();
            return uN;
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
    
    public String userPassAl(){
        
        String uP;
        List<User> result;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try{
            
            transaction = session.beginTransaction();
            String sql = "SELECT userPassword from user;";
            Query query = session.createSQLQuery(sql);
            result = query.list();
            
            uP = String.valueOf(result.get(0));
            transaction.commit();
            return uP;
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
    
    public String userMailAl(){
        
        String uM;
        List<User> result;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try{
            
            transaction = session.beginTransaction();
            String sql = "SELECT userMail from user;";
            Query query = session.createSQLQuery(sql);
            result = query.list();
            
            uM = String.valueOf(result.get(0));
            transaction.commit();
            return uM;
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
