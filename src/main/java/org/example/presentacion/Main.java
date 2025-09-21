package org.example.presentacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int nodos, cantidadRelaciones;

        System.out.print("Ingresa la cantidad de nodos: ");
        nodos = Integer.parseInt(entrada.nextLine());

        cantidadRelaciones = aristasPosibles(nodos);

        System.out.println("La cantidad de aristas posibles es: "+cantidadRelaciones);
        System.out.println("-------------------------------------");

        asignarValorAristas(nodos,entrada);

    }

    public static int aristasPosibles(int nodos){
        int cantidadRelaciones;

        cantidadRelaciones = (nodos*(nodos-1))/2;
        return cantidadRelaciones;
    }

    public static void asignarValorAristas(int nodos,Scanner entrada){
        List<Aristas> aristas = new ArrayList<>();
        int arregloRelaciones[][] = new int[nodos][nodos];
        for(int i = 0; i < arregloRelaciones.length; i++){
            for(int c =0; c < arregloRelaciones[0].length;c++){
                if(i !=c && i<=c){
                    System.out.print("Ingresa el peso de la posicion "+i+"-"+c+" : ");
                    int peso = arregloRelaciones[i][c] = Integer.parseInt(entrada.nextLine());
                    Aristas arista = new Aristas(i,c,peso);
                    aristas.add(arista);
                }
            }
        }

    }
}