/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.update;

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
public class UserUpdateQuery {
    
    public void userGuncelle(String yeniUserName, String yeniUserPass, String yeniUserMail){
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = null;
        
        try{
            
            transaction = session.beginTransaction();
            
            String hql = "UPDATE User set userName = :uN, userPassword = :uP, userMail = :uM where userId = :userId";
            Query query = session.createQuery(hql);
            query.setParameter("uN", yeniUserName);
            query.setParameter("uP", yeniUserPass);
            query.setParameter("uM", yeniUserMail);
            query.setParameter("userId", 1);
            
            query.executeUpdate();
            
            transaction.commit();
        }
        
        catch(HibernateException e){
            
            transaction.rollback();
            e.printStackTrace();
        }
        
        finally{
            session.flush();
            session.close();
        }
    }
    
    
    public void userNamePassGuncelle(String yeniUserName, String yeniUserPass){
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = null;
        
        try{
            
            transaction = session.beginTransaction();
            
            String hql = "UPDATE User set userName = :uN, userPassword = :uP where userId = :userId";
            Query query = session.createQuery(hql);
            query.setParameter("uN", yeniUserName);
            query.setParameter("uP", yeniUserPass);
            query.setParameter("userId", 1);
            
            query.executeUpdate();
            
            transaction.commit();
        }
        
        catch(HibernateException e){
            
            transaction.rollback();
            e.printStackTrace();
        }
        
        finally{
            session.flush();
            session.close();
        }
    }
}
