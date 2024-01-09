package com.gestion.empleados.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Esta anotación indica que la clase es una entidad persistente que se almacenará en la base de datos.
@Table(name = "empleados") // Especifica el nombre de la tabla en la base de datos para esta entidad.
public class Empleado {

	@Id//Marca el campo como clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Indica que se generará automáticamente y será un valor incremental.
	private Long id;

	//Indica que el campo "" en la base de datos será una columna con restricciones
	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 60, nullable = false)
	private String apellido;

	@Column(name = "email", length = 60, nullable = false, unique = true)
	private String email;

	
	 //Constructor vacío requerido por JPA (Java Persistence API).
	public Empleado() {

	}

	public Empleado(Long id, String nombre, String apellido, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	
	 //Metodos(getters y setters) para los campos de la entidad.
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

/*Los métodos son fundamentales en la programación orientada a objetos y 
 * permiten organizar y modularizar el código.*/
