package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public void guardar(Producto p) {
		Producto prodEncontrado = this.iProductoRepository.seleccionarPorCodigo(p.getCodigoBarras());
		System.out.println("nuevo");
		if(prodEncontrado.equals(null)) {
			Integer nuevoStock= prodEncontrado.getStock() + p.getStock();
			p.setStock(nuevoStock);
			this.iProductoRepository.actualizar(prodEncontrado);
			
		}else {
			this.iProductoRepository.insertar(p);
		}
		
		this.iProductoRepository.insertar(p);
		
	}

}
