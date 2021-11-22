package com.example.procorgolfremaster.clases;

public class Datos {
    // Atributos
    private int id__lista;
    private String torneo;
    private String campo;
    private String nombre;
    private String apellidos;
    private String cargo;
    private String dni;
    private String codigo_postal;
    private String correo;
    private String telefono;
    private String contacto;
    private String dias_contacto;
    private String sintomas;
    private String test;
    private String resultado;
    private int numero_prueba;
    private int analizada;
    private int paso_previo;

    // Constructor
    public Datos(int id__lista, String torneo, String campo, String nombre, String apellidos, String cargo, String dni, String codigo_postal, String correo, String telefono, String contacto, String dias_contacto, String sintomas, String test, String resultado, int numero_prueba, int analizada) {
        this.id__lista = id__lista;
        this.torneo = torneo;
        this.campo = campo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.dni = dni;
        this.codigo_postal = codigo_postal;
        this.correo = correo;
        this.telefono = telefono;
        this.contacto = contacto;
        this.dias_contacto = dias_contacto;
        this.sintomas = sintomas;
        this.test = test;
        this.resultado = resultado;
        this.numero_prueba = numero_prueba;
        this.analizada = analizada;
    }

    public int getPaso_previo() {
        return paso_previo;
    }

    public void setPaso_previo(int paso_previo) {
        this.paso_previo = paso_previo;
    }

    public int getAnalizada() {
        return analizada;
    }

    public void setAnalizada(int analizada) {
        this.analizada = analizada;
    }

    public int getId__lista() {
        return id__lista;
    }

    public void setId__lista(int id__lista) {
        this.id__lista = id__lista;
    }

    public String getTorneo() {
        return torneo;
    }

    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDias_contacto() {
        return dias_contacto;
    }

    public void setDias_contacto(String dias_contacto) {
        this.dias_contacto = dias_contacto;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getNumero_prueba() {
        return numero_prueba;
    }

    public void setNumero_prueba(int numero_prueba) {
        this.numero_prueba = numero_prueba;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "id__lista=" + id__lista +
                ", torneo='" + torneo + '\'' +
                ", campo='" + campo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cargo='" + cargo + '\'' +
                ", dni='" + dni + '\'' +
                ", codigo_postal='" + codigo_postal + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contacto='" + contacto + '\'' +
                ", dias_contacto='" + dias_contacto + '\'' +
                ", sintomas='" + sintomas + '\'' +
                ", test='" + test + '\'' +
                ", resultado='" + resultado + '\'' +
                ", numero_prueba=" + numero_prueba +
                ", analizada=" + analizada +
                '}';
    }
}
