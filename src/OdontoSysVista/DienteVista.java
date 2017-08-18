/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysControlador.DienteControlador;
import OdontoSysModelo.Diente;
import java.util.ArrayList;

/**
 *
 * @author Tito
 */
public class DienteVista {

    public static ArrayList<Diente> BuscarPorNombre(String nombreDiente) {
        ArrayList<Diente> listDientes = DienteControlador.BuscarPorNombre(nombreDiente);
        
        return listDientes;
    }
    
}
