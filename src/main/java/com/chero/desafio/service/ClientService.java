package com.chero.desafio.service;

import com.chero.desafio.bean.Client;
import com.chero.desafio.dto.KpiClient;

public interface ClientService extends BaseService<Client>{
	int promedioEdadClientes();
	double desviacionEstandar();
	KpiClient obtenerKpi();
}
