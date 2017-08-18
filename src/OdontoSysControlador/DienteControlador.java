/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Diente;
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
public class DienteControlador {

    public static ArrayList<Diente> BuscarPorNombre(String nombreDiente) {
        ArrayList<Diente> listDiente = new ArrayList<>();
        Session session;
        Transaction tr = null;
        try {
            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql;
            if(nombreDiente.compareTo("") == 0){
                hql = "from Diente s";
            }else{
                hql = "from Diente d where d.nombre like '%"
                    + nombreDiente+ "%'";
            }
            
            
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();
            
            while(it.hasNext()) {
                Diente adiente = (Diente) it.next();
                listDiente.add(adiente);
            }
            
        } catch (HibernateException ex) {
            System.out.println("problemas en el controlador catcheado en el controlador");
        }
        
        return listDiente;
    }
    
    public static Diente BuscarDiente(int nomenclatura){
        Session session;
        Transaction tr = null;
        Diente diente = null;
        try {
            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql = "from Diente d where d.nomenclatura = "+nomenclatura;
            
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();
            
            if(it.hasNext()){
                diente = (Diente)it.next();
            }
            
        } catch (HibernateException ex) {
            System.out.println("problemas en el controlador catcheado en el controlador");
        }
            
        return diente;
    }
    
}
