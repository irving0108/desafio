package com.chero.desafio.dto;

import java.io.Serializable;

public class KpiClient implements Serializable{

	private static final long serialVersionUID = 1L;
	private double promedioEdad;
	private double desviacionEstandar;
		
	public KpiClient() {
		super();
	}
	public double getPromedioEdad() {
		return promedioEdad;
	}
	public void setPromedioEdad(double promedioEdad) {
		this.promedioEdad = promedioEdad;
	}
	public double getDesviacionEstandar() {
		return desviacionEstandar;
	}
	public void setDesviacionEstandar(double desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}
	
	@Override
	public String toString() {
		return "KpiClient [promedioEdad=" + promedioEdad + ", desviacionEstandar=" + desviacionEstandar + "]";
	}	
}
