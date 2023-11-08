package PB2.unlam.edu.ar;

import java.util.Objects;

public class Item {

	protected String codigo;
	protected String nombre;
	protected Double precio;

	public Item(String id, String nombre, Double precio) {
		this.codigo = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Item other = (Item) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
}
