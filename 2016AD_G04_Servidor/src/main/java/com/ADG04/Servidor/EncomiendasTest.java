package com.ADG04.Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.List;

import com.ADG04.Negocio.GestionControlViajes;
import com.ADG04.Negocio.GestionEncomienda;
import com.ADG04.Servidor.dao.*;
import com.ADG04.Servidor.model.Coordenada;
import com.ADG04.Servidor.model.Encomienda;
import com.ADG04.Servidor.model.Envio;
import com.ADG04.Servidor.rmi.DistribucionPaquetesRMI;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;

public class EncomiendasTest {

	public static void TestCrearEncomiendaYAsignaleElEnvio() throws IOException{

		AltaEncomiendaParticular();
		String ok = getStringFromConsole("Agregar otra encomienda (si/no)?");
		
		while(ok.equals("si")){
			AltaEncomiendaParticular();
			ok = getStringFromConsole("Agregar otra encomienda (si/no)?");
		}

		System.out.println("----------------------------------------------");
		int idSucursal = getIntFromConsole("Buscar encomiendas pendientes. Ingrese id sucursal:  ");
	
		//busco encomiendas pendientes y las asigno a envios

    	List<Encomienda> es = EncomiendaDao.getInstancia().getEncomiendasPendientesBySucursal(idSucursal);
    	for(Encomienda e:es){
    		System.out.println(e.getIdEncomienda());
    	}
    	
    	int idEncomienda = getIntFromConsole("Ingrese Id encomienda para asignar envio: ");
		asignarEnvios(idSucursal, idEncomienda);
		ok = getStringFromConsole("Asignar envío a otra encomienda (si/no)?");
    	while(ok.equals("si")){
    		idEncomienda = getIntFromConsole("Ingrese Id encomienda para asignar envio: ");
    		asignarEnvios(idSucursal, idEncomienda);
    		ok = getStringFromConsole("Asignar envío a otra encomienda (si/no)?");
    	}
    	System.out.println("----------------------------------------------");
		//ponerEnViajeEncomiendasPorVencer();
		//Armar los envios
		/*
		testControlViajes();
		
		System.out.println("Para finalizar escriba Exit, si no escriba Continuar.");
		
		while(getStringFromConsole("") != "Continuar"){
			
			AltaEncomiendaParticular();
			testControlViajes();
		}*/
		
		return;
		
	}
	

	private static void asignarEnvios(int idSucursal, int idEncomienda) throws RemoteException {

		DistribucionPaquetesRMI bDelegate = new DistribucionPaquetesRMI();
		
		System.out.println("----------Encomienda: "+idEncomienda+"--------------------------------");
		Integer idenvio = bDelegate.gestionarEnvioEncomienda(idEncomienda);			
		if(idenvio == null){
			System.out.println("----------La encomienda no se pudo asignar a un envío--------------------------------");
		}
		else
		{
			System.out.println("----------La encomienda saldrá por el envío: "+ idenvio + "--------------------------------");
			System.out.println("Info del envío: ");
			DTO_EnvioPropio envio = bDelegate.getInfoEnvioPropio(idenvio);
			System.out.println("Id envio: "+envio.getId());
			System.out.println("Fecha y  hora de llegada: "+ envio.getFechaYHoraLlegada());
			System.out.println("Vehiculo: "+envio.getIdVehiculo());
			System.out.println("Estado envío: "+envio.getEstado());
			
			System.out.println(envio.toString());
		}
		
		
	}


	private static String getStringFromConsole(String msg) throws IOException{
		System.out.print(msg);
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		String line = buffer.readLine();
		return line;
	}
	
	private static float getFloatFromConsole(String msg) throws IOException{
		System.out.print(msg);
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		float line = Float.parseFloat(buffer.readLine());
		return line;
	}
	
	private static int getIntFromConsole(String msg) throws IOException{
		System.out.print(msg);
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		int line = Integer.parseInt(buffer.readLine());
		return line;
	}
	
	private static void ponerEnViajeEncomiendasPorVencer(){
		
		GestionEncomienda.getInstancia().ponerEnViajeEncomiendasPorVencer();
				
	}
	
	private static void asignarEnvios() throws IOException{

		
		DistribucionPaquetesRMI bDelegate = new DistribucionPaquetesRMI();
		
		int idEncomienda = getIntFromConsole("Id encomienda: ");
		
		System.out.println("----------Encomienda: "+idEncomienda+"--------------------------------");
		Integer idenvio = bDelegate.gestionarEnvioEncomienda(idEncomienda);			
		if(idenvio == null){
			System.out.println("----------La encomienda no se pudo asignar a un envío--------------------------------");
		}
		else
		{
			System.out.println("----------La encomienda saldrá por el envío: "+ idenvio + "--------------------------------");
			System.out.println("Info del envío: ");
			DTO_EnvioPropio envio = bDelegate.getInfoEnvioPropio(idenvio);
			System.out.println("Id envio: "+envio.getId());
			System.out.println("Fecha y  hora de llegada: "+ envio.getFechaYHoraLlegada());
			System.out.println("Vehiculo: "+envio.getIdVehiculo());
			System.out.println("Estado envío: "+envio.getEstado());
			
			System.out.println(envio.toString());
		}
		
		System.out.println();
				
		System.out.print("Test finished...");

	}
	
