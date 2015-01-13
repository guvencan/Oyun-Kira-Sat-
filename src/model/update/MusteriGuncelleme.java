package model.update;

import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class MusteriGuncelleme{
    
    public void MusteriGuncellendi(int id){
        
         Session session = HibernateUtil.getSessionFactory().openSession();
        try{
           
        session.beginTransaction();
            
            String hql = "UPDATE Musteri SET MusteriId=:musteriId WHERE MusteriId = :as";
            Query query = session.createQuery(hql);
            query.setParameter("as", id);
            query.executeUpdate();
                     
            session.getTransaction().commit();
            
        }
        
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        
       finally
       {
           
            session.close();
        }
    }
    
}
