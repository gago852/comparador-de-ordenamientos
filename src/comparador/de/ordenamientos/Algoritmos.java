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
public class Algoritmos {
    public static void insertsort(ArrayList<Datosejemplo> atl)
    {
        int i,j;
        Datosejemplo at;
        for (i = 1; i < atl.size(); i++)        {
            at=atl.get(i);
             for (j = i-1; j >= 0&&atl.get(j).getValor().compareTo(at.getValor())==-1; j--) {
                atl.set(j+1, atl.get(j));
                atl.set(j, at);
            }
        }
    }
    public static ArrayList<Datosejemplo> quicksort (ArrayList<Datosejemplo> atl,int izq,int der)
    {
        if(izq>=der)
        {
            return atl;
        }
        int i=izq,d=der;
        if (izq!=der) {
            int pivote;
            Datosejemplo aux;
            pivote=izq;
            while(izq!=der)
            {
                while(atl.get(der).getValor().compareTo(atl.get(pivote).getValor())<=0&&izq<der)                    
                    der--;
                while(atl.get(izq).getValor().compareTo(atl.get(pivote).getValor())==1&&izq<der)
                    izq++;
                
                if (der!=izq) {
                    aux=atl.get(der);
                    atl.set(der, atl.get(izq));
                    atl.set(izq, aux);
                }
                if(izq==der)
                {
                    quicksort(atl,i,izq-1);
                    quicksort(atl,izq+1,d);
                }
            }
        }else
        {
            return atl;
        }
        return atl;
    }
}
