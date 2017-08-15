/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparador.de.ordenamientos;

import java.util.ArrayList;

/**
 *
 * @author gago8
 */
public class Datosejemplo {
    private int nombre;
    private double valor;
    public static ArrayList<Datosejemplo> datos=new ArrayList<Datosejemplo>();

    public Datosejemplo() {
    }

    
    public static void ramdon(int n)
    {
        for (int i = 0; i < n; i++) {
            Datosejemplo dat=new Datosejemplo(i, (Math.random() * Double.MAX_VALUE) + 1);
            datos.add(dat);
        }
    }   
    
    public Datosejemplo(int nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
