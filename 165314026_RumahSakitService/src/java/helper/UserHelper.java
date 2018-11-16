/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.User;
import util.RumahSakitHibernateUtil;

/**
 *
 * @author ASUS
 */
public class UserHelper {

    public UserHelper() {
    }
    
    public User login(String email, String password) {
        Session session = RumahSakitHibernateUtil.getSessionFactory().openSession();
        String q = "From User a where a.email=:email AND a.password=:password";
        
        Query query = session.createQuery(q);
        query.setParameter("email", email);
        query.setParameter("password", password);
        
        return (User) query.uniqueResult();
//    public User cariUser(String email) {
//        // create session
//        Session session = RumahSakitHibernateUtil.getSessionFactory().openSession();
//        // create String query
//        String query = "from User u where u.email =:email";
//        Query q = session.createQuery(query);
//        q.setParameter("email", email);
//        // siapkan list, hasil pencarian dan panggil pencarinya
//        List<User> list = q.list();
//        //tutup session
//        session.close();
//        if (list.size() > 0) {
//            return list.get(0);
//        } else {
//            return null;
//        }
//    }
//
//    public boolean login(String email, String password) {
//        User user = this.cariUser(email);
//        if (user != null) {
//            //user ada
//            if (user.getPassword().equals(password)) {
//                // password sama
//                return true;
//            } else {
//                //password berbeda
//                return false;
//            }
//        } else {
//            // user tidak ada
//            return false;
//        }
//    }
//
////    public User user(String email, String password) {
////        User user = new User();
////        return user;
////    }
//    public List<User> getAllUser() {
//        List<User> result = null;
//        Session session = RumahSakitHibernateUtil.getSessionFactory().openSession();
//        String query = "from User u";
//        Query q = session.createQuery(query);
//        result = q.list();
//        session.close();
//        return result;
//    }
//
//    public User getUser(String username, String password) {
//        List<User> list = this.getAllUser();
//        Collections.sort(list);
//        User user = new User(username, password);
//        int index = Collections.binarySearch(list, user);
//        if (index < 0) {//user tiada
//            return null;
//        } else {
//            User result = list.get(index);
////            System.out.println("Pencarian "+result.getEmail()+ ", " +result.getPassword());
//            if (password.equals(result.getPassword())) {//pass benar
//                System.out.println("Password = " + password);
//                return user;
//            } else {//pass salah
//                return null;
//            }
//        }
    }
}
