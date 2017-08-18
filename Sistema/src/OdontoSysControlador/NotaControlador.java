/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Caja;
import OdontoSysModelo.DetalleNota;
import OdontoSysModelo.DetalleNotaEmp;
import OdontoSysModelo.Factura;
import OdontoSysModelo.Movimiento;
import OdontoSysModelo.MovimientoEmpresa;
import OdontoSysModelo.NotaCredito;
import OdontoSysModelo.NotaCreditoEmpresa;
import OdontoSysUtil.NewHibernateUtil;
import static java.awt.image.ImageObserver.WIDTH;
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
public class NotaControlador {
 
    public static NotaCredito insertarNota(NotaCredito nuevo, Session sesion) {
        //Session sesion;
        try{
            //sesion = NewHibernateUtil.getSessionFactory().openSession();
            //sesion.getTransaction().begin();
            sesion.save(nuevo);
            sesion.refresh(nuevo);
            //sesion.getTransaction().commit();
            agregarMovimientoNota(nuevo, sesion);
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Nota Credito", WIDTH );
       }        
        return nuevo;
    }

    public static boolean actualizarSaldo(NotaCredito f, Session session) {
        boolean i = false;
        try{         
            //Session session = NewHibernateUtil.getSessionFactory().openSession();
            //Transaction tx = session.beginTransaction();
            int m = f.getFactura().getSaldo() - f.getTotal();
            String hqlUpdate = "UPDATE Factura SET saldo = "+m+" WHERE idFactura = "+f.getFactura().getIdfactura();
            Query updatedEntities = session.createQuery( hqlUpdate );
            updatedEntities.executeUpdate();
            //tx.commit();
            if(m == 0){
                //tx = session.beginTransaction();
                hqlUpdate = "UPDATE Factura SET estado = 'Cancelado' WHERE idFactura = " + f.getFactura().getIdfactura();
                updatedEntities = session.createQuery( hqlUpdate );
                updatedEntities.executeUpdate();
                //tx.commit();
            }        
            i = true;
       }catch(HibernateException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Actualizar saldo Factura", WIDTH );
       }        
       return i; 
    }
    
