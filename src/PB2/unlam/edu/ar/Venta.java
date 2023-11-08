package PB2.unlam.edu.ar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Venta {

	private String codigo;
	private Cliente cliente;
	private Vendedor vendedor;
	private Map<Producto, Integer> listaDeProductosAVender;
	private Set<Servicio> listaDeServiciosAVender;
	private Double totalGastado;

	public Venta(String codigo, Cliente cliente, Vendedor vendedor) {
		// TODO Auto-generated constructor stub
		this.codigo = codigo;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.totalGastado = 0.0;
		this.listaDeProductosAVender = new HashMap<>();
		this.listaDeServiciosAVender = new HashSet<>();
		
	}

	public String getCodigo() {
		// TODO Auto-generated method stub
		return this.codigo;
	}

	public void agregarVentaProducto(Producto producto, Integer cantidad) {
		this.listaDeProductosAVender.put(producto, cantidad);
		this.totalGastado = totalGastado + (producto.getPrecio()*cantidad);
	}
	
	public void agregarVentaServicio(Servicio servicio) {
		this.listaDeServiciosAVender.add(servicio);
		this.totalGastado = totalGastado + servicio.getPrecio();
	}

	public Double getTotal() {
		// TODO Auto-generated method stub
		return this.totalGastado;
	}
	
	
}
