package model;

public class DVD extends Elemento{
    private String director;

    public DVD(String titulo, int duracion, String comentario, String director) {
        super(titulo, duracion, comentario);
        this.director = director;
    }
    public DVD() {
        super();
        this.director = " ";
    }

    // GETTERS
    public String getDirector() {
        return director;
    }

    // SETTERS
    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object anObject)
    {
        boolean res = false;
        if(anObject instanceof DVD)
        {
            DVD dvdTmp = (DVD)anObject;
            if(getTitulo().equals(dvdTmp.getTitulo()))
            {
                res = true;
            }
        }
        return res;
    }
}
