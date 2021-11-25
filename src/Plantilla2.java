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
		Empleado empDavid = new Empleado("David",20,77776.222d,false);
		Empleado empJuan = new Empleado("Juan",14,682d,false);
		
		
		//nuevoEmpleado(empJuan);
		//eliminaEmpleado(4);
		muestraEmpleado(4);
		//muestraEmpleados();
		
	}
	
	//Mete los empleados existentes en el fichero dentro de un ArrayList<Empleado>
	//Muestra los datos de los empleados
	public static void muestraEmpleados() {
		//File  .src/datos/Plantilla2.dat
		File filePlantilla2= new File("src"+slash+"datos"+slash+"Plantilla2.dat");
		
		
		//Cuando queda algo raro en el buffer son solo 4 bytes y nuestro objeto siempre va a ocupar mas de 5 bytes en el archivo.
		if(filePlantilla2.length()<5) {
			
			System.out.println("No hay ningun empleado. El archivo esta vacio");
			}else {
			try {	
				filePlantilla2.createNewFile();
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
				filePlantilla2.createNewFile();
				//Si el archivo esta vacio
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
	
	
	
	public static void muestraEmpleado(int orden) {
		//File  .src/datos/Plantilla2.dat
		File filePlantilla2= new File("src"+slash+"datos"+slash+"Plantilla2.dat");
		
		if(filePlantilla2.length()<=0) {
			System.out.println("No hay ningun empleado. El archivo esta vacio");
			}else {
			try {		
				filePlantilla2.createNewFile();
				FileInputStream fis = new FileInputStream(filePlantilla2);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				ArrayList<Empleado> empleados = new ArrayList<Empleado>();
				//Mientras sigamos pudiendo leer del FileInputStream agarramos objetos del fichero
				while(fis.available()>0) {
					Empleado empleadoAuxiliar=new Empleado((Empleado)ois.readObject());
					empleados.add(empleadoAuxiliar);
				}
				ois.close();
				
				
				
				//Si el empleado existe
				if(orden>0&&orden<empleados.size()+1) {
					//Mostramos el empleado
					System.out.printf("%15s%8s%28s%10s%n","Nombre","Edad","Sueldo","Jubilado");
					System.out.println("");
					System.out.printf("%15s%8d%28.2f%10s%n",
						empleados.get(orden-1).getNombre(),
						empleados.get(orden-1).getEdad(),
						empleados.get(orden-1).getSueldo(),
						empleados.get(orden-1).isJubilado()?"Si":"No"
						);
				}else {
					//El numero de empleado debe ser mayor que cero y debe existir en el fichero
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
	
	
	
	
	
	
	public static void eliminaEmpleado(int orden) {
		orden++;
		//File  .src/datos/Plantilla2.dat
		File filePlantilla2= new File("src"+slash+"datos"+slash+"Plantilla2.dat");
		
		if(filePlantilla2.length()<=0) {
			
			System.out.println("No hay ningun empleado. El archivo esta vacio");
			}else {
			try {	
				
				filePlantilla2.createNewFile();
				FileInputStream fis = new FileInputStream(filePlantilla2);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				ArrayList<Empleado> empleados = new ArrayList<Empleado>();
				//Mientras sigamos pudiendo leer del FileInputStream agarramos objetos del fichero
				while(fis.available()>0) {
					Empleado empleadoAuxiliar=new Empleado((Empleado)ois.readObject());
					empleados.add(empleadoAuxiliar);
				}
				ois.close();
				
				
				
				//Si el empleado existe
				if(orden-1>0&&orden-2<empleados.size()) {
					//Eliminamos el empleado del ArrayList

						empleados.remove(orden-2);
					
						//Escribimos todos los empleados de una vez en el fichero
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePlantilla2));
						for(Empleado empleado:empleados) {
							oos.writeObject(empleado);
						}
						
						oos.close();
					
				}else {
					//El numero de empleado debe ser mayor que cero y debe existir en el fichero
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
	
	
}
