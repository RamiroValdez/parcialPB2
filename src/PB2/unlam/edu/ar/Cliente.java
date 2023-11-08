package PB2.unlam.edu.ar;

import java.util.Objects;

public class Cliente {

	private String cuit;
	private String nombre;

	public Cliente(String cuitEjemplo, String nombre) {
		// TODO Auto-generated constructor stub
		this.cuit = cuitEjemplo;
		this.nombre = nombre;
	}
	
	public String getCuit() {
		return cuit;
	}
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cuit, other.cuit);
	}
	
	

}
