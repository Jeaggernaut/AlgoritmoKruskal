package org.example.presentacion;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int nodos, cantidadRelaciones;

        System.out.print("Ingresa la cantidad de nodos: ");
        nodos = Integer.parseInt(entrada.nextLine());

        cantidadRelaciones = aristasPosibles(nodos);

        System.out.println("La cantidad de aristas posibles es: "+cantidadRelaciones);
        System.out.println("\s\s------------------------------");

        List<Aristas> aristas = asignarValorAristas(nodos, entrada);

        ordenarAristasPorPeso(aristas);
        mostrarAristasOrdenadas(aristas);

        Kruskal kruskal = new Kruskal(aristas);
        kruskal.ejecutarKruskal(nodos);

    }

    public static int aristasPosibles(int nodos){
        int cantidadRelaciones;

        cantidadRelaciones = (nodos*(nodos-1))/2;
        return cantidadRelaciones;
    }

    public static List<Aristas> asignarValorAristas(int nodos,Scanner entrada){
        List<Aristas> aristas = new ArrayList<>();
        int arregloRelaciones[][] = new int[nodos][nodos];
        for(int i = 0; i < arregloRelaciones.length; i++){
            for(int c =0; c < arregloRelaciones[0].length;c++){
                if(i !=c && i<=c){
                    System.out.print("Ingresa el peso de la arista "+i+"-"+c+" : ");
                    int peso = arregloRelaciones[i][c] = Integer.parseInt(entrada.nextLine());
                    Aristas arista = new Aristas(i,c,peso);
                    aristas.add(arista);
                }
            }
        }
        System.out.println("\s\s------------------------------");
        for(int i = 0; i < arregloRelaciones.length; i++){
            for(int c =0; c < arregloRelaciones[0].length;c++){
                if(i !=c && i<=c){
                    int peso = arregloRelaciones[i][c];
                    System.out.println("La arista "+i+"-"+c+" tiene un peso de"+" : "+peso);
                }
            }
        }
        return aristas;
    }

    public static void ordenarAristasPorPeso(List<Aristas> aristas) {
        Collections.sort(aristas, new Comparator<Aristas>() {
            @Override
            public int compare(Aristas arista1, Aristas arista2) {
                return Integer.compare(arista1.getPeso(), arista2.getPeso());
            }
        });
    }

    public static void mostrarAristasOrdenadas(List<Aristas> aristas) {
        System.out.println("\s\s------------------------------");
        System.out.println("\tLas aristas ordenadas quedan :");
        for (Aristas arista : aristas) {
            System.out.println("Arista: " + arista.getNodo1() + "-" + arista.getNodo2() + " Peso: " + arista.getPeso());
        }
    }
}
