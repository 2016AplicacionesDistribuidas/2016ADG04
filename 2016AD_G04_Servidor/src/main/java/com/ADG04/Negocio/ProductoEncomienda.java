package com.ADG04.Negocio;

import com.ADG04.Servidor.dao.ProductoDao;
import com.ADG04.Servidor.model.ProductoEncomiendaE;
import com.ADG04.bean.Encomienda.DTO_ProductoEncomienda;

public class ProductoEncomienda{

	private int idProductoEncomienda;
	private int idEncomienda;
	private Producto producto;
	private Integer cantidad;
	
	public ProductoEncomienda() {
	}

	public ProductoEncomienda(int idEncomienda,Producto producto) {
		this.idEncomienda = idEncomienda;
		this.producto = producto;
	}

	
	public ProductoEncomienda(Producto producto) {
		this.producto =producto;
	}

	public ProductoEncomienda(Producto producto, Integer cantidad) {
		this.producto =producto;
		this.cantidad = cantidad;
	}

	public int getIdProductoEncomienda() {
		return this.idProductoEncomienda;
	}

	public void setIdProductoEncomienda(int idProductoEncomienda) {
		this.idProductoEncomienda = idProductoEncomienda;
	}


	public int getIdEncomienda() {
		return idEncomienda;
	}

	public void setIdEncomienda(int idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public DTO_ProductoEncomienda toDTO() {
		
		DTO_ProductoEncomienda p = new DTO_ProductoEncomienda();
		p.setCantidad(this.cantidad);
		p.setIdEncomienda(this.getIdEncomienda());
		p.setIdProductoCliente(this.producto.getIdProducto());
		p.setDescProducto(this.getProducto().getDescripcion());
		
		return p;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public ProductoEncomienda fromEntity(ProductoEncomiendaE pe) {
		ProductoEncomienda prod = new ProductoEncomienda();
		
		Producto p= new Producto().fromEntity(pe.getProducto());
		
		prod.setCantidad((int) pe.getCantidad());
		prod.setIdProductoEncomienda(pe.getIdProductoEncomienda());
		prod.setIdEncomienda(pe.getEncomienda().getIdEncomienda());
		prod.setProducto(p);
		return prod;
	}

}
