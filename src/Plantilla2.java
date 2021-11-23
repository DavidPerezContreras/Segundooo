package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;	//class Empleado implements Serializable
import java.util.ArrayList;

public class Plantilla2 {

	//Separador especifico del sistema operativo
	final static private String slash=File.separator;
	

	public static void main(String[] args) {
		Empleado empDavid = new Empleado("David",20,6827777777777776.222d,false);
		Empleado empJuan = new Empleado("Juan",14,682d,false);
		nuevoEmpleado(empDavid);
		//nuevoEmpleado(empJuan);
		muestraEmpleados();
		
	}
	
	//Mete los empleados existentes en el fichero dentro de un ArrayList<Empleado>
	//Muestra los datos de los empleados
	public static void muestraEmpleados() {
		//File  .src/datos/Plantilla2.dat
		File filePlantilla2= new File("src"+slash+"datos"+slash+"Plantilla2.dat");
		
		if(filePlantilla2.length()<=0) {
			System.out.println("No hay ningun empleado. El archivo esta vacio");
			}else {
			try {		
				FileInputStream fis = new FileInputStream(filePlantilla2);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				ArrayList<Empleado> empleados = new ArrayList<Empleado>();
				//Mientras sigamos pudiendo leer del FileInputStream agarramos objetos del fichero
				while(fis.available()>0) {
					Empleado empleadoAuxiliar=new Empleado((Empleado)ois.readObject());
					empleados.add(empleadoAuxiliar);
				}
				ois.close();
				
				
				
				//Mostramos los empleados
					System.out.printf("%15s%8s%28s%10s%n","Nombre","Edad","Sueldo","Jubilado");
					System.out.println("");
				
				for (Empleado empleado:empleados) {
					
					System.out.printf("%15s%8d%28.2f%10s%n",
							empleado.getNombre(),
							empleado.getEdad(),
							empleado.getSueldo(),
							empleado.isJubilado()?"Si":"No"
					);
				}
				

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//Fin del IF
		
	
		
		
	}
	
	
	static void nuevoEmpleado (Empleado emp) {
		final File filePlantilla2 = new File("src"+slash+"datos"+slash+"Plantilla2.dat");
	
			try {

				if(filePlantilla2.length()<=0) {
				
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePlantilla2));

					oos.writeObject(emp);
		
					oos.close();
					
				}else {
					FileInputStream fis = new FileInputStream(filePlantilla2);
					ObjectInputStream ois = new ObjectInputStream(fis);
					
					ArrayList<Empleado> empleados = new ArrayList<Empleado>();
					
					//Mientras sigamos podiendo leer del FileInputStream
					while(fis.available()>0) {
						Empleado empleadoAuxiliar=new Empleado((Empleado)ois.readObject());
						empleados.add(empleadoAuxiliar);
						
					}
					
					ois.close();
					
					empleados.add(emp);
					//Ahora el ArrayList<Empleado> empleados contiene todos los empleados
					
					
					//Escribimos todos los empleados de una vez en el fichero
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePlantilla2));
					for(Empleado empleado:empleados) {
						oos.writeObject(empleado);
					}
					
					oos.close();
				
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
	}
}
