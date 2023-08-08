package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.IFacturaService;
import com.example.demo.service.IProductoService;

@SpringBootApplication
public class EjercicioPaU3P4NsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU3P4NsApplication.class, args);
	}
	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IFacturaService facturaService;
	

	@Override
	public void run(String... args) throws Exception {
		
		Producto p1= new Producto();
		p1.setCodigoBarras("CO01");
		p1.setNombre("CocaCola");
		p1.setCategoria("Bevidas");
		p1.setStock(20);
		p1.setPrecio(new BigDecimal(3.50));
		
		this.iProductoService.guardar(p1);
		
		Producto p2= new Producto();
		p2.setCodigoBarras("CO01");
		p2.setNombre("CocaCola");
		p2.setCategoria("Bevidas");
		p2.setStock(20);
		p2.setPrecio(new BigDecimal(3.50));
		
		this.iProductoService.guardar(p1);
		
		List<Producto> p22= new ArrayList<>();
		
		
		this.facturaService.generarFactura(null, null);
		
		
	}

}
