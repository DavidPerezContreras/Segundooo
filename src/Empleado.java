package src;

import java.io.Serializable;

public class Empleado implements Serializable{

	
	
	String nombre; 
	int edad;
	double sueldo;
	boolean jubilado;
	public Empleado(String nombre, int edad, double sueldo, boolean jubilado) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
		this.jubilado = jubilado;
	}
	
	public Empleado(Empleado emp) {
		this.nombre=new String(emp.getNombre());
		this.edad= emp.getEdad();
		this.sueldo=emp.getSueldo();
		this.jubilado=emp.isJubilado();
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public double getSueldo() {
		return sueldo;
	}
	
	
	public boolean isJubilado() {
		return jubilado;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	
}
