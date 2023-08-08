package com.example.demo.repository;

import com.example.demo.repository.modelo.Factura;

public interface IFacturaRepository {
	
	public void insertar(Factura f);
	public void eliminar (Integer id);
	public Factura seleccionarPorId(Integer id);
	public void actualizar(Factura f);

}
