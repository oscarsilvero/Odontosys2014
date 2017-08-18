/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.DetalleOrden;
import OdontoSysModelo.OrdenServicio;
import OdontoSysUtil.NewHibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class OrdenServicioControlador {
    
    public static ArrayList<OrdenServicio> BuscarOrdenPendiente(int idPaciente){
        Session sesion;
        Transaction tr = null;
        OrdenServicio o = null;
        ArrayList<OrdenServicio> lista = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();

            String hql = "FROM OrdenServicio o WHERE o.paciente = "+ idPaciente+ " AND estado = 'Pendiente'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                lista = new ArrayList();
                while(it.hasNext()) {
                    OrdenServicio orden = (OrdenServicio) it.next();
                    lista.add(orden);
                } 
            }
        } catch(HibernateException ex){
               JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Orden de Servicio Controlador", JOptionPane.INFORMATION_MESSAGE);
         }
        return lista;
    }
    
    public static ArrayList<DetalleOrden> BuscarDetalleOrden(int idOrden) {
        ArrayList<DetalleOrden> listdetalles = new ArrayList<>();
        Session session;
        Transaction tr = null;
        try {
            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql = "FROM DetalleOrden WHERE ordenServicio = " + idOrden;
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();            
            while(it.hasNext()) {
                DetalleOrden detalle = (DetalleOrden) it.next();
                listdetalles.add(detalle);
            }            
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Orden de Servicio Controlador", JOptionPane.INFORMATION_MESSAGE);
         }        
        return listdetalles;
    }
    
    
    public static ArrayList<OrdenServicio> BuscarOrdenPaciente(int idPaciente) {
        ArrayList<OrdenServicio> lista = new ArrayList<>();
        Session session;
        Transaction tr = null;
        try {
            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql = "FROM OrdenServicio WHERE paciente = " + idPaciente + " ORDER BY fecha DESC";
            Query query = session.createQuery(hql);
            Iterator it = query.iterate(); 
            if(it.hasNext()){
                do{
                    OrdenServicio detalle = (OrdenServicio) it.next();
                    lista.add(detalle);
                }while(it.hasNext());   
            }else{
                return null;
            }
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Orden de Servicio Controlador", JOptionPane.INFORMATION_MESSAGE);
         }        
        return lista;
    }
    
    public static OrdenServicio insertOrdenServicio(OrdenServicio ordenActual){
        Session session;
        Transaction tr = null;
        
        try {
            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.save(ordenActual);
            session.refresh(ordenActual);
            tr.commit();
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Orden de Servicio Controlador", JOptionPane.INFORMATION_MESSAGE);
         }        
        
        return ordenActual;
    }
    
    
}
