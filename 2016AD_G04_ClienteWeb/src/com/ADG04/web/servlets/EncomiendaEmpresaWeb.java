package com.ADG04.web.servlets;

public class EncomiendaEmpresaWeb {

	private Integer idEncomienda;
	private Integer idCliente;
	private Boolean envioAsignado;
	private String estado;
		
	public EncomiendaEmpresaWeb(Integer idEncomienda, Integer idCliente, String estado,
			Boolean envioAsignado) {
		super();
		this.idEncomienda = idEncomienda;
		this.idCliente = idCliente;
		this.estado = estado;
		this.envioAsignado = envioAsignado;
	}
	public EncomiendaEmpresaWeb() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdEncomienda() {
		return idEncomienda;
	}
	public void setIdEncomienda(Integer idEncomienda) {
		this.idEncomienda = idEncomienda;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Boolean getEnvioAsignado() {
		return envioAsignado;
	}
	public void setEnvioAsignado(Boolean envioAsignado) {
		this.envioAsignado = envioAsignado;
	}
	
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String toString() {
        return "{\"idEncomienda\":\"" + idEncomienda.toString() 
        		+ "\", \"idCliente\":\"" + idCliente.toString() 
        		+ "\", \"estado\":\"" + this.getEstado()
        		+ "\", \"envioAsignado\":\"" + this.tieneEnvio() 
        		+ "\", \"verEncomienda\":\"" + "<a href=ServletVerEncomiendasParticular?action=getEncomiendaEmpresa&idEncomienda="+idEncomienda.toString()+">Ver Encomienda</a>" + "\"}";
    }
	
	private String tieneEnvio(){
		if(envioAsignado)
			return "Si";
		else
			return "No";
	}
}
