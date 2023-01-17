package Principal;

import java.io.*;

public class Gestor {
    public int Nivel(String direccion, String nombre){
        int nivel=4;
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                String[] parts = bfRead.split("-");
                String NombreLinea = parts[0];
                String NivelLinea = parts[1]; // 1 2 o 3
                if(NombreLinea.equals(nombre)){
                    nivel = Integer.parseInt(NivelLinea);
                }
                
            }
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        return nivel;
    }
    public String leer(String direccion){
        
        String texto = " ";
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                
                temp = temp + bfRead +"\n";
                
            }
            
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        
        return texto;
    }
    
    public String leerNombres(String direccion){
        
        String texto = " ";
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                String[] parts = bfRead.split("-");
                String NombreLinea = parts[0];
                temp = temp + NombreLinea +"\n";
                
            }
            
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        
        return texto;
    }
    
    public String Modificar(String direccion, String antiguo, String nuevo ) throws IOException{
        
        String texto = "";
        String temp = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                if(bfRead.equals(antiguo)){
                }
                else {
                temp = temp + bfRead +"\n";
                }
                
            }
            temp = temp + nuevo +"\n";
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        FileWriter fichero = new FileWriter (direccion);
        fichero.write(texto);
        fichero.close();
        return nuevo;
    }
    
    public String Eliminar(String direccion, String numero ) throws IOException{
        
        String texto = " ";
        String temp = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                if(bfRead.equals(numero)){
                }
                else {
                temp = temp + bfRead +"\n";
                }
            }
            
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        FileWriter fichero = new FileWriter (direccion);
        fichero.write(texto);
        fichero.close();
        return numero;
    }
    
    public String Agregar(String direccion, String nuevo) throws IOException{
        String texto = " ";
        String temp = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                temp = temp + bfRead +"\n";
            }
            temp = temp + nuevo +"\n";
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        FileWriter fichero = new FileWriter (direccion);
        fichero.write(texto);
        fichero.close();
        return nuevo;
    }
    
    public String cifrar(String letras, String direccion){
    String textoCodificado = "";
    String texto = " ";
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                
                temp = temp + bfRead +"\n";
                
            }
            
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
    texto = texto.toUpperCase();
    char caracter;
    for (int i = 0; i < texto.length(); i++) {
        caracter = texto.charAt(i);
        int pos = letras.indexOf(caracter);
 
        if(pos == -1){
            textoCodificado += caracter;
        }else{
            textoCodificado += letras.charAt( (pos + 3) % letras.length() );
        }
 
    }
    return textoCodificado;
}
    
    public String descifrar(String letras, String direccion){
    String textoDescodificado = "";
    String texto = " ";
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                
                temp = temp + bfRead +"\n";
                
            }
            
            texto = temp;
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
    texto = texto.toUpperCase();
    char caracter;
    for (int i = 0; i < texto.length(); i++) {
        caracter = texto.charAt(i);
 
        int pos = letras.indexOf(caracter);
 
        if(pos == -1){
            textoDescodificado += caracter;
        }else{
            if(pos - 3 < 0){
                textoDescodificado += letras.charAt( letras.length() + (pos - 3) );
            }else{
                textoDescodificado += letras.charAt( (pos - 3) % letras.length() );
            }
        }
 
    }
    return textoDescodificado;
}
    
    public String reescribir(String direccion, String texto) throws IOException{
        String resultado = "se ha reescrito el texto\n";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            
        }catch(IOException e){ 
            System.err.println("Archivo no encontrado");
        }
        FileWriter fichero = new FileWriter (direccion);
        fichero.write(texto);
        fichero.close();
        return resultado;
    }
}
