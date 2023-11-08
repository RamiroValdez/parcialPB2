package PB2.unlam.edu.ar;

public class Producto extends Item implements Vendible{


	public Producto(String id, String nombre, Double precio) {
		// TODO Auto-generated constructor stub
		super(id,nombre,precio);
	}

	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return this.codigo;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public Double getPrecio() {
		// TODO Auto-generated method stub
		return this.precio;
	}

}