	private static void AltaEncomiendaParticular() throws IOException {

			String dniCliente = getStringFromConsole("dni cliente particular: ");
			
			int idSucOrigen = getIntFromConsole("Sucursal origen: ");
			int idSucDestino = getIntFromConsole("Sucursal destino: ");
			float largo = getFloatFromConsole("Largo: ");
			float ancho = getFloatFromConsole("Ancho: ");
			float alto = getFloatFromConsole("Alto: ");
			float peso = getFloatFromConsole("Peso: ");
			float volumen = getFloatFromConsole("Volumen: ");
			
			//(1,2,1,100,100f,430f,100f,0f,0);

			DistribucionPaquetesRMI bDelegate = new DistribucionPaquetesRMI();
			System.out.println("Nueva encomienda particular");
			int idEncomienda = bDelegate.nuevaEncomiedaParticular(dniCliente, 1, 2, idSucOrigen, idSucDestino, largo, ancho, alto, peso, volumen, 
					"", false, (short) 0, false, "", "", "", "", "", "", 0f, "");
				
		
	}
	
	
	public static void testControlViajes() throws IOException{	

		DistribucionPaquetesRMI business = new DistribucionPaquetesRMI();
		
		int idEncomienda = getIntFromConsole("Id encomienda: ");
		int idEnvio = getIntFromConsole("Id envio: ");
		
		//Intento asignarla a un envío.
		//System.out.println("-------Asignar la encomienda "+idEncomienda+" a un envío------------");
		//Integer idEnvio = GestionEncomienda.getInstancia().asignarEnvio(idEncomienda, null);
		DTO_EnvioPropio envio =  business.getInfoEnvioPropio(idEnvio);
		System.out.println("Estado Inicial del Envio: "+envio.getEstado()+". Envío " + idEnvio);
		
		/*Seguira en viaje*/
		System.out.println("---------Seguira en viaje----------");
		System.out.println("Estado del envio cuando sigue en curso");
		DTO_Coordenada c = new DTO_Coordenada();
		int idcoord = getIntFromConsole("Id Coordenadas: ");
		c.setId(idcoord);
		business.modificarCoordenadas(idEnvio, c);
		//GestionControlViajes.getInstancia().actualizarEstadoVehiculo(envio.getIdEnvio(), CoordenadaDao.getInstancia().getById(3));
		Envio env = EnvioDao.getInstancia().getById(idEnvio);
		System.out.println(env.getEstado());
		System.out.println("----------------------------------------");
		
		/*Se indicara desviado*/
		/*System.out.println("------------------------ Se crea una nueva coordenada para las pruebas ---------------------------------------");
		Coordenada coordAct = new Coordenada();
		coordAct.setLatitud("54°35′59″S");
		coordAct.setLongitud("48°22′55″O﻿");
		Coordenada coord = CoordenadaDao.getInstancia().saveOrUpdate(coordAct);
		System.out.println("---------Nueva coordenada: "+coord.getIdCoordenada()+"-------------------");
		
		*/
		System.out.println("-----------------------------------------");
		System.out.println("Estado del envio cuando se pasan coordenadas fuera de su mapa de ruta:");
		idcoord = getIntFromConsole("Id Coordenadas: ");
		c.setId(idcoord);
		business.modificarCoordenadas(idEnvio, c); 		//GestionControlViajes.getInstancia().actualizarEstadoVehiculo(envio.getId(), coord);
		
		System.out.println(envio.getEstado());	
		System.out.println("-------------------");
				
		System.out.println("");
		
		/*Se indicara demorado*/
		System.out.println("-------Se indicara demorado------------");
		System.out.println("Estado del envio cuando se chequea la fecha de llegada y la actual:");
		
		business.marcarEnvioDemorado(idEnvio);

		System.out.println("Envio llegando tarde: "+envio.getEstado());	
		
		System.out.println("");
		System.out.println("-------------------------------------");
		
/*
		EnvioDao.getInstancia().remove(envio);
		EnvioDao.getInstancia().remove(envio2);
		EncomiendaDao.getInstancia().remove(enc);
		EncomiendaDao.getInstancia().remove(enc2);
*/
	}

	private static void testMarcarEnvio(){
		
	}
}
