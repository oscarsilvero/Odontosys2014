/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.Tratamiento;
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
 * @author Tito
 */
public class TratamientoControlador {
    public static int insertarTratamiento(Tratamiento elTratamiento){
        Session sesion;
        int i = 0;
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();
            i = (int)sesion.save(elTratamiento);
            sesion.getTransaction().commit();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Tratamiento Controlador", JOptionPane.INFORMATION_MESSAGE);
        }       
        return i;                
    }
    
    public static boolean insertarTratamientos(ArrayList<Tratamiento> tratamientosSet){
    
        int i = 0;
        int cantEle = tratamientosSet.size();
        int id;
        
        try{
            Session sesion;
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();

            Iterator<Tratamiento> it = tratamientosSet.iterator();

            Tratamiento elTratamientoAct;
            while(it.hasNext()){
                elTratamientoAct = it.next();

                id = (int)sesion.save(elTratamientoAct);
                //elTratamientoAct.setIdtratamiento(id);
                sesion.refresh(elTratamientoAct);
                i++;
            }
            sesion.getTransaction().commit();
            
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Tratamientos Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        
       return (i == cantEle);
    }
    
    public static ArrayList<Tratamiento> BuscarTratamiento(int idOdont){
        Session sesion;
        Transaction tr = null;
        Tratamiento t =null;
        ArrayList<Tratamiento> lista = new ArrayList();
        try{        
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            tr = sesion.beginTransaction();
            String hql = "FROM Tratamiento WHERE odontograma = "+ idOdont;
            Query query = sesion.createQuery(hql); 
            Iterator it = query.iterate();
            if(it.hasNext()){
                do{
                    t = (Tratamiento) it.next();
                    lista.add(t);
               }while(it.hasNext());
            }else{
                lista = null;
            } 
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Odontograma Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return lista;
    }
}
