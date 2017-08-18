/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Usuario;
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
public class UsuarioControlador {
    
    public static Usuario Login(String nombre,  String passw){
        Session sesion;
        Transaction tr = null;
        Usuario u =null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Usuario U WHERE U.nombre = '"+ nombre + "' and U.passw = '" + passw + "' AND estado = 'Activo'";
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
             u = (Usuario)it.next();
            }else{
               return null;
            }            
        }catch(HibernateException ex){
               JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Login Controlador", JOptionPane.INFORMATION_MESSAGE);
         }  
        return u;
    }
    
    public static ArrayList<Usuario> BuscarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        Session session;
        Transaction tr = null;
        try {            
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            String hql = "FROM Usuario WHERE estado = 'Activo'";            
            Query query = session.createQuery(hql);
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    Usuario nuevo = (Usuario) it.next();
                    lista.add(nuevo);
               }while(it.hasNext());
            }else{
                lista = null;
            }            
        } catch (HibernateException ex) {
              JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Usuario Controlador", JOptionPane.INFORMATION_MESSAGE);
         }
        
        return lista;
    }
    
    public static int InsertarUsuario(Usuario nuevo) {
        int i = 0;        
        Session sesion;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();            
            i = (int)sesion.save(nuevo);
            sesion.getTransaction().commit();
            sesion.close();
        }catch(HibernateException ex){
            System.out.println("mensage "+ex.getMessage());
             JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Usuario Controlador", JOptionPane.INFORMATION_MESSAGE);   
        }        
        return i;
    }
    
    public static int ModificarUser(Usuario usuarioActual) {
        int i = 0;
        try{ 
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        i = usuarioActual.getIdusuario();
        session.merge(usuarioActual);
        tr.commit();      
        session.close();       
        
       }catch(HibernateException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Modificar Usuario", WIDTH );
       }
        
       return i;
    }
    
    public static int EliminarUsuario(Usuario user) {       
        int i = 0;
        try{         
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "UPDATE Usuario SET estado = 'Inactivo' WHERE idusuario = "+user.getIdusuario();
            Query updatedEntities = session.createQuery( hqlUpdate );
            updatedEntities.executeUpdate();
            tx.commit();
            session.close();
       }catch(HibernateException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Eliminar Usuario", WIDTH );
           i = 1;
       }
        
       return i; 
    }
    
    public static Usuario BuscarID(int idUsuario){
        Session sesion;
        Usuario p =null;
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = sesion.beginTransaction();
            String hql = "FROM Usuario WHERE idUsuario = "+ idUsuario;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
             p = (Usuario)it.next();
            }else{
               return null;
            }
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Usuario Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return p;
    }
}
