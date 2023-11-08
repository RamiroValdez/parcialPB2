package PB2.unlam.edu.ar;

import java.util.Objects;

public class Vendedor {

	private String dni;
	private String nombre;

	public Vendedor(String dniEjemplo, String nombre) {
		// TODO Auto-generated constructor stub
		this.dni = dniEjemplo;
		this.nombre = nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(dni, other.dni);
	}
	
	

}
