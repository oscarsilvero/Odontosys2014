/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Hallazgo;
import OdontoSysUtil.NewHibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tito
 */
public class HallazgoControlador {
    public static ArrayList<Hallazgo> BuscarPorNombre(String nombre){
        ArrayList<Hallazgo> hallazgos = new ArrayList<>();
        Session session;
        Transaction tr = null;
        try {
            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql = "FROM Hallazgo h WHERE h.nombre LIKE '%"+ nombre+ "%'";
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();
            
            while(it.hasNext()) {
                Hallazgo rol = (Hallazgo) it.next();
                hallazgos.add(rol);
            }
            
        } catch (HibernateException ex) {
            System.out.println("problemas en el controlador catcheado en el controlador");
        }
        
        return hallazgos;
    }
        
        
        
    
}
