/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_2_busqueda_binaria;

import java.util.Scanner;

/**
 *
 * @author JOSE ALBERTO PEREZ
 */
public class EVA3_2_BUSQUEDA_BINARIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int[] datos = new int[1000];
        llenar(datos);
        //imprimir(datos);
        selectionSort(datos);
        //imprimir(datos);
        Scanner input = new Scanner(System.in);
        System.out.println("Valor a buscar: ");
        int valor = input.nextInt();
        int iResu = binarySearch(datos, valor);
        System.out.println("El elemento está en la posición: " + iResu);
    }
    
    public static void llenar(int[] datos){
        for(int i = 0; i < datos.length; i++){
            datos[i] = (int)(Math.random() * 100);
        }
    }
    
    public static void imprimir(int[] datos){
        for(int i = 0; i < datos.length; i++){
            System.out.print("[" + datos[i] + "]");
        }
        System.out.println("");
    }
    
    public static void selectionSort(int[] datos){
        for(int i = 0; i < datos.length; i++){
            int iMin = i;
            for (int j = i + 1; j < datos.length; j++){
                if(datos[j] < datos[iMin]){
                    iMin = j;
                }
            }
            if(i != iMin){
                int iTemp = datos[i];
                datos[i] = datos[iMin];
                datos[iMin] = iTemp;
            }
        }
    }
    
    //LA BUSQUEDA BINARIA ES RECURSIVA
    public static int binarySearch(int[] datos, int valBuscar){
        return binarySearchRecu(datos, valBuscar, 0, datos.length - 1);
    }
    
    private static int binarySearchRecu(int[] datos, int valBuscar, int ini, int fin){
        int iMid, iResu;
        iMid = ini + ((fin - ini) / 2);//posición a la mitad de la busqueda
        iResu = -1;//SI EL VALOR NO EXISTE, REGRESAMOS -1
        if(fin >= ini){//buscamos
            if(valBuscar == datos[iMid]){//EL VALOR ESTA A LA MITAD
                iResu = iMid;//aquí esta el valor, y lo regresamos
            }else if(valBuscar < datos[iMid]){//NO ESTA A LA MITAD, PERO ESTA A LA IZQUIERDA
                //llamamos recursivamente a la busqueda binaria
                iResu = binarySearchRecu(datos, valBuscar, ini, iMid - 1);
            }else{//NO ESTA, PERO PUEDE ESTAR A LA DERECHA
                iResu = binarySearchRecu(datos, valBuscar, iMid + 1, fin);
            }
        }
        return iResu;
    }
}
    
