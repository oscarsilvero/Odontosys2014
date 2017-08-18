/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package odontosyshb;

import OdontoSysUtil.Configuraciones;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class newMainPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String reporte="reportes/factura";
        
        int idFactura = 4;
        String let = "CIENTO NO SE CUANTO";
        
        Map parametros = new HashMap();
        parametros.put("idFactura", idFactura);
        parametros.put("total_letras", let);
        
        Configuraciones.imprimirReporteHB(reporte, parametros);
    }
    
}
