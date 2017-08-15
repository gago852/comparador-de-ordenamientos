/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparador.de.ordenamientos;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author gago8
 */
public class Datosejemplo {
    private BigInteger nombre;
    private BigInteger valor;
    public static ArrayList<Datosejemplo> datos=new ArrayList<Datosejemplo>();

    public Datosejemplo() {
    }

    
    public static void ramdon()
    {
        
    }
    
    
    
    
    
    public Datosejemplo(BigInteger nombre, BigInteger valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public BigInteger getNombre() {
        return nombre;
    }

    public void setNombre(BigInteger nombre) {
        this.nombre = nombre;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }
    
}
