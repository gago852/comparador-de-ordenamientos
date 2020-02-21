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
 * 
 */
public class Algoritmos {
    /**
     * algoritmo de ordenamiento por el metodo de insercion
     * @param atl arraylist que se va a ordenar
     */
    public static void insertsort(ArrayList<Datosejemplo> atl)
    {
        int i,j;
        Datosejemplo at;
        for (i = 1; i < atl.size(); i++)        {
            at=atl.get(i);
             for (j = i-1; j >= 0&&atl.get(j).getValor().compareTo(at.getValor())==-1; j--) {
                atl.set(j+1, atl.get(j));
                kevineselrey;
            }
        }
    }
    /**
     * algoritmo de ordenamiento por el metodo quicksort
     * @param arr arraylist que se va a ordenar
     * @param low posicion del primer dato
     * @param high posicion del ultimo dato
     */
    public static void Qsort(ArrayList<Datosejemplo>  arr, int low, int high)
    {
        if (low < high)
        {            
            int pi = partition(arr, low, high);           
            Qsort(arr, low, pi-1);
            Qsort(arr, pi+1, high);
        }
    }
    /**
     * nucleo del quicksort usa una particion de la arraylist y lo ordena
     * @param arr arraylist que se va a ordenar
     * @param low posicion del primer dato
     * @param high posicion del ultimo dato
     * @return arraylist con la particion ordenada
     */
    private static int partition(ArrayList<Datosejemplo>  arr, int low, int high)
    {
        Datosejemplo pivot = arr.get(high);
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {           
            if (arr.get(j).getValor().compareTo(pivot.getValor())==-1 || arr.get(j).getValor().compareTo(pivot.getValor())==0)
            {
                i++;                
                Datosejemplo temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(i, temp);
            }
        }        
        Datosejemplo temp = arr.get(i+1);
        arr.set(i+1, arr.get(high));
        arr.set(high, temp); 
        return i+1;
    } 
    /**
     * algoritmo de ordenamiento por el medoto de radixsort
     * @param arr arraylist que se va a ordenar
     * @param n tamaño de la arraylist
     * @return arraylist ordenado
     */
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
    /**
     * algortimo del radixsort que ordena el arraylist por el digito activo
     * @param arr arraylist que se va a ordenar
     * @param n tamaño de la arraylist
     * @param exp exponente que se usa para ordenar la arraylist por posicion del digito
     */
    private static void countSort(ArrayList<Datosejemplo> arr, int n, int exp)
    {
        ArrayList<Datosejemplo> output = new ArrayList<Datosejemplo>(); // array de salida
        for (int i = 0; i < n; i++) {
            output.add(new Datosejemplo());
        }
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // llena el array con el numer de veces
        // que se repite
        
        for (i = 0; i < n; i++){
            count[arr.get(i).getValor().divide(new BigInteger(Integer.toString(exp))).mod(BigInteger.TEN).intValue()]++;
        }
        // cambia a el array de tal forma que ahora 
        // contiene la posicion en el array de salida
        for (i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
        // Crea el array de salida
        for (i = n - 1; i >= 0; i--){
            output.set(    count[(arr.get(i).getValor().divide(new BigInteger(Integer.toString(exp)))).mod(BigInteger.TEN).intValue()]-1, arr.get(i));
            count[(arr.get(i).getValor().divide(new BigInteger(Integer.toString(exp)))).mod(BigInteger.TEN).intValue()]--;           
        }
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++){
            arr.set(i, output.get(i));
        }
    }
    /**
     * algoritmo para buscar el numero mas grande
     * @param arr arraylist para buscar el mayor
     * @param n tamaño de la arraylist
     * @return el valor mas grande de la arraylist
     */
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
    /**
     * algoritmo para ordenar una arraylist por medio del metodo heapsort
     * @param arr arraylist a ordenar
     */
    public static void Heapsort(ArrayList<Datosejemplo> arr)
    {
        int n = arr.size();        
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);            
        }
        ArrayList<Datosejemplo> temp = new ArrayList();
        temp.add(new Datosejemplo());
        for (int i=n-1; i>=0; i--)
        {            
            temp.set(0,arr.get(0));            
            arr.set(0, arr.get(i));            
            arr.set(i, temp.get(0));            
            heapify(arr, i, 0);
        }
    }   
    /**
     * algoritmo creador del arbol
     * @param arr arraylist donde estan los datos que se usaran para crear el arbol
     * @param n tamaño de la arraylist
     * @param i un numero
     */
    private static void heapify(ArrayList<Datosejemplo>  arr, int n, int i)
    {
        int largest = i;  
        int l = 2*i + 1;  
        int r = 2*i + 2;
       //l < n && arr[l] > arr[largest]
        if (l < n && arr.get(l).getValor().compareTo(arr.get(largest).getValor())==1 )
            largest = l;        
        if (r < n && arr.get(r).getValor().compareTo(arr.get(largest).getValor())==1)
            largest = r;
        ArrayList<Datosejemplo> swap = new ArrayList();
        swap.add(new Datosejemplo());
        if (largest != i)
        {
            swap.set(0,arr.get(i));            
            arr.set(i, arr.get(largest));            
            arr.set(largest, swap.get(0));            
//            swap = arr[i];
//            arr[i] = arr[largest];
//            arr[largest] = swap;//            
            heapify(arr, n, largest);
        }
    }   
    /**
     * algoritmo para ordenar una arraylist por medio del metodo de mergesort
     * @param arr arraylist a ordenar
     * @param l primera posicion de la arraylist
     * @param r  tamaño -1 de la arraylist
     */
    public static void mergesort(ArrayList<Datosejemplo>  arr, int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
            // Sort first and second halves
            mergesort(arr, l, m);
            mergesort(arr , m+1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }   
    /**
     *  algoritmo nucleo del mergesort
     * @param arr arraylist a ordenar  
     * @param l un valor que entrega el mergesort
     * @param m un valor que entrega el mergesort
     * @param r un valor que entrega el mergesort
     */
    private static void merge(ArrayList<Datosejemplo>  arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;        
        int n2 = r - m;        
        /* Create temp arrays */
         ArrayList<Datosejemplo> R = new ArrayList(n2);
         ArrayList<Datosejemplo> L = new ArrayList(n1);
         for (int i = 0; i < n1; i++) {
            L.add(new Datosejemplo());
        }
         for (int i = 0; i < n2; i++) {
            R.add(new Datosejemplo());
        }
       // Datosejemplo L[] = new Datosejemplo [n1];
    //    Datosejemplo R[] = new Datosejemplo [n2];
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
           // L[i] = arr.get(l+i);
            L.set(i,arr.get(l+i));
        for (int j=0; j<n2; ++j)
        //    R[j] = arr.get(l+j+m);
            R.set(j, arr.get(m+1+j));
//            R.set(j,arr.get(l+j+m));
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if ( L.get(i).getValor().compareTo(R.get(j).getValor())==-1 || L.get(i).getValor().compareTo(R.get(j).getValor())==0 )
            {
                arr.set(k, L.get(i));
                i++;
            }
            else
            {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr.set(k, L.get(i));
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr.set(k, R.get(j));
            j++;
            k++;
        }        
    }    
}
