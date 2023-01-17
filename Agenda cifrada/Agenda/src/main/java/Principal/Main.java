package Principal;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String args[]) throws IOException {
    Gestor a = new Gestor();
    String letras = "A1BCD2EFG3HIJ4KLM5-NÑO6PQ7RSTU8VWX9YZ0";
    String opcion = "0";
    Scanner scan = new Scanner(System.in);
    String Codificado;
    String Texto_decodificado;
    //decodifica
    Texto_decodificado = (a.descifrar(letras,"Contactos.txt"));
    System.out.print(a.reescribir("Contactos.txt",Texto_decodificado));
    int Nivel;//1=(Administrador) 2(gestor) 3(Asistente)
    System.out.print("Hola usuario! ¿quien eres?\n" );
    System.out.println(a.leerNombres("Usuarios.txt"));
    String nombre = scan.nextLine();
    System.out.print("Hola " + nombre +"\n");
    Nivel =(a.Nivel("Usuarios.txt",nombre));
    System.out.print("\nTienes nivel: " + Nivel +"\n");
    while (Nivel == 3){
    System.out.print("\nSeleccione una:\n");
    System.out.print("1.Listar contactos: \n");
    opcion = scan.nextLine();
    if (opcion.equals("1")){
        break;
      }else{
        System.out.print("Esa no es una opcion\n");
    }
    }
    
    while (Nivel == 2){
    System.out.print("\nSeleccione una:\n");
    System.out.print("1.Listar contactos: \n");
    System.out.print("2.Agregar contacto: \n");
    System.out.print("3.Modificar contacto: \n");
    opcion = scan.nextLine();
    if (opcion.equals("1")||opcion.equals("2")||opcion.equals("3")){
        break;
      }else{
        System.out.print("Esa no es una opcion\n");
    }
    }
    
    while (Nivel == 1){
    System.out.print("\nSeleccione una:\n");
    System.out.print("1.Listar contactos: \n");
    System.out.print("2.Agregar contacto: \n");
    System.out.print("3.Modificar contacto: \n");
    System.out.print("4.Eliminar contacto: \n");
    System.out.print("5.Agregar Usuario: \n");
    opcion = scan.nextLine();
    if (opcion.equals("1")||opcion.equals("2")||opcion.equals("3")||opcion.equals("4")||opcion.equals("5")){
        break;
      }else{
        System.out.print("Esa no es una opcion\n");
    }
    }
    
    if (Nivel < 4){
        if ("1".equals(opcion)){
        System.out.println(a.leer("Contactos.txt"));
        }
    }
    if (Nivel < 3){
        if ("2".equals(opcion)){
            System.out.print("\nQue contacto deseas agregar(Nombre apellidos numero dirección): \n");
            String nuevo = scan.nextLine();
            System.out.print("El contacto ");
            System.out.println(a.Agregar("Contactos.txt",nuevo));
            System.out.print(" a sido creado.");
        }
        if ("3".equals(opcion)){
            System.out.print("\nQue contacto deseas modificar(Nombre apellidos numero dirección): \n");
            System.out.println(a.leer("Contactos.txt"));
            String antiguo = scan.nextLine();
            System.out.print("Como deseas modificarlo(Nombre apellidos numero dirección): \n");
            String nuevo = scan.nextLine();
            System.out.print("El contacto " + antiguo + " a sido modificado a:");
            System.out.println(a.Modificar("Contactos.txt",antiguo,nuevo));
        }
    }
    if (Nivel < 2){
        if ("4".equals(opcion)){
            System.out.print("\nQue contacto deseas Eliminar((Nombre apellidos numero dirección)): \n");
            System.out.println(a.leer("Contactos.txt"));
            String nuevo = scan.nextLine();
            System.out.print("El contacto ");
            System.out.println(a.Eliminar("Contactos.txt",nuevo));
            System.out.print(" a sido eliminado.");
        }
        if ("5".equals(opcion)){
            System.out.print("\nQue usuario deseas crear(Nombre-Nivel): \n");
            String nuevo = scan.nextLine();
            System.out.print("El usuario ");
            System.out.println(a.Agregar("Usuarios.txt",nuevo));
            System.out.print(" a sido creado.");
        }
    }
    //codifica
    Codificado = (a.cifrar(letras,"Contactos.txt"));
    System.out.print(a.reescribir("Contactos.txt",Codificado));
    }
}