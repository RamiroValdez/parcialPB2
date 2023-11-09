package PB2.unlam.edu.ar;

import java.util.Objects;

public class Vendedor {

	private String dni;
	private String nombre;
	private Integer comision;
	private Double montoTotalPorComision;

	public Vendedor(String dniEjemplo, String nombre) {
		// TODO Auto-generated constructor stub
		this.dni = dniEjemplo;
		this.nombre = nombre;
		this.comision = 0;
		this.montoTotalPorComision = 0d;
	}
	
	public String getDni() {
		return dni;
	}
	public Integer getComision() {
		return comision;
	}
	public String getNombre() {
		return nombre;
	}
	public void setComision(Integer comision) {
		// TODO Auto-generated method stub
		this.comision = comision;
		
	}
	
	public void setMontoTotalPorComision(Double montoTotalPorComision) {
		this.montoTotalPorComision = this.montoTotalPorComision + montoTotalPorComision;
	}

	public Double getMontoTotalPorComision() {
		return montoTotalPorComision;
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
