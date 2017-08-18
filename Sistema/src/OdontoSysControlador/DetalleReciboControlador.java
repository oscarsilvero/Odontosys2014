/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysControlador;

import OdontoSysModelo.DetalleRecibo;
import OdontoSysUtil.NewHibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class DetalleReciboControlador {

    public static boolean InsertDetalles(ArrayList<DetalleRecibo> detalle) {
        Session session;
        Transaction tr = null;
        boolean act = false;
        DetalleRecibo aux;
        
        try{       
            session = NewHibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            Iterator<DetalleRecibo> it = detalle.iterator();
            
                while(it.hasNext()){
                    aux = it.next();
                    int i = (Integer) session.save(aux);
                    
                }
                tr.commit();
                act = true;
        }catch(HibernateException ex){
                JOptionPane.showMessageDialog(null, "Error al conectarse con Base de Datos InserDetalle", "Detalle Recibo Controlador", JOptionPane.INFORMATION_MESSAGE);
        }
        return act;
    }

}