    public static ArrayList<NotaCredito> ConsultarNotas(int idFactura){
        Session sesion;
        Transaction tr = null;
        ArrayList<NotaCredito> datos = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM NotaCredito WHERE factura = " + idFactura;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            int x;
            datos = new ArrayList();
            NotaCredito not = new NotaCredito();
            for(;it.hasNext();){
                not = (NotaCredito) it.next();
                datos.add(not);
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Nota de Crédito Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return datos;
    }
    
    public static boolean insertarDetalleNota(ArrayList<DetalleNota> detalle, Session session) {
        //Session session;
        //Transaction tr = null;
        boolean act = false;
        DetalleNota aux;
        
        try{       
            //session = NewHibernateUtil.getSessionFactory().openSession();
            //tr = session.beginTransaction();
            Iterator<DetalleNota> it = detalle.iterator();
            
                while(it.hasNext()){
                    aux = it.next();
                    session.save(aux); 
                    session.refresh(aux);                    
                }
                //tr.commit();
                               
                act = true;
        }catch(HibernateException ex){
                JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos InserDetalle", "Detalle Recibo Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return act;
    }
    
    public static NotaCreditoEmpresa insertarNotaEmpresa(NotaCreditoEmpresa nuevo, Session sesion) {
        //Session sesion;
        try{
            //sesion = NewHibernateUtil.getSessionFactory().openSession();
            //sesion.getTransaction().begin();
            sesion.save(nuevo);
            sesion.refresh(nuevo);
            //sesion.getTransaction().commit();
            insertarMovimientoEmpresa(nuevo, sesion);
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Nota Credito", WIDTH );
       }        
        return nuevo;
    }
    
    public static boolean insertarDetalleNotaEmpresa(ArrayList<DetalleNotaEmp> detalle, Session session) {
        //Session session;
        //Transaction tr = null;
        boolean act = false;
        DetalleNotaEmp aux;
        
        try{       
            //session = NewHibernateUtil.getSessionFactory().openSession();
            //tr = session.beginTransaction();
            Iterator<DetalleNotaEmp> it = detalle.iterator();
            
                while(it.hasNext()){
                    aux = it.next();
                    int i = (Integer) session.save(aux);                    
                }
            //tr.commit();
            act = true;
        }catch(HibernateException ex){
                JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos InserDetalle", "Detalle Nota de Crédito Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return act;
    }
    
    public static boolean actualizarSaldoFacEmpresa(NotaCreditoEmpresa f, Session session) {
        boolean i = false;
        try{         
            //Session session = NewHibernateUtil.getSessionFactory().openSession();
            //Transaction tx = session.beginTransaction();
            int m = f.getFacturaEmpresa().getSaldo() - f.getTotal();
            String hqlUpdate = "UPDATE FacturaEmpresa SET saldo = "+m+" WHERE idFactura = "+f.getFacturaEmpresa().getIdfacturaEmpresa();
            Query updatedEntities = session.createQuery( hqlUpdate );
            updatedEntities.executeUpdate();
            //tx.commit();
            if(m == 0){
                //tx = session.beginTransaction();
                hqlUpdate = "UPDATE FacturaEmpresa SET estado = 'Cancelado' WHERE idFactura = " + f.getFacturaEmpresa().getIdfacturaEmpresa();
                updatedEntities = session.createQuery( hqlUpdate );
                updatedEntities.executeUpdate();
                //tx.commit();
            }
            i = true;
       }catch(HibernateException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Actualizar saldo Factura", WIDTH );
       }        
       return i; 
    }

    private static void agregarMovimientoNota(NotaCredito nuevo, Session sesion) {
        Movimiento m = new Movimiento();
        //Session sesion;
        try{
            //sesion = NewHibernateUtil.getSessionFactory().openSession();
            //sesion.getTransaction().begin();

            m.setPaciente(nuevo.getPaciente());
            m.setMovimiento("Nota de Crédito a Factura Nro "+nuevo.getFactura().getNroFactura());
            m.setFecha(nuevo.getFecha());
            m.setDebe(0);
            m.setHaber(nuevo.getTotal());
                       
            sesion.save(m);
            sesion.refresh(m);
            
            if(nuevo.getFactura().getEstado().compareTo("Cancelado") == 0){  // Si la nota da salida a caja
                insertarMovimientoCaja(nuevo, m, null,  null, sesion);
            } 
            
            //sesion.getTransaction().commit();  
            //sesion.close();          
            
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento", WIDTH );
        }  
    }
    
    public static ArrayList<NotaCreditoEmpresa> ConsultarNotasEmpresa(int idFactura){
        Session sesion;
        Transaction tr = null;
        ArrayList<NotaCreditoEmpresa> datos = null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM NotaCreditoEmpresa WHERE facturaEmpresa = " + idFactura;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            datos = new ArrayList();
            NotaCreditoEmpresa not = new NotaCreditoEmpresa();
            for(;it.hasNext();){
                not = (NotaCreditoEmpresa) it.next();
                datos.add(not);
            }
        }catch(HibernateException ex){
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Nota de Crédito Controlador", JOptionPane.INFORMATION_MESSAGE);
                   }
        return datos;
    }

    private static void insertarMovimientoEmpresa(NotaCreditoEmpresa nuevo, Session sesion) {
        MovimientoEmpresa m = new MovimientoEmpresa();
        //Session sesion;
        try{
            //sesion = NewHibernateUtil.getSessionFactory().openSession();
            //sesion.getTransaction().begin();

            m.setEmpresa(nuevo.getEmpresa());
            m.setMovimiento("Nota de Crédito por Factura Nro "+nuevo.getFacturaEmpresa().getNroFactura());
            m.setFecha(nuevo.getFecha());
            m.setDebe(0);
            m.setHaber(nuevo.getTotal());
            
            if(nuevo.getFacturaEmpresa().getEstado().compareTo("Cancelado") == 0){  // Si la nota da salida a caja
                insertarMovimientoCaja(null, null, nuevo, m, sesion);
            }
            sesion.save(m);
            sesion.refresh(m);

            //sesion.getTransaction().commit();  
            //sesion.close();          
            
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento", WIDTH );
        }  
    
    }

    private static void insertarMovimientoCaja(NotaCredito n, Movimiento m, NotaCreditoEmpresa nemp, MovimientoEmpresa memp, Session sesion) {
        Caja c = new Caja();
        //Session sesion;
        try{
            //sesion = NewHibernateUtil.getSessionFactory().openSession();
            //sesion.getTransaction().begin();
            
            if(n != null && m != null){
                c.setDescripcion("Nota de Crédito por Factura Nro "+n.getFactura().getNroFactura());
                c.setEntrada(0);
                c.setMovimiento(m);
                c.setSalida(n.getTotal());
                c.setTipo("Efectivo");
                c.setMovimientoEmpresa(null);
            } else if(nemp != null && memp != null){
                c.setDescripcion("Nota de Crédito por Factura Nro "+n.getFactura().getNroFactura());
                c.setEntrada(0);
                c.setMovimientoEmpresa(memp);
                c.setSalida(nemp.getTotal());
                c.setTipo("Efectivo");
                c.setMovimiento(null);
            }
            sesion.save(c);
            sesion.refresh(c);
                       
            //sesion.getTransaction().commit();
            //sesion.close();            
            
        }catch(HibernateException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Movimiento", WIDTH );
        }  
    
    }
    
}
