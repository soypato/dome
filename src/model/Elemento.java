package model;

public abstract class Elemento {
    private String titulo;
    private int duracion;
    private boolean loTengo;
    private String comentario;

    public Elemento(String titulo, int duracion, String comentario) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.loTengo = true;
        this.comentario = comentario;
    }

    public Elemento()
    {
        this.titulo = " ";
        this.duracion = 0;
        this.loTengo = true;
        this.comentario = " ";
    }


    // GETTERS
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean isLoTengo() {
        return loTengo;
    }

    public String getComentario() {
        return comentario;
    }

    // SETTERS

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setLoTengo(boolean loTengo) {
        this.loTengo = loTengo;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    // IMPRESION
    @Override
    public String toString()
    {
        String resultado = " ";
        resultado += "\n" + titulo + "\nDuracion: " + duracion + "\nEn nuestro poder?: " + loTengo + "\nComentario: " + comentario;
        return resultado;
    }


}
