package model.delete;

import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class MusteriSil{
    
    public void MusteriSilindi(int id){
        
         Session session = HibernateUtil.getSessionFactory().openSession();
        try{
           
        session.beginTransaction();
            
            String hql = "DELETE FROM Musteri WHERE MusteriId = :as";
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
