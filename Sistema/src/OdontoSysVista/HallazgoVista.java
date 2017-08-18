/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysControlador.HallazgoControlador;
import OdontoSysModelo.Hallazgo;
import java.util.ArrayList;

/**
 *
 * @author Tito
 */
public class HallazgoVista {
    public static ArrayList<Hallazgo> BuscarPorNombre(String nombreHallazgo){
        ArrayList<Hallazgo> Hallazgos;
        Hallazgos = HallazgoControlador.BuscarPorNombre(nombreHallazgo);
        
        return Hallazgos;
    }  
}
