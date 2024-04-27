import model.*;

/*

| Debe permitirnos ingresar información sobre los CD y los DVD.
| Debe brindar una función de búsqueda que nos permita por ejemplo, encontrar todos los CD de un cierto intérprete que hay en la base, o todos los DVD de determinado director.
| Debe permitirnos imprimir listados como por ejemplo: listado de todos los DVD que hay en la base o un listado de todos los CD de música.
| Debe permitirnos eliminar información.
| Debe permitir prestar o devolver elementos.

**/


import java.util.Scanner;

public class Main {
    static Scanner scanner1;
    static Dome dome1;
    public static void main(String[] args) {
        scanner1 = new Scanner(System.in);
        dome1 = new Dome();
        menu();
    }

    public static void menu()
    {
        char decision = 's';
        int opcion = 0;

        while(decision == 's')
        {
            System.out.println("1- Agregar CDs");
            System.out.println("2- Agregar DVDs");
            System.out.println("3- Mostrar CDs");
            System.out.println("4- Mostrar DVDs");
            System.out.println("5- Mostrar todo");
            System.out.println("6- Buscar x interprete");
            System.out.println("7- Buscar x director");
            System.out.println("8- Eliminar CD");
            System.out.println("9- Eliminar DVD");
            System.out.println("10- Actualizar prestamo CD");
            System.out.println("11- Actualizar prestamo DVD");
            System.out.print("Su decision: ");
            opcion = scanner1.nextInt();

            switch (opcion)
            {
                case 1:
                    agregarCDs();
                    break;
                case 2:
                    agregarDVDs();
                    break;
                case 3:
                    mostrarCDs();
                    break;
                case 4:
                    mostrarDVDs();
                    break;
                case 5:
                    mostrarTodo();
                    break;
                case 6:
                    buscarInterprete();
                    break;
                case 7:
                    buscarDirector();
                    break;
                case 8:
                    eliminarCD();
                    break;
                case 9:
                    eliminarDVD();
                    break;
                case 11:
                    actualizarPrestamoCD();
                    break;
                case 12:
                    actualizarPrestamoDVD();
                    break;
            }

            System.out.println("Desea continuar el sistema? (s/n): ");
            decision = scanner1.next().charAt(0);
        }

    }

    public static void agregarCDs()
    {
        char decision = 's';
        while(decision == 's')
        {
            System.out.println("Introduzca el nombre");
            scanner1.nextLine();
            String titulo = scanner1.nextLine();

            System.out.println("Vamos con la duracion en minutos");
            int duracion = scanner1.nextInt();

            System.out.println("Introduzca un comentario (o deje vacio en caso de que no quiera)");
            scanner1.nextLine();
            String comentario = scanner1.nextLine();

            System.out.println("Introduzca el interprete");
            String interprete = scanner1.nextLine();

            System.out.println("Vamos con el numero de temas");
            int numTemas = scanner1.nextInt();

            dome1.agregarUnCD(titulo, duracion, comentario, interprete, numTemas);

            System.out.print("Desea agregar otro CD? (s/n): ");
            decision = scanner1.next().charAt(0);
        }
    }


    public static void agregarDVDs()
    {
        char decision = 's';
        while(decision == 's')
        {

            System.out.println("Introduzca el nombre");
            scanner1.nextLine();
            String titulo = scanner1.nextLine();

            System.out.println("Vamos con la duracion en minutos");
            int duracion = scanner1.nextInt();

            System.out.println("Introduzca un comentario (o deje vacio en caso de que no quiera)");
            scanner1.nextLine();
            String comentario = scanner1.nextLine();

            System.out.println("Vamos con el director");
            scanner1.nextLine();
            String director = scanner1.nextLine();

            dome1.agregarUnDVD(titulo, duracion, comentario, director);

            System.out.print("Desea agregar otro DVD? (s/n): ");
            decision = scanner1.next().charAt(0);
        }
    }

    public static void mostrarCDs()
    {
        System.out.println(dome1.toStringCDS());
    }

    public static void mostrarDVDs()
    {
        System.out.println(dome1.toStringDVDS());
    }

    public static void mostrarTodo()
    {
        System.out.println(dome1.toString());
    }

    public static void buscarInterprete()
    {
        char decision = 's';
        while(decision == 's')
        {
            System.out.println("Introduzca el nombre del interprete que quiere buscar");
            scanner1.nextLine();
            String interTmp = scanner1.nextLine();

            String respuesta = dome1.buscarCDsXInterprete(interTmp);
            System.out.println(respuesta);

            System.out.print("Desea continuar? ");
            decision = scanner1.next().charAt(0);
        }
    }

    public static void buscarDirector()
    {
        char decision = 's';
        while(decision == 's')
        {
            System.out.println("Introduzca el nombre del director que quiere buscar");
            scanner1.nextLine();
            String interTmp = scanner1.nextLine();

            //String respuesta = dome1.buscarDVDDirector(interTmp);
            // System.out.println(respuesta);

            System.out.print("Desea continuar? ");
            decision = scanner1.next().charAt(0);
        }
    }

    public static void eliminarCD()
    {
        System.out.print("Introduzca el nombre del CD: ");
        scanner1.nextLine();
        String nombre = scanner1.nextLine();
        boolean respuesta = dome1.eliminarCD(nombre);

        if(respuesta)
        {
            System.out.println("Dato eliminado correctamente");
        }
        else
        {
            System.out.println("Ocurrio un error");
        }

    }

    public static void eliminarDVD()
    {
        System.out.print("Introduzca el nombre del DVD: ");
        scanner1.nextLine();
        String nombre = scanner1.nextLine();
        boolean respuesta = dome1.eliminarDVD(nombre);

        if(respuesta)
        {
            System.out.println("Dato eliminado correctamente");
        }
        else
        {
            System.out.println("Ocurrio un error");
        }

    }


    public static void actualizarPrestamoCD()
    {
        System.out.println("Introduzca el nombre del album que quiera saber");
        scanner1.nextLine();

        String nombre = scanner1.nextLine();

        System.out.println(dome1.buscarCD(nombre));

        System.out.print("Desea actualizar el estado? (s/n): ");
        char decision = scanner1.next().charAt(0);

        if(decision == 's')
        {   
            dome1.actualizarEstadoPorNombreCD(nombre);
        }
        else
        {
            System.out.println("No actualizamos.");
        }

    }

    public static void actualizarPrestamoDVD()
    {
        System.out.println("Introduzca el nombre del DVD que quiera saber");
        scanner1.nextLine();
        String nombre = scanner1.nextLine();

        dome1.buscarCD(nombre);

        System.out.print("Actualizar estado? (s/n): ");
        scanner1.nextLine();
        char decision = scanner1.next().charAt(0);

        if(decision == 's')
        {
            dome1.actualizarEstadoPorNombreDVD(nombre);
        }
        else
        {
            System.out.println("No actualizamos.");
        }


    }
}


