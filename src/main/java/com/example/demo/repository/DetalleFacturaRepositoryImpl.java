package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.DetalleFactura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DetalleFacturaRepositoryImpl implements IDetalleFacturaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(DetalleFactura detalleFactura) {
		this.entityManager.persist(detalleFactura);
		
	}

}
