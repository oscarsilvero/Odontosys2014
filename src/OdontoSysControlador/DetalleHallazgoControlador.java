/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.DetalleHallazgo;
import OdontoSysUtil.NewHibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Tito
 */
public class DetalleHallazgoControlador {
    
    public static int insertarDetalleHallazgo(DetalleHallazgo elDetalle){
        Session sesion;
        int i = 0;
        try{
            System.out.println("IdOdontograma: "+elDetalle.getOdontograma().getIdodontograma());
            System.out.println("IdDiente: "+elDetalle.getDiente().getIddiente());
            System.out.println("IdHallazgo: "+elDetalle.getHallazgo().getIdhallazgo());
            System.out.println("Especificacion: "+elDetalle.getEspecificacion());
            System.out.println("Ubicación: "+elDetalle.getUbicacion());
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();
            i = (int)sesion.save(elDetalle);
            sesion.getTransaction().commit();
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos", "Detalle Hallazgo Controlador", JOptionPane.INFORMATION_MESSAGE);
        }       
        return i;
    }
    
    //return true si persistio todos los hallazgos
    public static boolean insertarDetalleHallazgos(ArrayList<DetalleHallazgo> hallazgoSet){
        int i = 0;
        int cantEle = hallazgoSet.size();
        int id = 0;
        
        try{
            Session sesion;
            sesion = NewHibernateUtil.getSessionFactory().openSession();
            sesion.getTransaction().begin();
            Iterator<DetalleHallazgo> it = hallazgoSet.iterator();
            DetalleHallazgo elDetalleAct;
            while(it.hasNext()){
                elDetalleAct = it.next();
                id = (int)sesion.save(elDetalleAct);
                elDetalleAct.setIddetalleHallazgo(id);
                i++;
            }
            sesion.getTransaction().commit();
            
        }catch(HibernateException ex){
            JOptionPane.showMessageDialog(null, ex, "Detalle Hallazgo Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        
       return (i == cantEle);
    }
    
}
