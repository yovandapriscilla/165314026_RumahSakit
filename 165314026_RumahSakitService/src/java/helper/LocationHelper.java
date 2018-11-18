package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Location;
import util.RumahSakitHibernateUtil;

public class LocationHelper {
    public LocationHelper() {
    }
    
    public List<Location> getLocation() {
        Session session = RumahSakitHibernateUtil.getSessionFactory().openSession();
        String query = "from Location";
        Query q = session.createQuery(query);
        List<Location> list = q.list();
        return list;
    }
    
    public Location cariLokasi(String nama) {
        Session session = RumahSakitHibernateUtil.getSessionFactory().openSession();
        Transaction trn = session.beginTransaction();
        String query = "from Location u where u.nama=:nama";
        Query q = session.createQuery(query);
        q.setParameter("nama", nama);
        List<Location> list = q.list();
        trn.commit();
        session.close();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
    
    public void addNewLocation(
            double lat,
            double lng,
            String name ) {
        Session session = RumahSakitHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Location klinik = new Location(lat, lng, name);
        session.saveOrUpdate(klinik);
        transaction.commit();
        session.close();
    }
}
