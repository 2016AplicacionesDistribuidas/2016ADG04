package com.ADG04.bean.Administracion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class DTO_Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int idUsuario;
	private String nombreUsuario;
	private String password;
	private Date ultimoAcceso;
	private Date fechaCreacion;
	private int idRolUsuario;  
	private int idSucursal;
	private String nombre;
	private String apellido;
	private String dni;
	private String usuario;
	
	public DTO_Usuario() {
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String usuario) {
		this.nombreUsuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public int getIdRolUsuario() {
		return this.idRolUsuario;
	}

	public void setIdRolUsuario(int idRol) {
		this.idRolUsuario = idRol;
	}

	public Integer getId() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;	
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}

}
