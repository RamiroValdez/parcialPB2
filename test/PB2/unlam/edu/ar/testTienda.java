package PB2.unlam.edu.ar;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testTienda {
	
	@Test
	public void queSePuedaAgregarProductos() throws VendibleInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		Producto producto = new Producto("1", "Producto nuevo", 100d);
		tienda.agregarProducto(producto);
		Vendible productoActual = (Producto) tienda.getVendible(producto.getCodigo());
		assertEquals(producto, productoActual);
	}
	
	@Test
	public void queSePuedaAgregarStock() throws VendibleInexistenteException {
		
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		Producto producto = new Producto("1", "Producto nuevo", 100d);
		Integer cantidad = 10;
		tienda.agregarProducto(producto, cantidad);
		Integer stockActual = tienda.getStock((Producto) producto); 
		assertEquals(cantidad, stockActual);
		
		
	}
	
	@Test
	public void queSePuedaAgregarUnCliente() throws ClienteInexistenteException, YaExisteClienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitEjemplo = "30123456780";
		Cliente cliente = new Cliente(cuitEjemplo, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		Cliente clienteActual = tienda.getCliente(cuitEjemplo);
		assertEquals(cliente, clienteActual);
		
	}
	
	@Test
	public void queSePuedaAgregarUnVendedor() throws VendedorInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		tienda.agregarVendedor(vendedor);
		Vendedor vendedorActual = tienda.getVendedor(dniEjemplo);
		assertEquals(vendedor, vendedorActual);
		
	}
	
	@Test
	public void queSePuedaHacerUnaVentaDeUnProducto() throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException, YaExisteClienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		Vendible producto = new Producto("1", "Producto nuevo", 100d);
		Integer stockInicial = 10;
		tienda.agregarProducto((Producto) producto, stockInicial);
		Venta ticket = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(ticket);
		Integer cantidadVendida = 5;
		tienda.agregarProductoAVenta(ticket.getCodigo(), (Producto) producto, cantidadVendida);
		Integer stockEsperado = 5;
		Integer stockActual = tienda.getStock((Producto) producto);
		assertEquals(stockEsperado, stockActual);
		
	}
	
	
	@Test (expected = StockInsuficienteException.class)
	public void queNoSePuedaAgregarUnaVentaPorStockInsuficiente() throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException, YaExisteClienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		Producto producto = new Producto("1", "Producto nuevo", 100d);
		Integer stockInicial = 10;
		tienda.agregarProducto(producto, stockInicial);
		Venta ticket = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(ticket);
		Integer cantidadVendida = 15;
		tienda.agregarProductoAVenta(ticket.getCodigo(), producto, cantidadVendida);
		
	}
	
	@Test
	public void queSePuedaHacerUnaVentaDeUnServicio() throws VentaInexistenteException, VendibleInexistenteException, YaExisteClienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		Servicio servicio = new Servicio("1", "Servicio Técnico", 100d, "2023-02-01", "2023-03-01");
		Vendible producto = new Producto("3", "Producto nuevo", 100d);
		Integer stockInicial = 10;
		tienda.agregarProducto((Producto) producto, stockInicial);
		
		tienda.agregarServicio((Servicio) servicio);
		Venta venta = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(venta);
		tienda.agregarServicioAVenta(venta.getCodigo(), servicio);
		Double totalEsperado = 100d;
		Double totalActual = venta.getTotal();
		assertEquals(totalEsperado, totalActual);
		
	}
	
	@Test
	public void queSePuedaHacerUnaVentaDeUnProductosYServicios() throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException, YaExisteClienteException {
		
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		
		Venta venta = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(venta);
		Vendible vendible;
		
		vendible = new Servicio("1", "Servicio Técnico", 100d, "2023-02-01", "2023-03-01");
		tienda.agregarServicio((Servicio) vendible);
		tienda.agregarServicioAVenta(venta.getCodigo(), (Servicio) vendible);
		
		vendible = new Producto("2", "Producto nuevo", 350d);
		Integer stockInicial = 10;
		tienda.agregarProducto((Producto) vendible, stockInicial);
		Integer cantidadVendida = 2;
		tienda.agregarProductoAVenta(venta.getCodigo(), (Producto) vendible, cantidadVendida);
				
		Double totalEsperado = 800d;
		Double totalActual = venta.getTotal();
		assertEquals(totalEsperado, totalActual);
		
	}
	
	@Test
	public void queSePuedaEstablecerElPorcentajeDeComisionDeUnVendedor() {
		
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		tienda.agregarVendedor(vendedor);
		
		Integer comision = 10;
		tienda.establecerComisionVendedor(vendedor, comision);
		
		
		
		assertEquals(comision,tienda.conocerComisionVendedor(vendedor));
		
	}

	
	@Test
	public void queSeCalculeElMontoTotalDeComisionesQueTieneUnVendedor() throws YaExisteClienteException, StockInsuficienteException, VendedorInexistenteException {
		
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		tienda.agregarVendedor(vendedor);
		
		Integer comision = 10;
		tienda.establecerComisionVendedor(vendedor, comision);
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		
		Producto producto = new Producto("3", "Producto nuevo", 100d);
		Integer stockInicial = 10;
		tienda.agregarProducto((Producto) producto, stockInicial);
		Venta ventaRealizada = new Venta("0001",cliente,tienda.getVendedor(vendedor.getDni()));
		tienda.agregarVenta(ventaRealizada);
		
		tienda.agregarProductoAVenta("0001", producto, stockInicial);
		
		tienda.aplicarTotalComisionVendedor(vendedor);
		
		Double valorEsperado = 100d;
		
		assertEquals(valorEsperado,tienda.obtenerTotalComisionVendedor(vendedor));
	}
}
