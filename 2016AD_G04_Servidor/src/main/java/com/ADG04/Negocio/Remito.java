package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;















import javax.persistence.MapsId;










import com.ADG04.Servidor.dao.ProductoDao;
import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.model.ItemRemitoE;
import com.ADG04.Servidor.model.RemitoE;
import com.ADG04.bean.Encomienda.DTO_ItemRemito;
import com.ADG04.bean.Encomienda.DTO_Remito;


public class Remito{
 
	private int idRemito;
	private String nombreReceptor;
	private String apellidoReceptor;
	private String dniReceptor;
	private boolean conformado;
	private Date fechaConformado;
	private Date fechaEstimadaEntrega;
	private String condicionTransporte;
	private String indicacionesManipulacion;
	private Encomienda encomienda;		
	private List<ItemRemito> itemsRemito = new ArrayList<ItemRemito>();
		
	public Remito() {
	}

	public Remito(String nombreReceptor,
			String apellidoReceptor, String dniReceptor, boolean conformado,
			Date fechaConformado) {
		this.nombreReceptor = nombreReceptor;
		this.apellidoReceptor = apellidoReceptor;
		this.dniReceptor = dniReceptor;
		this.conformado = conformado;
		this.fechaConformado = fechaConformado;
	}

	
	
	public Remito(String nombreReceptor, String apellidoReceptor,
			String dniReceptor, boolean conformado, Date fechaConformado,
			Date fechaEstimadaEntrega, String condicionTransporte,
			String indicacionesManipulacion) {
		super();
		this.nombreReceptor = nombreReceptor;
		this.apellidoReceptor = apellidoReceptor;
		this.dniReceptor = dniReceptor;
		this.conformado = conformado;
		this.fechaConformado = fechaConformado;
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
		this.condicionTransporte = condicionTransporte;
		this.indicacionesManipulacion = indicacionesManipulacion;
	}

	
	
	public int getIdRemito() {
		return this.idRemito;
	}

	public void setIdRemito(int idRemito) {
		this.idRemito = idRemito;
	}


	public Encomienda getEncomienda() {
		return this.encomienda;
	}

	public void setEncomienda(Encomienda encomienda) {
		this.encomienda = encomienda;
	}

	public String getNombreReceptor() {
		return this.nombreReceptor;
	}

	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}

	public String getApellidoReceptor() {
		return this.apellidoReceptor;
	}

	public void setApellidoReceptor(String apellidoReceptor) {
		this.apellidoReceptor = apellidoReceptor;
	}

	public String getDniReceptor() {
		return this.dniReceptor;
	}

	public void setDniReceptor(String dniReceptor) {
		this.dniReceptor = dniReceptor;
	}

	public boolean isConformado() {
		return this.conformado;
	}

	public void setConformado(boolean conformado) {
		this.conformado = conformado;
	}

	

	
	public Date getFechaConformado() {
		return fechaConformado;
	}

	public void setFechaConformado(Date fechaConformado) {
		this.fechaConformado = fechaConformado;
	}

	public List<ItemRemito> getItemsRemito() {
		return itemsRemito;
	}

	public void setItemsRemito(List<ItemRemito> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}
	
	

	public Date getFechaEstimadaEntrega() {
		return fechaEstimadaEntrega;
	}

	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}

	public String getCondicionTransporte() {
		return condicionTransporte;
	}

	public void setCondicionTransporte(String condicionTransporte) {
		this.condicionTransporte = condicionTransporte;
	}

	public String getIndicacionesManipulacion() {
		return indicacionesManipulacion;
	}

	public void setIndicacionesManipulacion(String indicacionesManipulacion) {
		this.indicacionesManipulacion = indicacionesManipulacion;
	}
	
	

	public DTO_Remito toDTO(){
		DTO_Remito r = new DTO_Remito();
    	r.setConformado(this.conformado);
		r.setFecha(this.fechaConformado);
		r.setId(this.idRemito);
		r.setApellidoReceptor(apellidoReceptor);
		r.setDniReceptor(dniReceptor);
		r.setNombreReceptor(nombreReceptor);
		r.setCondicionTransporte(condicionTransporte);
		r.setFechaEstimadaEntrega(fechaEstimadaEntrega);
		r.setIndicacionesManipulacion(indicacionesManipulacion);
		
		if(this.getEncomienda()!=null)
			r.setIdEncomienda(this.getEncomienda().getIdEncomienda());
    	
    	List<DTO_ItemRemito> list = new ArrayList<DTO_ItemRemito>();
    	for(ItemRemito item : this.itemsRemito){
    		list.add(item.toDTO());
    	}    	
    	r.setDetalle(list);
    	
    	return r;
    }

	public Remito fromEntity(RemitoE r) {
		if(r!=null){
			Remito remito = new Remito();
			remito.setApellidoReceptor(r.getApellidoReceptor());
			remito.setCondicionTransporte(r.getCondicionTransporte());
			remito.setDniReceptor(r.getDniReceptor());
			remito.setFechaConformado(r.getFechaConformado());
			remito.setFechaEstimadaEntrega(r.getFechaEstimadaEntrega());
			remito.setConformado(r.isConformado());
			remito.setIdRemito(r.getIdRemito());
			remito.setIndicacionesManipulacion(r.getIndicacionesManipulacion());
			remito.setNombreReceptor(r.getNombreReceptor());
			
			if(r.getEncomienda()!=null){
				Encomienda e = new Encomienda();
				e.setIdEncomienda(r.getEncomienda().getIdEncomienda());
				
				remito.setEncomienda(e);
			}
			
			List<ItemRemito> list = new ArrayList<ItemRemito>();
	    	for(ItemRemitoE item : r.getItemsRemito()){
	    		ItemRemito itm = new ItemRemito().fromEntity(item);
	    		list.add(itm);
	    	}    	
	    	remito.setItemsRemito(list);
	    	return remito;
    	}
		else
			return null;
	}

	public void addItem(ItemRemito itemRemito) {
		this.itemsRemito.add(itemRemito);
	}

	public RemitoE toEntity() {
		RemitoE remito = new RemitoE();
		remito.setApellidoReceptor(this.apellidoReceptor);
		remito.setCondicionTransporte(condicionTransporte);
		remito.setConformado(true);
		remito.setDniReceptor(dniReceptor);
		remito.setFechaConformado(fechaConformado);
		remito.setFechaEstimadaEntrega(fechaEstimadaEntrega);
		remito.setIndicacionesManipulacion(indicacionesManipulacion);
		remito.setNombreReceptor(nombreReceptor);
		
		
		EncomiendaE e = new EncomiendaE();
		e.setIdEncomienda(this.getEncomienda().getIdEncomienda()); //ver!
		remito.setEncomienda(e);
		
		List<ItemRemitoE> items = new ArrayList<ItemRemitoE>();
		for(ItemRemito ir : this.getItemsRemito()){
			ItemRemitoE itr = new ItemRemitoE();
			itr.setCantidad(ir.getCantidad());
			itr.setDescripcion(ir.getDescripcion());
			itr.setProducto(ProductoDao.getInstancia().getById(ir.getProducto().getIdProducto()));
			items.add(itr);
		}
		remito.setItemsRemito(items);
		return remito;
	}
	

}
