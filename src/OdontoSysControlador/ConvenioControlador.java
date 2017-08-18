/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Convenio;
import OdontoSysModelo.Empresa;
import OdontoSysModelo.Paciente;
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
 * @author Tito
 */
public class ConvenioControlador {
 
    public static boolean insertarConvenio(ArrayList<Convenio> conv) {
        int i = 0;
        boolean val = false;
        Session sesion;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();
            Iterator<Convenio> it = conv.iterator();
            Convenio c;
            while(it.hasNext()){
                c = (Convenio) it.next();
                sesion.save(c);                       
            }
            sesion.getTransaction().commit();
            val = true;
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Convenio", WIDTH );
       }        
        return val;
    }
    
    public static boolean BuscarConvenio(Convenio conv){
        Session sesion;
        Transaction tr = null;
        boolean c = false;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Convenio WHERE paciente = "+ conv.getPaciente().getIdPaciente()+" AND empresa = "+ conv.getEmpresa().getIdempresa();
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                c = true;
            }else{
                c = false;
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return c;
    }
    
    public static ArrayList<Convenio> BuscarConvenios(Paciente idPac, Empresa idEmp){
        Session sesion;
        Transaction tr = null;
        ArrayList<Convenio> lis = new ArrayList();;
        String hql;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            if(idPac == null && idEmp != null){                         
                //Lamado desde empresa; convenios asociados a empresa = idEmp
                hql = "FROM Convenio WHERE estado = 'Activo' AND empresa = "+idEmp.getIdempresa();
            }else if(idPac != null && idEmp != null){  
                //convenios con paciente = idPac y empresa = idEmp
                hql = "FROM Convenio WHERE estado = 'Activo' AND paciente = "+ idPac.getIdPaciente() +" AND empresa = "+ idEmp.getIdempresa();
            }else if(idPac != null && idEmp == null){
                //convenios asociado a paciente = idPac
                hql = "FROM Convenio WHERE estado = 'Activo' AND paciente = "+ idPac.getIdPaciente();
            }else{
                //lista de convenios idPac = idEmp = NULL
                hql = "FROM Convenio WHERE estado = 'Activo'";
            }
            
            Query query = sesion.createQuery(hql); 
            Iterator<Convenio> it = query.iterate();
            while(it.hasNext()){
                lis.add(it.next());
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }
    
    public static ArrayList<Empresa> BuscarConvenioEmpresa(Paciente pac){
        Session sesion;
        Transaction tr = null;
        ArrayList<Empresa> lis = new ArrayList();
        String hql;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            if(pac == null){
                hql = "SELECT DISTINCT c.empresa FROM Convenio c WHERE c.estado = 'Activo'";
            }else{
                hql = "SELECT DISTINCT c.empresa FROM Convenio c WHERE c.estado = 'Activo' AND c.paciente = "+pac.getIdPaciente();
            }
            Query query = sesion.createQuery(hql); 
            Iterator<Empresa> it = query.iterate();
            while(it.hasNext()){
                lis.add(it.next());
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }
    
    public static boolean modificarConvenio(ArrayList<Convenio> conv) {
        int i = 0;
        boolean val = false;
        Session session;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = session.beginTransaction();   
            Iterator<Convenio> it = conv.iterator();
            Convenio c;
            while(it.hasNext()){
                c = (Convenio) it.next();
                session.merge(c);                       
            }           
                 
            tr.commit();      
            session.close();  
       
            val = true;
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Convenio", WIDTH );
       }        
        return val;
    }

    public static ArrayList<Paciente> BuscarConvenioPaciente() {
        Session sesion;
        Transaction tr = null;
        ArrayList<Paciente> lis = new ArrayList();
        String hql;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            hql = "SELECT DISTINCT c.paciente FROM Convenio c WHERE c.estado = 'Activo'";
            Query query = sesion.createQuery(hql); 
            Iterator<Paciente> it = query.iterate();
            while(it.hasNext()){
                lis.add(it.next());
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }
    
    public static boolean eliminarConvenio(ArrayList<Convenio> conv) {
        int i = 0;
        boolean val = false;
        Session session;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = session.beginTransaction();   
            Iterator<Convenio> it = conv.iterator();
            Convenio c;
            while(it.hasNext()){
                c = (Convenio) it.next();
                c.setEstado("Inactivo");
                session.merge(c);                       
            }           
                 
            tr.commit();      
            session.close();  
       
            val = true;
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Insertar Convenio", WIDTH );
       }        
        return val;
    }

    public static int BuscarPorcentajeConvenio(int pac, int idempresa, int idservicio, Session sesion) {
        //Session sesion;
        //Transaction tr = null;
        String hql;
        int porc = 0;
        try{        
            //sesion = NewHibernateUtil.getSessionFactory().openSession();
            //tr = sesion.beginTransaction();
            hql = "SELECT porcentaje FROM Convenio WHERE estado = 'Activo' AND paciente = "+pac+" AND empresa = "+idempresa+" AND servicio = "+idservicio;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                porc = (int)it.next();
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return porc;
    }

    public static ArrayList<Paciente> BuscarPacientesConConvenios(Empresa emp) {
        //Retorna todos los pacientes asociados a una empresa
        Session sesion;
        Transaction tr = null;
        ArrayList<Paciente> lis = null;
        String hql;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            hql = "SELECT DISTINCT c.paciente FROM Convenio c WHERE c.estado = 'Activo' AND c.empresa = "+emp.getIdempresa();
            Query query = sesion.createQuery(hql); 
            Iterator<Paciente> it = query.iterate();
            if(it.hasNext()){
                lis = new ArrayList();
                while(it.hasNext()){
                lis.add(it.next());
                }
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Convenio Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lis;
    }
    
}
