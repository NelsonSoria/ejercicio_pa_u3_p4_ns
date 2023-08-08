package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IDetalleFacturaRepository;
import com.example.demo.repository.IFacturaRepository;
import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.DetalleFactura;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;


@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	IProductoRepository iProductoRepository;
	
	@Autowired
	IFacturaRepository facturaRepository;
	
	@Autowired
	IDetalleFacturaRepository detalleFacturaRepository;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void generarFactura(List<Producto> p, String cedula) {
	
	
		
		for(Producto p1: p) {
			Producto prod= this.iProductoRepository.seleccionarPorCodigo(p1.getCodigoBarras());
			Factura fac= new Factura();
			DetalleFactura detalle= new DetalleFactura();
			
			if(prod.getCantidad().compareTo(prod.getStock())>=0) {
				detalle.setCantidad(prod.getCantidad());
				detalle.setPrecioUnitario(prod.getPrecio());
				BigDecimal cantidad= new BigDecimal(prod.getCantidad());
				detalle.setSubTotal(cantidad.multiply(prod.getPrecio()));
				detalle.setProducto(prod);
				
				BigDecimal total= cantidad.multiply(prod.getPrecio());
				
				fac.setFecha(LocalDateTime.now());
				fac.setCedulaCliente(cedula);
				fac.setTotalFactura(total);
				
				detalle.setFactura(fac);
				
				this.detalleFacturaRepository.insertar(detalle);
				this.facturaRepository.insertar(fac);
			}else {
				throw new RuntimeException();
				
			}
			
			
			

		}
		
	}

}
