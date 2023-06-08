package servicios;

import java.io.File;

import java.util.List;
import java.util.Scanner;

import entidades.paciente;

public class implPaciente implements intPaciente {

	@Override
	public void InsertarPaceinte(List<paciente> bd,File archivo) {
		Scanner sc=new Scanner(System.in);
		
		//Se crea un nuevo paciente en la base y se le dan los datos que se pasan por pantalla:
		paciente paci=new paciente();
		Scanner pregunta=new Scanner(System.in);
		System.out.print("\nIntroduce en nombre del nuevo paciente: ");
		paci.setNombrePaciente(pregunta.next());
		System.out.print("\nIntroduce el numero de telefono del dueño del paciente: ");
		paci.setNumeroTelefono(pregunta.next());
		System.out.print("\nIndique el día del ingreso: ");
		int dia = sc.nextInt();
		
		System.out.print("\nIndique el mes del ingreso: ");
		int mes = sc.nextInt();
		
		System.out.print("\nIndique el año del ingreso: ");
		int anyo = sc.nextInt();
		
		//Para tener la fecha de ingreso:
		String fechaIngreso = (dia + "-" + mes + "-" + anyo);
		paci.setFechaIngreso(fechaIngreso);
		
		//La fecha de alta, de base, será "-":
		paci.setFechaAlta("-");
		
		//Añadimos el nuevo paciente a la lista:
		bd.add(paci);
	}

	@Override
	public void ModificarPaciente(File archivo,List<paciente> bd) {
		Scanner pregunta=new Scanner(System.in);
		intFichero fichero=new implFichero();
		String NumeroTlf;
			
			//Se le pregunta primero el número de teléfono del paciente y luego se registra si existe mediante un bucle for each:
			System.out.print("\nIntroduce el número de telefono del paciente a dar de alta: ");
			NumeroTlf=pregunta.next();
			for(paciente paciente: bd)
			{
				if(paciente.getNumeroTelefono()==NumeroTlf)
				{
					System.out.print("\nIndique el día del ingreso: ");
					int dia = pregunta.nextInt();
					
					System.out.print("\nIndique el mes del ingreso: ");
					int mes = pregunta.nextInt();
					
					System.out.print("\nIndique el año del ingreso: ");
					int anyo = pregunta.nextInt();
					
					String fechaAlta = (dia + "-" + mes + "-" + anyo);
					
					//Se edita para darle un valor al alta:
					paciente.setFechaAlta(fechaAlta);
					System.out.println("Hecho ;)");
				}
				else
					System.err.println("\n***ERROR***No existe ningún paciente con dicho número de dueño.");
			}			
		fichero.AbrirFicheroEscritura(archivo, bd);
	}
}