package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Producto p) {
    this.entityManager.persist(p);		
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Producto p1=this.seleccionarPorId(id);
		this.entityManager.remove(p1);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Producto p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto seleccionarPorCodigo(String codigo) {
		TypedQuery<Producto> query =this.entityManager.createQuery("Select p from Producto p Where p.codigoBarras=:DatoCodigo",Producto.class);
		query.setParameter("DatoCodigo", codigo);
		Producto p=query.getSingleResult();
		if (p.equals(null)) {
			return null;
		}else {
			return p;
		}
		
	}
}
