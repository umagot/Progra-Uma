package model;

public class ElementoNotificacion implements Comparable<ElementoNotificacion> {
    private String mensaje;
    private int prioridad; // Mayor número = Mayor prioridad

    public ElementoNotificacion(String mensaje, int prioridad) {
        this.mensaje = mensaje;
        this.prioridad = prioridad;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(ElementoNotificacion otro) {
        return Integer.compare(otro.getPrioridad(), this.prioridad);
    }
}