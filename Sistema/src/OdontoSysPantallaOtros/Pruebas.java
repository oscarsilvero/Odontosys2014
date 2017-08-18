/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysPantallaOtros;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author user
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        /*DecimalFormat form = new DecimalFormat("###,###");
        int a = 12000;
        int b = 45000;
        int s = a+b;
        System.out.println("Sum "+form.format(s));
        
        String m = "Holaaa1";
        System.out.println("1 "+m);
        System.out.println("2 "+m.replace("1", ""));
        
        MaskFormatter mascaraNro = new MaskFormatter();
        try {
            mascaraNro = new MaskFormatter("#.##0");
        } catch (ParseException e) {
            // Algún error que pueda ocurrir
            e.printStackTrace();
  }
        
        
        String nro = "001-001-201202";
        nro = nro.replace("-", "");
        System.out.println("Nro: "+nro);
        
             */
        Date fecha1 = new Date("01/12/2014");
        Date fhoy = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String hoy = f.format(fhoy);        
        String fec = f.format(fecha1);
        System.out.println("Hoy: "+hoy);
        System.out.println("Fec: "+fec);
        
        System.out.println("Comparacion: "+fec.compareTo(hoy));
        System.out.println("Comparacion: "+"12/12/2014".compareTo(hoy));
        System.out.println("Comparacion Antes: "+fecha1.before(fhoy));
        System.out.println("Comparacion Despues: "+fecha1.after(fhoy));
        System.out.println("Comparacion Igual: "+fecha1.equals(fhoy));
        
       /*Date fecha = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String fec = f.format(fecha);
        System.out.println("Hoy es: "+fec);
        int hora = "  :  ".replace(":", "").trim().compareTo("");
       // int horaini = Integer.parseInt(hora);
        System.out.println("Hora: "+hora);
        Date now = new Date();
        //DateFormat f = DateFormat.getDateInstance();
        String hoy = f.format(now);
        System.out.println("Hoy:"+hoy);
       // System.out.println("HoraNueva: "+horaini);
        
        System.out.println("Comparacion ANTES: "+"24/06/2014".compareTo(hoy));
        System.out.println("Comparacion ANTES: "+"10/08/2000".compareTo(hoy));
        System.out.println("Comparacion ANTES: "+"12/12/1980".compareTo(hoy));
        System.out.println("Comparacion HOY: "+"01/07/2014".compareTo(hoy));
        System.out.println("Comparacion DESPUES: "+"01/08/2014".compareTo(hoy));
        System.out.println("Comparacion DESPUES: "+"02/10/2014".compareTo(hoy));
        System.out.println("Comparacion DESPUES: "+"03/10/2020".compareTo(hoy));
        
        
        
        
        String ced = JOptionPane.showInputDialog("Ingrese ced");
        System.out.println("Cedu: "+ced);*/
    }
    
}
