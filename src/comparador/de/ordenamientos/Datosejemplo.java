/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparador.de.ordenamientos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author gago8
 */
public class Datosejemplo {
    private int nombre;
    private BigInteger valor;
    public static ArrayList<Datosejemplo> datos;

    public Datosejemplo() {
    }

    
    public static void ramdon(int n)
    {
        datos=new ArrayList<Datosejemplo>();
        Random rnd=new Random();
        BigInteger p=new BigInteger("999999999999999999999999999999999999999999999999999999999999999999999999");        
        for (int i = 0; i < n; i++) {            
            Datosejemplo dat=new Datosejemplo(i, new BigInteger(p.bitLength(), rnd));
            datos.add(dat);
        }        
    }   
    
    public Datosejemplo(int nombre, BigInteger valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }
    
}
