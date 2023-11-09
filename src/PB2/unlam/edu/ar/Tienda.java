package PB2.unlam.edu.ar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tienda {

	private String cuit;
	private String nombre;
	private Set<Vendible> vendibles;
	private Map<Producto,Integer> stock;
	private Set<Cliente> clientes;
	private Set<Vendedor> vendedores;
	private List<Venta> ventas;

	public Tienda(String cuit, String nombre) {
		// TODO Auto-generated constructor stub
		this.cuit = cuit;
		this.nombre = nombre;
		this.vendibles = new HashSet<>();
		this.stock = new HashMap<>();
		this.clientes = new HashSet<>();
		this.vendedores = new HashSet<>();
		this.ventas = new ArrayList<>();
	}

	public void agregarProducto(Producto productoAgregar) {
		// TODO Auto-generated method stub
		
		agregarProducto(productoAgregar,0);
		
	}
	
	public void agregarProducto(Producto producto, Integer cantidad) {
		// TODO Auto-generated method stub
		
		this.vendibles.add(producto);
		
		this.stock.put(producto, cantidad);
	}

	public Vendible getVendible(String codigo) throws VendibleInexistenteException {
		// TODO Auto-generated method stub
		for (Vendible v : vendibles) {
			if(v.getCodigo().equals(codigo)) {
				return v;
			}
		}
		
		throw new VendibleInexistenteException();
		
	}

	public Integer getStock(Producto producto) {
		// TODO Auto-generated method stub
		for (Map.Entry<Producto, Integer> entry : stock.entrySet()) {
			Producto key = entry.getKey();
			Integer val = entry.getValue();
			
			if(key.equals(producto)) {
				return val;
			}
			
		}
		
		return null;
		
	}

	public void agregarCliente(Cliente cliente) throws YaExisteClienteException {
		// TODO Auto-generated method stub
		
		if(clientes.contains(cliente)) {
			throw new YaExisteClienteException();
		}
		
		this.clientes.add(cliente);
	}

	public Cliente getCliente(String cuitEjemplo) throws ClienteInexistenteException {
		// TODO Auto-generated method stub
		for (Cliente cliente : clientes) {
			if(cliente.getCuit().equals(cuitEjemplo)) {
				return cliente;
			}
		}
		
		
		throw new ClienteInexistenteException();
	}

	public void agregarVendedor(Vendedor vendedor) {
		// TODO Auto-generated method stub
		this.vendedores.add(vendedor);
	}

	public Vendedor getVendedor(String dniEjemplo) throws VendedorInexistenteException {
		// TODO Auto-generated method stub
		for (Vendedor vendedor : vendedores) {
			if(vendedor.getDni().equals(dniEjemplo)) {
				return vendedor;
			}
		}
		
		throw new VendedorInexistenteException();
	}

	public void agregarVenta(Venta ticket) {
		// TODO Auto-generated method stub
		this.ventas.add(ticket);
	}

	public Venta buscarVentaPorCodigo(String codigo) {
		for (Venta venta : ventas) {
			if(venta.getCodigo().equals(codigo)) {
				return venta;
			}
		}
		
		return null;
	}
	public void agregarProductoAVenta(String codigo, Producto producto, Integer cantidadVendida) throws StockInsuficienteException {
		// TODO Auto-generated method stub
		if(buscarVentaPorCodigo(codigo)!=null) {
			
			if(getStock(producto)>=cantidadVendida) {
				
				Integer stockDescontado = getStock(producto) - cantidadVendida; 
				buscarVentaPorCodigo(codigo).agregarVentaProducto(producto, cantidadVendida);
				
				stock.put(producto, stockDescontado);
				
				
			}else {
				
				throw new StockInsuficienteException();
			}
			
			
			
		}
		
		
	}

	public void agregarServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		this.vendibles.add(servicio);
	}

	public void agregarServicioAVenta(String codigo, Servicio servicio) {
		// TODO Auto-generated method stub
		if(buscarVentaPorCodigo(codigo)!=null) {
			buscarVentaPorCodigo(codigo).agregarVentaServicio(servicio);
		}
	}

	public void establecerComisionVendedor(Vendedor vendedor, Integer comision) {
		// TODO Auto-generated method stub
		if(this.vendedores.contains(vendedor)) {
			
			for (Vendedor vend : vendedores) {
				if(vend.equals(vendedor)) {
					vend.setComision(comision);
				}
			}
			
		}
	}

	public Integer conocerComisionVendedor(Vendedor vendedor) {
		// TODO Auto-generated method stub
		if(this.vendedores.contains(vendedor)) {
			for (Vendedor vend : vendedores) {
				if(vend.equals(vendedor)) {
					return vend.getComision();
				}
			}
		}
		
		return null;
	}

	public void aplicarComision(Venta venta, Vendedor vendedor) {
		
		Double comisionADar = ((vendedor.getComision()*venta.getTotal())/100);
		
		vendedor.setMontoTotalPorComision(comisionADar);
	}
	public void aplicarTotalComisionVendedor(Vendedor vendedor) {
		// TODO Auto-generated method stub
		for (Venta venta : ventas) {
			if(venta.getVendedor().equals(vendedor)) {
				
				aplicarComision(venta, vendedor);
				
			}
		}
	}

	public Double obtenerTotalComisionVendedor(Vendedor vendedor) {
		
		if(this.vendedores.contains(vendedor)) {
			
			for (Vendedor v : vendedores) {
				if(v.equals(vendedor)) {
					return v.getMontoTotalPorComision();
				}
			}
		}
		
		return null;
	}


}
