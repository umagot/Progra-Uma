package model;

import TDA.ColaPrioridad;

public class Usuario implements Comparable<Usuario> {

    private int id;
    private String nombre;
    private String mail;
    private Perfil perfil;
    private ColaPrioridad notificaciones;

    public Usuario(String nombre, int id, String mail, Perfil perfil) {
        this.nombre = nombre;
        this.id = id;
        this.mail = mail;
        this.notificaciones = new ColaPrioridad(100);

        if (perfil != null) {
            this.perfil = new Perfil(perfil);
        } else {
            this.perfil = null;
        }
    }

    // Constructor copia
    public Usuario(Usuario otro) {
        this.nombre = otro.nombre;
        this.id = otro.id;
        this.mail = otro.mail;
        this.notificaciones = new ColaPrioridad(100);

        if (otro.perfil != null) {
            this.perfil = new Perfil(otro.perfil);
        } else {
            this.perfil = null;
        }
    }

    // Constructor alternativo
    public Usuario(String nombre, int id, String mail) {
        this.nombre = nombre;
        this.id = id;
        this.mail = mail;
        this.perfil = null;
        this.notificaciones = new ColaPrioridad(100);
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

    public ColaPrioridad getNotificaciones() {
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
        String textoPerfil = (this.perfil == null) ? "Sin perfil configurado" : this.perfil.toString();
        return "@" + nombre + " (ID: " + id + ") | Mail: " + mail + " | Perfil: " + textoPerfil;
    }

    public void recibirNotificacion(String mensaje, int prioridad) {
        if (this.notificaciones != null) {
            this.notificaciones.encolar(new ElementoNotificacion(mensaje, prioridad));
        }
    }
}