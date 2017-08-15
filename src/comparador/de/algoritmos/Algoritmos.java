/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparador.de.algoritmos;

import java.util.ArrayList;

/**
 *
 * @author gago8
 */
public class Algoritmos {
    public static void insertsort(ArrayList<Atleta> atl)
    {
        int i,j;
        Atleta at;
        for (i = 1; i < atl.size(); i++)        {
            at=atl.get(i);
             for (j = i-1; j >= 0&&atl.get(j).getTiempo()<at.getTiempo(); j--) {
                atl.set(j+1, atl.get(j));
                atl.set(j, at);
            }
        }
    }
    public static ArrayList<Atleta> quicksort (ArrayList<Atleta> atl,int izq,int der)
    {
        if(izq>=der)
        {
            return atl;
        }
        int i=izq,d=der;
        if (izq!=der) {
            int pivote;
            Atleta aux;
            pivote=izq;
            while(izq!=der)
            {
                while(atl.get(der).getTiempo()<=atl.get(pivote).getTiempo()&&izq<der)                    
                    der--;
                while(atl.get(izq).getTiempo()>atl.get(pivote).getTiempo()&&izq<der)
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
