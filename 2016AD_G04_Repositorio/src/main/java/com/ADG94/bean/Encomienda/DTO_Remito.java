package com.ADG94.bean.Encomienda;

import java.io.Serializable;
import java.util.Date;


public class DTO_Remito implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date fecha;
	private boolean conformado;
	private String recibidoPor;
	private Integer idEncomienda;
	
	public DTO_Remito(){
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isConformado() {
		return conformado;
	}

	public void setConformado(boolean conformado) {
		this.conformado = conformado;
	}

	public String getRecibidoPor() {
		return recibidoPor;
	}

	public void setRecibidoPor(String recibidoPor) {
		this.recibidoPor = recibidoPor;
	}

	public Integer getIdEncomienda() {
		return idEncomienda;
	}

	public void setIdEncomienda(Integer idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

}