/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparador.de.ordenamientos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

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
    public static ArrayList<Datosejemplo> radixsort(ArrayList<Datosejemplo> arr, int n)
    {
        // Find the maximum number to know number of digits
        BigInteger m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        
        for (int exp = 1; m.divide(new BigInteger(Integer.toString(exp))).compareTo(BigInteger.ZERO)==1; exp *= 10){
            countSort(arr, n, exp);
        }
        return arr;
    }
    private static void countSort(ArrayList<Datosejemplo> arr, int n, int exp)
    {
        ArrayList<Datosejemplo> output = new ArrayList<Datosejemplo>(n); // array de salida
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // llena el array con el numer de veces
        // que se repite
        
        for (i = 0; i < n; i++){
            count[(arr.get(i).getValor().divide(new BigInteger(Integer.toString(exp)))).mod(BigInteger.TEN).intValueExact()]++;
        }
        // cambia a el array de tal forma que ahora 
        // contiene la posicion en el array de salida
        for (i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
        // Crea el array de salida
        for (i = n - 1; i >= 0; i--){
            output.add(((arr.get(i).getValor().divide(new BigInteger(Integer.toString(exp)))).mod(BigInteger.TEN).intValueExact())-1, arr.get(i));
            count[(arr.get(i).getValor().divide(new BigInteger(Integer.toString(exp)))).mod(BigInteger.TEN).intValueExact()]--;           
        }
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++){
            arr.set(i, output.get(i));
        }
    }
    private static BigInteger getMax(ArrayList<Datosejemplo> arr, int n)
    {
        BigInteger mx = arr.get(0).getValor();
        for (int i = 1; i < n; i++){
            if (arr.get(i).getValor().compareTo(mx)==1) {
                mx=arr.get(i).getValor();
            }           
        }
        return mx;
    }    
}
