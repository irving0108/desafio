package com.chero.desafio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chero.desafio.bean.Client;
import com.chero.desafio.dao.ClientDao;
import com.chero.desafio.dto.KpiClient;
import com.chero.desafio.service.ClientService;

@Service("clientService")
public class ClientServiceImpl implements ClientService{
	@Autowired
	private ClientDao clientDAO;

	@Override
	public void insert(Client t) {
		// TODO Auto-generated method stub
		clientDAO.save(t);
	}

	@Override
	public void update(Client t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Client> listAll() {
		// TODO Auto-generated method stub
		return clientDAO.findAll();
	}

	@Override
	public int promedioEdadClientes() {
		int sumaEdades = 0;
		List<Client> listaClientes = clientDAO.findAll();
		for (Client client : listaClientes) {
			sumaEdades = sumaEdades + client.getEdad();
		}
		return sumaEdades/listaClientes.size();
	}

	@Override
	public double desviacionEstandar() {
		int sumatoriaDesviaciones = 0;
		int promedio = this.promedioEdadClientes();
		List<Client> listaClientes = clientDAO.findAll();
		for (Client client : listaClientes) {
			int desviacion = Math.abs(client.getEdad() - promedio);
			int desviacionCuadrado = (int) Math.pow((double)desviacion,2);
			sumatoriaDesviaciones = sumatoriaDesviaciones + desviacionCuadrado;
		}
		Double sumatoriaCantidadDatos = (double) (sumatoriaDesviaciones/listaClientes.size());
		return Math.pow(sumatoriaCantidadDatos, 0.5);
	}

	@Override
	public KpiClient obtenerKpi() {
		KpiClient kpiClientes = new KpiClient();
		kpiClientes.setPromedioEdad(this.promedioEdadClientes());
		kpiClientes.setDesviacionEstandar(this.desviacionEstandar());
		return kpiClientes;
	}
}