package com.chero.desafio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chero.desafio.bean.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Long>{
	
}
