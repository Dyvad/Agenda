package Principal;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main (String args[]) throws IOException {
    Gestor a = new Gestor();
    String opcion = "0";
    String textoAuditoria;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    textoAuditoria =("\nSe ha accedido al sistema en la fecha y hora:"+dtf.format(LocalDateTime.now())+"\n");
    System.out.println(a.Registrar("Auditoria.txt",textoAuditoria));
    Scanner scan = new Scanner(System.in);
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
    
    if (opcion.equals("1")){
        textoAuditoria =("Ha accedido " + nombre +" con la opción 1.Listar contactos");
    }if(opcion.equals("2")){
        textoAuditoria =("Ha accedido " + nombre +" con la opción 2.Agregar contacto");
    }if(opcion.equals("3")){
        textoAuditoria =("Ha accedido " + nombre +" con la opción 3.Modificar contacto");
    }if(opcion.equals("4")){
        textoAuditoria =("Ha accedido " + nombre +" con la opción 4.Eliminar contacto");
    }if(opcion.equals("5")){
        textoAuditoria =("Ha accedido " + nombre +" con la opción 5.Agregar Usuario");
    }
    System.out.println(a.Registrar("Auditoria.txt",textoAuditoria));
    
    if (Nivel < 4){
        if ("1".equals(opcion)){
        System.out.println(a.leer("Contactos.txt"));
        textoAuditoria =("Ha listado los contactos de Contactos.txt\n");
    System.out.println(a.Registrar("Auditoria.txt",textoAuditoria));
        }
    }
    if (Nivel < 3){
        if ("2".equals(opcion)){
            System.out.print("\nQue contacto deseas agregar(Nombre apellidos numero): \n");
            String nuevo = scan.nextLine();
            System.out.print("El contacto ");
            System.out.println(a.Agregar("Contactos.txt",nuevo));
            System.out.print(" a sido creado.");
            textoAuditoria =("Ha agreagado el contacto" + nuevo + "\n");
            System.out.println(a.Registrar("Auditoria.txt",textoAuditoria));
        }
        if ("3".equals(opcion)){
            System.out.print("\nQue contacto deseas modificar(Nombre apellidos numero): \n");
            System.out.println(a.leer("Contactos.txt"));
            String antiguo = scan.nextLine();
            System.out.print("Como deseas modificarlo(Nombre apellidos numero): \n");
            String nuevo = scan.nextLine();
            System.out.print("El contacto " + antiguo + " a sido modificado a:");
            System.out.println(a.Modificar("Contactos.txt",antiguo,nuevo));
            textoAuditoria =("Ha modificado el contacto: " + antiguo + "\nA el contacto " + nuevo + "\n");
            System.out.println(a.Registrar("Auditoria.txt",textoAuditoria));
        }
    }
    if (Nivel < 2){
        if ("4".equals(opcion)){
            System.out.print("\nQue contacto deseas Eliminar((Nombre apellidos numero)): \n");
            System.out.println(a.leer("Contactos.txt"));
            String nuevo = scan.nextLine();
            System.out.print("El contacto con numero ");
            System.out.println(a.Eliminar("Contactos.txt",nuevo));
            System.out.print(" a sido eliminado.");
            textoAuditoria =("Se ha eliminado el contacto: " + nuevo + "\n");
            System.out.println(a.Registrar("Auditoria.txt",textoAuditoria));
        }
        if ("5".equals(opcion)){
            System.out.print("\nQue usuario deseas crear(Nombre-Nivel): \n");
            String nuevo = scan.nextLine();
            System.out.print("El usuario ");
            System.out.println(a.Agregar("Usuarios.txt",nuevo));
            System.out.print(" a sido creado.");
            textoAuditoria =("Se ha agregado el usuario: " + nuevo + "\n");
            System.out.println(a.Registrar("Auditoria.txt",textoAuditoria));
        }
    }
    
    }
}