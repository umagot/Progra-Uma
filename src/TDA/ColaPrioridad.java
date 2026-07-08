package TDA;

import model.ElementoNotificacion;

public class ColaPrioridad {
    private ElementoNotificacion[] datos;
    private int cantidad;
    private int max;

    public ColaPrioridad(int max) {
        this.max = max;
        this.datos = new ElementoNotificacion[max];
        this.cantidad = 0;
    }

    public boolean estaVacia() {
        return this.cantidad == 0;
    }

    public boolean estaLlena() {
        return this.cantidad == this.max;
    }

    public int tamano() {
        return this.cantidad;
    }

    public boolean encolar(ElementoNotificacion nuevo) {
        if (estaLlena()) {
            System.out.println("⚠️ La cola de notificaciones con prioridad está llena.");
            return false;
        }

        int i = cantidad - 1;
        while (i >= 0 && datos[i].compareTo(nuevo) > 0) {
            datos[i + 1] = datos[i];
            i--;
        }

        datos[i + 1] = nuevo;
        cantidad++;
        return true;
    }

    public ElementoNotificacion desencolar() {
        if (estaVacia()) {
            return null;
        }

        ElementoNotificacion primero = datos[0];

        for (int i = 0; i < cantidad - 1; i++) {
            datos[i] = datos[i + 1];
        }

        datos[cantidad - 1] = null;
        cantidad--;

        return primero;
    }
}