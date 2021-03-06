package com.ADG04.Vista.Listados;
import java.util.List;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_ItemFactura;
import com.ADG04.bean.Encomienda.DTO_Encomienda;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ListadoFacturasClientes extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoVehiculos;
	private JTable jTableListado;
	private JTextField txtBusqueda;

	public  ListadoFacturasClientes() {
		super();
		initGUI();
	}
	
	public JLabel getJLabelTitulo(){
		return this.jLabelTitulo;
	}
	
	
	
	public JLabel getjLabelTitulo() {
		return jLabelTitulo;
	}

	public void setjLabelTitulo(JLabel jLabelTitulo) {
		this.jLabelTitulo = jLabelTitulo;
	}

	public JScrollPane getjScrollPaneListadoVehiculos() {
		return jScrollPaneListadoVehiculos;
	}

	public void setjScrollPaneListadoVehiculos(
			JScrollPane jScrollPaneListadoVehiculos) {
		this.jScrollPaneListadoVehiculos = jScrollPaneListadoVehiculos;
	}

	public JTable getjTableListado() {
		return jTableListado;
	}

	public void setjTableListado(JTable jTableListado) {
		this.jTableListado = jTableListado;
	}

	public JTextField getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(JTextField txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}

	private void initGUI() {
		try {

			final DefaultTableModel jTableListadoModel = new DefaultTableModel();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Listado Facturas Clientes");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 400, 36);
			}

			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Buscar:");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,12));
				jLabelTitulo.setBounds(12, 42, 245, 35);
				txtBusqueda = new JTextField();
				txtBusqueda.setBounds(80, 48, 324, 20);
				getContentPane().add(txtBusqueda);
				txtBusqueda.setColumns(10);
				JButton buscar = new JButton("Buscar");
				buscar.setBounds(440, 45, 89, 23);
				JLabel info = new JLabel();
				getContentPane().add(info);
				info.setText("Ingrese DNI del Cliente. Vacio indica todos");
				info.setFont(new java.awt.Font("Verdana",1,8));
				info.setBounds(80, 60, 500, 23);
				
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						List<DTO_Factura> listaDTO = null;
						if(txtBusqueda.getText()!=null){
							listaDTO = Controlador.getInstancia().buscarFacturasByDniCliente(txtBusqueda.getText());
							int j = jTableListadoModel.getRowCount();
							if(jTableListadoModel.getRowCount()>0){
								for(int i=0;i<j;i++){
									jTableListadoModel.removeRow(0);
								}
							}
						}
						else{
							listaDTO = Controlador.getInstancia().listarFacturasCliente();
						}
						
						if(listaDTO!=null){
							for (DTO_Factura item :listaDTO){
								String pagado ="";
								
								if (item.isPagado())
									pagado = "Pagado";
								else
									pagado ="Pendiente";
								
								float total=0f;
								for(DTO_ItemFactura it:item.getItems()){
									total += it.getValor();
								}
								
								String dni = "";
								DTO_Encomienda enc = Controlador.getInstancia().getEncomiendaParticular(item.getIdEncomienda());
								if(enc==null)
									enc = Controlador.getInstancia().getEncomiendaEmpresa(item.getIdEncomienda());
								if(enc!=null){
									int idCliente = enc.getCliente().getId();
									dni = Controlador.getInstancia().getClienteById(idCliente).getDni();
								}
								jTableListadoModel.addRow(new Object[] { item.getId(), dni,
																			item.getTipo(),
																			item.getFecha().toString(),
																			Float.toString(total),
																			pagado																			
								});
							}										
							}	
						jTableListadoModel.fireTableDataChanged();
					}
					
				});
				
				getContentPane().add(buscar);
			}
			{
				jScrollPaneListadoVehiculos = new JScrollPane();
				getContentPane().add(jScrollPaneListadoVehiculos);
				jScrollPaneListadoVehiculos.setBounds(12, 83, 799, 305);
				{
					
					List<DTO_Factura> listaDTO = Controlador.getInstancia().listarFacturasCliente();
					
			
					jTableListadoModel.addColumn("Numero");
					jTableListadoModel.addColumn("Cliente");
					jTableListadoModel.addColumn("Tipo");
					jTableListadoModel.addColumn("Fecha");
					jTableListadoModel.addColumn("Total");
					jTableListadoModel.addColumn("Pago");
	
					
					if(listaDTO!=null){
					for (DTO_Factura item :listaDTO){
						String pagado ="";
						
						if (item.isPagado())
							pagado = "Pagado";
						else
							pagado ="Pendiente";
						
						float total=0f;
						for(DTO_ItemFactura it:item.getItems()){
							total += it.getValor();
						}

						String dni = "";
						DTO_Encomienda enc = Controlador.getInstancia().getEncomiendaParticular(item.getIdEncomienda());
						if(enc==null)
							enc = Controlador.getInstancia().getEncomiendaEmpresa(item.getIdEncomienda());
						if(enc!=null){
							int idCliente = enc.getCliente().getId();
							//dni = Controlador.getInstancia().getClienteById(idCliente).getDni();
						}
						
						jTableListadoModel.addRow(new Object[] { item.getId(),
																	enc.getCliente().getId(),
																	item.getTipo(),
																	item.getFecha().toString(),
																	Float.toString(total),
																	pagado																			
						});
																
					}	
						
					}
					jTableListado = new JTable(jTableListadoModel);
					jScrollPaneListadoVehiculos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoVehiculos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoVehiculos.setViewportView(jTableListado);
					jTableListado.setModel(jTableListadoModel);
				}
			}
			pack();
			this.setSize(839, 415);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
