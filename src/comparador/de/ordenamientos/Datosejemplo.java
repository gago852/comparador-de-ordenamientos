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
    /**
     * constructor de la clase datosejemplo con datos vacios
     */
    public Datosejemplo() {
    }    
    /**
     * constructor de la clase datosejemplo con unos datos dados
     * @param nombre identificacion
     * @param valor dato random que se usara para ordenar
     */
    public Datosejemplo(int nombre, BigInteger valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    /**
     * funcion que llena una arraylist con valores random
     * @param n numero de datos que se crearan
     */
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
    /**
     * funcion para optener el id del valor
     * @return identificacion
     */
    public int getNombre() {
        return nombre;
    }
    /**
     * funcion para guardar el id de un valor
     * @param nombre indentificacion
     */
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    /**
     * funcion para optener el valor
     * @return dato random
     */
    public BigInteger getValor() {
        return valor;
    }
    /**
     * funcion para guardar el valor
     * @param valor dato random
     */
    public void setValor(BigInteger valor) {
        this.valor = valor;
    }    
}
