/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author Marcos
 */
//import java.util.ArrayList;
//import java.util.Scanner;
//
public final class GestorPacientes {
 //chekear por dni
    
    
 if(dni=0){
    
    system.out(paciente);
}

}
//	
//	private final ArrayList<DAL.PaciDao> pacientes;
//	private final Scanner teclado; //no es con scanner es igual al de logueo
//	
//	public GestorPacientes() {
//		pacientes = new ArrayList<DAL.PaciDao>();
//		teclado = new Scanner(System.in); //no es con este....
//	}
//	
//	/**
//	 * Crea y registra un nuevo paciente.
//	 * @return True si se pudo registrar con éxito el nuevo paciente.
//	 * False si no fue posible registrarlo.
//	 */
//	public boolean nuevoPaciente() {
//		System.out.println("\n\tALTA NUEVO PACIENTE");
//		System.out.print("Introduzca Identificador: ");//HISTORIA CLINICA
//		String id = teclado.nextLine();
//		System.out.print("Nombre: ");
//		String nombre = teclado.nextLine();
//		System.out.print("Apellidos: ");
//		String apellidos = teclado.nextLine();
//		System.out.print("Genero: "); //F.M.NB
//                
//                
//		String genero = teclado.nextLine();
//		System.out.print("Edad: ");
//		int edad = teclado.nextInt();
//		teclado.nextLine();//Tras leer un int, conviene "limpiar" el stream de entrada, para evitar problemas al querer leer luego datos String
//                DAL.PaciDao nuevoPaciente = new DAL.PaciDao(id, nombre, apellidos, edad, genero);
//		return pacientes.add(nuevoPaciente);//Devuelve TRUE si se insertó correctamente, FALSE si no se pudo insertar
//	}
//	
//	/**
//	 * Lista por pantalla los datos de todos los pacientes registrados.
//	 */
//	public void mostrarPacientes() {
//		for (DAL.PaciDao p: pacientes)
//			p.mostrar();
//	}
//
//}