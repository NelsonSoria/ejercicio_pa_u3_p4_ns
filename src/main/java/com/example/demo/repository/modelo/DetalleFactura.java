package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name= "detalle_factura")
public class DetalleFactura {
	@GeneratedValue(generator = "seq_detalle_factura",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_detalle_factura",sequenceName ="seq_detalle_factura",allocationSize = 1 )
	@Id
	@Column(name= "fade_id")
	private Integer id;
	
	@Column(name= "fade_cantidad")
	private Integer cantidad;
	
	@Column(name= "fade_precio_unitario")
	private BigDecimal precioUnitario;
	
	@Column(name= "fade_sub_total")
	private BigDecimal subTotal;
	
	@ManyToOne
	@JoinColumn(name= "fade_fact_id")
	private Factura factura;
	
	@ManyToOne
	@JoinColumn(name= "fade_prod_id")
	private Producto producto;

	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getCantidad() {
		return cantidad;
	}



	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}



	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}



	public BigDecimal getSubTotal() {
		return subTotal;
	}



	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}



	public Factura getFactura() {
		return factura;
	}



	public void setFactura(Factura factura) {
		this.factura = factura;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ ", subTotal=" + subTotal + ", factura=" + factura + ", producto=" + producto + "]";
	}
	
	

}
