package servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import entidades.paciente;

public class implFichero implements intFichero {

	@Override
	public void AbrirFicheroEscritura(File archivo, List<paciente> bd) 
	{
		//Se crea un filleWrites vacío de inicio, para luego darle el valor de nuestro archivo de texto:
		FileWriter fichero = null;
		
        try
        {
        	//Se le da el valor al escrito de texto:
        	fichero = new FileWriter(archivo);

        } catch (Exception e) {
        	System.err.println("***ERROR***No se pudo abrir el fichero.");
        } 
        
        //Llamada a la escritura, donde se escribirá, todos los datos de nuestras mascotas en el archivo:
        EscribirFichero(fichero,archivo,bd);
	}

	
	@Override
	public void EscribirFichero(FileWriter fichero,File archivo, List<paciente> bd) 
	{				
		 try
	        {
			 	//Es el que escribe en las lineas:
	        	PrintWriter pw= new PrintWriter(fichero);
	        	
	        	EscribirEncabezado(archivo);
	        	
	        	for(paciente paci : bd)
	        	{
	        		//Se escriben los datos en el fichero:
	        		pw.println(paci.getNombrePaciente()+";"+paci.getNumeroTelefono()+";"+paci.getFechaIngreso()+";"+paci.getFechaAlta()+";");
	        	}
	        		               	        	
	        } catch (Exception e) {
	        	System.err.println("***ERROR***No se pudo escribir en el fichero.");
	        } finally {
	        	CerrarFichero(fichero);
	        }
	}

	@Override
	public void CerrarFichero(FileWriter fichero) 
	{
		try {	           
	           if (null != fichero)
	              fichero.close();
	           
	        }catch (Exception e2){
	        	   System.err.println("***ERROR***No se pudo cerrar el fichero.");
	            }
	}

	@Override
	public void AbrirFicheroLeer(File archivo, List<paciente> bd) 
	{
	      FileReader fr = null;
	      BufferedReader br = null;

	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder hacer la lectura:
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero:
	         String linea;
	         while((linea=br.readLine())!=null)
	            System.out.println(linea);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	    	  
	    	 //En el finally, se llama la método para cerrar dicho fichero:
	         CerrarFicheroLeido(fr);
	      }
	   }

	@Override
	public void CerrarFicheroLeido(FileReader fr) 
	{
		try {
			 if (null != fr)
				 fr.close();
	          } catch (Exception e2) {
	             e2.printStackTrace();
	          }
	}
	
	@Override
	public void EscribirEncabezado(File archivo) 
	{
		 FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	        	//Escribir el encabezado
	            fichero = new FileWriter(archivo);
	            
	            pw = new PrintWriter(fichero);

	                pw.println("nombre;telefono;fecha ingreso;fecha alta;");

	        }catch (IOException e) 
	        {
	        	System.err.println("***ERROR***No se pudo aceder el fichero.");
	        } 
	        catch (Exception e) {
	        	System.err.print("***ERROR***Se ha producido un error.");
	        } finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	      }
	}
}