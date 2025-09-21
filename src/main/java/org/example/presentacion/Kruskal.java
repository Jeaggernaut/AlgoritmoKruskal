package org.example.presentacion;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    List<Aristas> aristas;

    public Kruskal(List<Aristas> aristas) {
        this.aristas = aristas;
    }

    public void ejecutarKruskal(int nodos) {
        ConjuntoDisjunto union = new ConjuntoDisjunto(nodos);
        List<Aristas> arbolExpansion = new ArrayList<>();

        for (Aristas arista : aristas) {
            int nodo1 = arista.getNodo1();
            int nodo2 = arista.getNodo2();
            if (union.encontrar(nodo1) != union.encontrar(nodo2)) {
                arbolExpansion.add(arista);
                union.union(nodo1, nodo2);
            }
        }

        System.out.println("\s\s------------------------------");
        System.out.println("\tÁrbol de Expansión Mínima (Kruskal):");
        for (Aristas arista : arbolExpansion) {
            System.out.println("Arista: " + arista.getNodo1() + "-" + arista.getNodo2() + " Peso: " + arista.getPeso());
        }

        int pesoTotalMinimo = 0;
        for(Aristas aristas1 : arbolExpansion){
            pesoTotalMinimo += aristas1.getPeso();
        }
        System.out.println("\s\s------------------------------");
        System.out.println("\t*** El peso total minimo es: "+pesoTotalMinimo + " ***");
    }
}
