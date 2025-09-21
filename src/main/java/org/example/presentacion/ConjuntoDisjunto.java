package org.example.presentacion;

public class ConjuntoDisjunto {
    private int[] padre;

    public ConjuntoDisjunto(int nodos) {
        padre = new int[nodos];
        for (int i = 0; i < nodos; i++) {
            padre[i] = i; // Inicializa cada nodo como su propio padre
        }
    }

    public int encontrar(int nodo) {
        if (padre[nodo] != nodo) {
            padre[nodo] = encontrar(padre[nodo]); // Compresión de camino
        }
        return padre[nodo];
    }

    public void union(int nodo1, int nodo2) {
        int raiz1 = encontrar(nodo1);
        int raiz2 = encontrar(nodo2);

        if (raiz1 != raiz2) {
            padre[raiz1] = raiz2; // Une los dos conjuntos
        }
    }
}
