package model;

import java.util.ArrayList;

public class Dome {
    private ArrayList<Elemento> catalogo;

    // CONSTRUCTORES
    public Dome() {
        this.catalogo = new ArrayList<>();
    }


    // SETTERS
    public void agregarUnCD(String titulo, int duracion, String comentario, String interprete, int numeroTemas)
    {
        CD cdTmp = new CD(titulo, duracion, comentario, interprete, numeroTemas);
        catalogo.add(cdTmp);
    }

    public void agregarUnDVD(String titulo, int duracion, String comentario, String director)
    {
        DVD dvdTmp = new DVD(titulo, duracion, comentario, director);
        catalogo.add(dvdTmp);
    }

    // GETTERS - FUNCIONES DE MUESTREO
    public String toStringCDS()
    {
        String respuesta = "";
        for(Elemento e : catalogo)
        {
            if(e instanceof CD){
                CD cdTmp = (CD)e;
                respuesta += cdTmp.toString();
            }
        }
        return respuesta;
    }

    public String toStringDVDS()
    {
        String respuesta = "";
        for(Elemento e : catalogo)
        {
            if(e instanceof DVD){
                DVD dvdTmp = (DVD)e;
                respuesta += dvdTmp.toString();
            }
        }
        return respuesta;
    }
    
    @Override
    public String toString()
    {
        String respuesta = "";
        for(Elemento e : catalogo)
        {
            if(e instanceof CD)
            {
                CD cdTmp = (CD)e;
                respuesta += cdTmp.toString();
            }
            else if(e instanceof DVD)
            {
                DVD dvdTmp = (DVD)e;
                respuesta += dvdTmp.toString();
            }
        }
        return respuesta;
    }


    // FUNCIONES DE BUSQUEDA

    public CD buscarCD(String nombreCD)
    {
        boolean flag = false;
        CD tmp = null;
        CD respuesta = null;

        for(int i = 0; i < catalogo.size() && !flag; i++)
        {
            if(catalogo.get(i) instanceof CD)
            {
                tmp = (CD) catalogo.get(i); // TMP para listar no solo los metodos publicos
                if(tmp.getTitulo().equals(nombreCD)) // si coincide con el de tmp
                {
                    respuesta = tmp; // esa sera la respuesta, de lo contrario null
                    flag = true;
                }
            }
        }
        return respuesta;
    }

    public String buscarCDsXInterprete(String interprete)
    {
        String tmp = " ";

        for(int i = 0; i < catalogo.size(); i++)
        {
            if(catalogo.get(i) instanceof CD)
            {
                CD cdTmp = (CD)catalogo.get(i);
                if(cdTmp.getInterpete().equals(interprete))
                {
                    tmp += "\n--------\n" + cdTmp.toString();
                }
            }
        }


        return tmp;
    }

    public DVD buscarDVD(String nombre)
    {
        DVD tmp = null;
        DVD respuesta = null;
        boolean flag = false;

        for(int i = 0; i < catalogo.size() && !flag; i++)
        {
            if(catalogo.get(i) instanceof DVD)
            {
                tmp = (DVD) catalogo.get(i);
                if(tmp.getTitulo().equals(nombre))
                {
                    respuesta = tmp;
                    flag = true;
                }
            }
        }
        return respuesta;
    }


    // FUNCIONES DE ACTUALIZACION
    
    public boolean actualizarEstadoPorNombreCD(String nombre)
    {
        CD tmp = buscarCD(nombre);
        boolean flag = false;

        if(tmp != null)
        {
            tmp.setLoTengo(!tmp.isLoTengo()); // lo invierto
            flag = true;
        }
        return flag;
    }

    public boolean actualizarEstadoPorNombreDVD(String nombre)
    {
        DVD tmp = buscarDVD(nombre);
        boolean flag = false;

        if(tmp != null)
        {
            tmp.setLoTengo(!tmp.isLoTengo());
            flag = true;
        }
        return flag;
    }

    
    // FUNCIONES DE ELIMINACION 
    
    public boolean eliminarCD(String nombre)
    {
        boolean flag = false;
        CD respuesta = buscarCD(nombre);
        if(respuesta != null)
        {
            catalogo.remove(respuesta);
            flag = true;
        }
        return flag;
    }


    public boolean eliminarDVD(String nombreDVD)
    {
        boolean flag = false;
        DVD tmp = buscarDVD(nombreDVD);
        if(tmp != null)
        {
            catalogo.remove(tmp);
            flag = true;
        }

        return flag;
    }

}
