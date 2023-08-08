package com.example.demo.repository;

import com.example.demo.repository.modelo.Producto;

public interface IProductoRepository {
	public void insertar(Producto p);
	public void eliminar (Integer id);
	public Producto seleccionarPorId(Integer id);
	public void actualizar(Producto p);
	public Producto seleccionarPorCodigo(String codigo);
}
