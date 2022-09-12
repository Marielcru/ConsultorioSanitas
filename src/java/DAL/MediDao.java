/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 *@author Marcos
 */
public class MediDao {
        
    private String id;
	private String nombre;
	private String apellidos;
	private String especialidad;
	
	public MediDao(String id, String nombre, String apellidos, String especialidad) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.especialidad = especialidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	/**
	 * Muestra por consola todos los datos del Medico
	 */
	public void mostrar() {
		System.out.println("\n\t---------------");
		System.out.println("ID Medico: " + id);
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellidos: " + apellidos);
		System.out.println("Especialidad: " + especialidad);
		System.out.println("\t---------------");
	}

}
