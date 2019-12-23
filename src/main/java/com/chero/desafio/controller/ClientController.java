package com.chero.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chero.desafio.bean.Client;
import com.chero.desafio.model.response.ResponseClient;
import com.chero.desafio.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "desafioController")
public class ClientController {
	@Autowired
	private ClientService service;
	
	@PostMapping("/creacliente")
	@ApiOperation(value = "crear cliente", notes = "Operación para crear un cliente")
	public ResponseEntity<Object> crearCliente(@Valid @RequestBody final Client cliente){
		HttpStatus statusHttp = HttpStatus.ACCEPTED;
		ResponseClient response = new ResponseClient();
		try {
			service.insert(cliente);
			statusHttp = HttpStatus.OK;
			response = new ResponseClient(statusHttp.value(), "Cliente creado correctamente.");
		}catch(Exception ex) {
			statusHttp = HttpStatus.CREATED;
			response = new ResponseClient(statusHttp.value(),"Ocurrio un error al crear el cliente.");
		}
		return ResponseEntity.status(statusHttp).body(response);
	}
	
	@GetMapping("/kpideclientes")
	@ApiOperation(value = "KPI de Clientes", notes = "Listado de indicadores KPI de clientes")
	public ResponseEntity<Object> kpideclientes(){
		return ResponseEntity.ok().body(service.obtenerKpi());
	}
		
	@GetMapping("/listclientes")
	@ApiOperation(value = "Listar clientes", notes = "Listado de clientes")
	public ResponseEntity<Object> listarCliente(){
		return ResponseEntity.ok().body(service.listAll());
	}
}
