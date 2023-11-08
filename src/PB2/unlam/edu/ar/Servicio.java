package PB2.unlam.edu.ar;

public class Servicio extends Item implements Vendible {

	private String fechaInicio;
	private String fechaFinal;

	public Servicio(String id, String nombre, Double precio,String fehaInicio,String fechaFinal) {
		super(id, nombre, precio);
		this.fechaInicio = fehaInicio;
		this.fechaFinal = fechaFinal;
		// TODO Auto-generated constructor stub
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
