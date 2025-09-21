package org.example.presentacion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int nodos, cantidadRelaciones;

        System.out.print("Ingresa la cantidad de nodos: ");
        nodos = Integer.parseInt(entrada.nextLine());
        cantidadRelaciones = relacionesPosibles(nodos);
        System.out.println("La cantidad de relaciones es: "+cantidadRelaciones);

        crearRelaciones(nodos,entrada);
    }

    public static int relacionesPosibles(int nodos){
        int cantidadRelaciones;

        cantidadRelaciones = (nodos*(nodos-1))/2;

        return cantidadRelaciones;
    }

    public static void crearRelaciones(int nodos,Scanner entrada){
        int arregloRelaciones[][] = new int[nodos][nodos];

        for(int i = 0; i < arregloRelaciones.length; i++){
            for(int c = 0; c < arregloRelaciones[0].length;c++){
                if(i != c){
                    System.out.print("Ingresa el valor de la posicion "+i+","+c+" : ");
                    arregloRelaciones[i][c] = Integer.parseInt(entrada.nextLine());
                }
            }
        }

    }
}