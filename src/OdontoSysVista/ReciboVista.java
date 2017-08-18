/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysControlador.FacturaControlador;
import OdontoSysControlador.ReciboControlador;
import OdontoSysModelo.DetalleRecibo;
import OdontoSysModelo.DetalleReciboemp;
import OdontoSysModelo.Recibo;
import OdontoSysModelo.ReciboEmpresa;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ReciboVista {
    
    public static ArrayList<DetalleRecibo> validarRecibo (Recibo recibo, ArrayList<DetalleRecibo> detalle) {
        String nom = recibo.getPaciente().getNombres();
        String est = recibo.getFactura().getEstado();
        int monto = recibo.getMonto();
        int user = recibo.getUsuario().getIdusuario();
        if((nom == null) || (monto == 0) || (est == null) || (user <= 0)){
            System.out.println("Paciente "+ nom+" Estado "+est+" Monto "+monto+" User "+user);
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos", "Validación de datos Recibo", WIDTH);
            return null;
        }
        if(recibo.getFactura().getTipoFactura().compareTo("Contado") == 0){
            int mf = recibo.getFactura().getMontoTotal();
            if(monto != mf){
                JOptionPane.showMessageDialog(null,"El monto debe ser igual al monto de la factura, Gs. "+mf, "Validar Recibo", WIDTH );
                return null;
            }else{            
                ArrayList<DetalleRecibo> lista = validarDetalle(detalle);
                if(lista != null){
                    return lista;
                }else{
                    return null;
                }
            }
        }else{
            int deuda = recibo.getFactura().getSaldo();
            if(monto > deuda){     //Si el monto que se está pagando es mayor al saldo deudor de la factura especificada
                JOptionPane.showMessageDialog(null,"El monto no puede ser mayor a la deuda de Gs. "+deuda, "Validar Recibo", WIDTH );
                return null;
            }else{            
                ArrayList<DetalleRecibo> lista = validarDetalle(detalle);
                if(lista != null){
                    return lista;
                }else{
                    return null;
                }
            }
        }
         
    }
    
    public static ArrayList<DetalleRecibo> validarDetalle (ArrayList<DetalleRecibo> detalle) {
        ArrayList<DetalleRecibo> vale = new ArrayList();
        Iterator it = detalle.iterator();
        DetalleRecibo aux = new DetalleRecibo();
        String f;
        int efec = 0;
        int che = 0;
        int tc = 0;
        int td = 0;
        
        for(; it.hasNext();){
            aux = (DetalleRecibo) it.next();
            f = aux.getFormaPago();
            
            if(f.compareTo("Efectivo") == 0){
                efec = aux.getMonto() + efec;
            }else if(f.compareTo("Cheque")== 0){
                che = aux.getMonto() + che;
            }else if(f.compareTo("Tarjeta Débito") == 0){
                td = aux.getMonto() + td;
            }else if(f.compareTo("Tarjeta Crédito") == 0){
                tc = aux.getMonto() + tc;
            }
        }
        
        if(efec > 0){
            DetalleRecibo v = new DetalleRecibo();
            v.setFormaPago("Efectivo");
            v.setMonto(efec);
            vale.add(v);
        }
        if(che > 0){
            DetalleRecibo v = new DetalleRecibo();
            v.setFormaPago("Cheque");
            v.setMonto(che);
            vale.add(v);
        }
        if(tc > 0){
            DetalleRecibo v = new DetalleRecibo();
            v.setFormaPago("Tarjeta Crédito");
            v.setMonto(tc);
            vale.add(v);
        }
        if(td > 0){
            DetalleRecibo v = new DetalleRecibo();
            v.setFormaPago("Tarjeta Débito");
            v.setMonto(td);
            vale.add(v);
        }
        return vale;
    }
    
    public static ArrayList<DetalleReciboemp> validarReciboEmpresa (ReciboEmpresa recibo, ArrayList<DetalleReciboemp> detalle) {
        String nom = recibo.getEmpresa().getNombre();
        String est = recibo.getFacturaEmpresa().getEstado();
        int monto = recibo.getMonto();
        int user = recibo.getUsuario().getIdusuario();
        if((nom == null) || (monto == 0) || (est == null) || (user <= 0)){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos", "Validación de datos Recibo", WIDTH);
            return null;
        }
        if(recibo.getFacturaEmpresa().getTipo().compareTo("Contado") == 0){
            int mf = recibo.getFacturaEmpresa().getMontoTotal();
            if(monto != mf){  
                JOptionPane.showMessageDialog(null,"El monto no puede ser mayor al monto de la factura: Gs. "+mf, "Validar Recibo", WIDTH );
                return null;
            }else{            
                ArrayList<DetalleReciboemp> lista = validarDetalleRecEmp(detalle);
                if(lista != null){
                    return lista;
                }else{
                    return null;
                }
            }
        }else{
        int deuda = recibo.getFacturaEmpresa().getSaldo();
        if(monto > deuda){     //Si el monto que se está pagando es mayor al saldo deudor de la factura especificada
            JOptionPane.showMessageDialog(null,"El monto no puede ser mayor a la deuda de Gs. "+deuda, "Validar Recibo", WIDTH );
            return null;
        }
        else{            
            ArrayList<DetalleReciboemp> lista = validarDetalleRecEmp(detalle);
            if(lista != null){
                return lista;
            }else{
                return null;
            }
        }
        }
         
    }
    
    public static ArrayList<DetalleReciboemp> validarDetalleRecEmp (ArrayList<DetalleReciboemp> detalle) {
        ArrayList<DetalleReciboemp> vale = new ArrayList();
        Iterator it = detalle.iterator();
        DetalleReciboemp aux = new DetalleReciboemp();
        String f;
        int efec = 0;
        int che = 0;
        int tc = 0;
        int td = 0;
        
        for(; it.hasNext();){
            aux = (DetalleReciboemp) it.next();
            f = aux.getFormaPago();
            
            if(f.compareTo("Efectivo") == 0){
                efec = aux.getMonto() + efec;
            }else if(f.compareTo("Cheque")== 0){
                che = aux.getMonto() + che;
            }else if(f.compareTo("Tarjeta Débito") == 0){
                td = aux.getMonto() + td;
            }else if(f.compareTo("Tarjeta Crédito") == 0){
                tc = aux.getMonto() + tc;
            }
        }
        
        if(efec > 0){
            DetalleReciboemp v = new DetalleReciboemp();
            v.setFormaPago("Efectivo");
            v.setMonto(efec);
            vale.add(v);
        }
        if(che > 0){
            DetalleReciboemp v = new DetalleReciboemp();
            v.setFormaPago("Cheque");
            v.setMonto(che);
            vale.add(v);
        }
        if(tc > 0){
            DetalleReciboemp v = new DetalleReciboemp();
            v.setFormaPago("Tarjeta Crédito");
            v.setMonto(tc);
            vale.add(v);
        }
        if(td > 0){
            DetalleReciboemp v = new DetalleReciboemp();
            v.setFormaPago("Tarjeta Débito");
            v.setMonto(td);
            vale.add(v);
        }
        return vale;
    }
}
