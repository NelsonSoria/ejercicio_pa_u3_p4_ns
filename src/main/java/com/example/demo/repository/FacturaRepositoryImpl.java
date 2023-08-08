package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Factura f) {
		this.entityManager.persist(f);
		
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		Factura f= this.seleccionarPorId(id);
		this.entityManager.remove(f);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Factura f) {
		this.entityManager.merge(f);
		
	}

}
