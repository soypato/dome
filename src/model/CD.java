package model;

public class CD extends Elemento{
    private String interpete;
    private int numeroTemas;

    public CD(String titulo, int duracion, String comentario, String interpete, int numeroTemas) {
        super(titulo, duracion, comentario);
        this.interpete = interpete;
        this.numeroTemas = numeroTemas;
    }

    public CD()
    {
        super();
        this.interpete = "";
        this.numeroTemas = 0;
    }

   // GETTERS
    public String getInterpete() {
        return interpete;
    }

    public int getNumeroTemas() {
        return numeroTemas;
    }

    // SETTERS

    public void setInterpete(String interpete) {
        this.interpete = interpete;
    }

    public void setNumeroTemas(int numeroTemas) {
        this.numeroTemas = numeroTemas;
    }

    // IMPRESION
    public String toString()
    {
        String resultado = " ";
        resultado += super.toString();
        resultado += "\nInterprete: " + interpete + "\nNumero de temas: " + numeroTemas;
        return resultado;
    }

    @Override
    public boolean equals(Object anObject)
    {
        boolean res = false;
        if(anObject instanceof CD)
        {
            CD cdTmp = (CD)anObject;
            if(getTitulo().equals(cdTmp.getTitulo()))
            {
                res = true;
            }
        }
        return res;
    }

    // CHEQUEAR ESTO: NO FUNCIONA EL BORRADO
    public void eliminarCD(String nombreCD)
    {

    }

}
