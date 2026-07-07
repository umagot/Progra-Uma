package model;
import TDA.Cola;
public class Usuario implements Comparable<Usuario> {

    private int id;
    private String nombre;
    private String mail;
    private Perfil perfil; // Un único perfil
    private Cola<String> notificaciones;


    public Usuario(String nombre, int id, String mail, Perfil perfil) {
        this.nombre = nombre;
        this.id = id;
        this.mail = mail;
        this.notificaciones = new Cola<String>(100);

        if (perfil != null) {
            this.perfil = new Perfil(perfil); // Constructor copia
        } else {
            this.perfil = null;
        }

    }

    // Constructor copia para guardar el historial en la pila
    public Usuario(Usuario otro) {
        this.nombre = otro.nombre;
        this.id = otro.id;
        this.mail = otro.mail;

        if (otro.perfil != null) {
            this.perfil = new Perfil(otro.perfil);
        } else {
            this.perfil = null;
        }
    }

    // Constructor alternativo (sin perfil inicial)
    public Usuario(String nombre, int id, String mail) {
        this.nombre = nombre;
        this.id = id;
        this.mail = mail;
        this.perfil = null;
        this.notificaciones = new Cola<String>(100);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public Cola<String> getNotificaciones() {
        return this.notificaciones;
    }

    public Perfil getPerfil() {
        if (this.perfil != null) {
            return new Perfil(this.perfil);
        } else {
            return null;
        }
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPerfil(Perfil perfil) {
        if (perfil != null) {
            this.perfil = new Perfil(perfil);
        } else {
            this.perfil = null;
        }
    }

    public boolean esIgual(Usuario otro) {
        if (otro == null) {
            return false;
        }
        return this.id == otro.getId();
    }

    @Override
    public int compareTo(Usuario otro) {
        if (this.id < otro.id) {
            return -1;
        } else if (this.id > otro.id) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String textoPerfil;

        if (this.perfil == null) {
            textoPerfil = "Sin perfil configurado";
        } else {
            textoPerfil = this.perfil.toString();
        }

        return "@" + nombre + " (ID: " + id + ") | Mail: " + mail + " | Perfil: " + textoPerfil;
    }


    public void recibirNotificacion(String mensaje) {
        if (this.notificaciones != null) {
            if (!this.notificaciones.estaLlena()) {
                this.notificaciones.encolar(mensaje);
            } else {
                this.notificaciones.desencolar();
                this.notificaciones.encolar(mensaje);
            }
        }
    }


    public void leerNotificaciones() {
        System.out.println("\n--- Bandeja de Entrada de @" + this.nombre + " ---");
        if (this.notificaciones == null || this.notificaciones.estaVacia()) {
            System.out.println("No tienes notificaciones nuevas.");
            return;
        }

        int contador = 1;
        while (!this.notificaciones.estaVacia()) {
            String noti = this.notificaciones.desencolar();
            System.out.println(contador + ". " + noti);
            contador++;
        }
    }

}