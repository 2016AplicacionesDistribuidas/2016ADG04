--USE [distribucionPaquetes]
--GO

use ad2016_new
go


SET IDENTITY_INSERT Coordenada ON;  
go
INSERT INTO Coordenada (IdCoordenada, latitud, Longitud) VALUES(1,'34°32′59″S','58°22′55″O﻿')
INSERT INTO Coordenada (IdCoordenada, latitud, Longitud) VALUES(2,'36°35′49″S','48°22′55″O﻿')
INSERT INTO Coordenada (IdCoordenada, latitud, Longitud) VALUES(3,'33°35′59?S','58°22′55?O?﻿')
INSERT INTO Coordenada (IdCoordenada, latitud, Longitud) VALUES(4,'37°35′59?S','54°22′55?O?')
INSERT INTO Coordenada (IdCoordenada, latitud, Longitud) VALUES(5,'14°25′59?S','28°22′55?O?')
INSERT INTO Coordenada (IdCoordenada, latitud, Longitud) VALUES(6,'18°25′39?S','29°26′55?O?﻿')
go
SET IDENTITY_INSERT dbo.Coordenada OFF;  
GO  


SET IDENTITY_INSERT dbo.pais ON;  
GO  

INSERT INTO pais (IdPais,Descripcion) VALUES(1,'Argentina')


SET IDENTITY_INSERT dbo.Pais off;  
GO  


SET IDENTITY_INSERT dbo.provincia ON;  
GO  

INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(1,'Buenos Aires',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(2,'Mendoza',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(3,'Cordoba',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(4,'La Pampa',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(5,'Santa Fe',1)
INSERT INTO provincia (IdProvincia, Descripcion, IdPais) VALUES(6,'Capital Federal',1)

SET IDENTITY_INSERT dbo.provincia off;  
GO  


SET IDENTITY_INSERT dbo.direccion ON;  
GO  

INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(1,'Calle prueba a', 1231,'Capital Federal', 222, 1, 1)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(2,'Calle prueba b', 1231,'Rosario', 222, 1, 3)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(3,'Calle prueba c', 3466,'San Rafael', 222, 1, 2)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(4,'Calle prueba 4', 4444,'Lanus', 444, 1, 1)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(5,'Calle prueba 5', 5555,'Mar del Plata', 555, 1, 1)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(6,'Calle prueba 6', 6666,'Campana', 666, 1, 1)

INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(7,'Calle prueba 7', 7777,'Cordoba', 777, 1, 3)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(8,'Calle prueba 8', 8888,'Villa Gral Belgrano', 888, 1, 3)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(9,'Calle prueba 9', 9999,'Rio Cuarto', 999, 1, 3)

INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(10,'Calle prueba 10', 1010,'Mendoza', 101, 1, 2)INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(4,'Calle prueba 4', 4444,'Lanus', 444, 1, 1)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(5,'Calle prueba 5', 5555,'Mar del Plata', 555, 1, 1)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(6,'Calle prueba 6', 6666,'Campana', 666, 1, 1)

INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(7,'Calle prueba 7', 7777,'Cordoba', 777, 1, 3)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(8,'Calle prueba 8', 8888,'Villa Gral Belgrano', 888, 1, 3)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(9,'Calle prueba 9', 9999,'Rio Cuarto', 999, 1, 3)

INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(10,'Calle prueba 10', 1010,'Mendoza', 101, 1, 2)
INSERT INTO Direccion (IdDireccion, calle, codigoPostal, Localidad, nro, IdPais, IdProvincia) VALUES(11,'Calle prueba 11', 1111,'Capital Federal', 110, 1, 6)

update direccion set calle = 'Calle prueba ' + cast(IdDireccion as varchar)
update Direccion set Localidad='La Plata' where IdDireccion=1
update Direccion set IdProvincia=5 where IdDireccion=2

SET IDENTITY_INSERT dbo.direccion off;  
GO  


SET IDENTITY_INSERT dbo.sucursal  ON;  
GO  

INSERT INTO [dbo].[Sucursal] (IdSucursal, Descripcion, Telefono, Coordenada, IdDireccion) VALUES (1,'Sucursal A','23432423',1,1)
GO
INSERT INTO [dbo].[Sucursal] (IdSucursal, Descripcion, Telefono, Coordenada, IdDireccion) VALUES (2,'Sucursal B','1111111',2,2)
GO

SET IDENTITY_INSERT dbo.sucursal off;  
GO  


SET IDENTITY_INSERT dbo.cliente ON;  
GO  

INSERT INTO Cliente ([IdCliente],[TipoCliente],[Email],[Estado],[Telefono],[Cuit],[RazonSocial],[Apellido],[Dni],[Nombre],[IdDireccion],[IdCuentaCorriente]) 
VALUES(1,'p','email@email.com',1,'1231231','13123122','','Lopez','34242342', 'Pepe',1,null)

INSERT INTO Cliente ([IdCliente],[TipoCliente],[Email],[Estado],[Telefono],[Cuit],[RazonSocial],[Apellido],[Dni],[Nombre],[IdDireccion],[IdCuentaCorriente]) 
VALUES(2,'e','empresa2@empresa2.com',1,'22222222','22222222222','Empresa 2',null,null, null,2,null)

INSERT INTO Cliente ([IdCliente],[TipoCliente],[Email],[Estado],[Telefono],[Cuit],[RazonSocial],[Apellido],[Dni],[Nombre],[IdDireccion],[IdCuentaCorriente]) 
VALUES(3,'e','empresa3@empresa3.com',1,'33333333','22222222222','Empresa 3',null,null, null,3,null)

INSERT INTO Cliente ([IdCliente],[TipoCliente],[Email],[Estado],[Telefono],[Cuit],[RazonSocial],[Apellido],[Dni],[Nombre],[IdDireccion],[IdCuentaCorriente]) 
VALUES(4,'e','empresa4@empresa4.com',1,'44444444','22222222222','Empresa 4',null,null, null,4,null)

INSERT INTO Cliente ([IdCliente],[TipoCliente],[Email],[Estado],[Telefono],[Cuit],[RazonSocial],[Apellido],[Dni],[Nombre],[IdDireccion],[IdCuentaCorriente]) 
VALUES(5,'p','emailCliente5@cliente5.com',1,'55555555',null,null,null,'55555555', 3,5,null)

update Cliente set RazonSocial='Empresa'+ cast(idcliente as varchar), Apellido=null,Nombre=null, dni=null, 
email = 'emailEmpresa' + cast(idcliente as varchar) + '@empresa' + cast(idcliente as varchar)+'.com' where  TipoCliente='e'

update Cliente set Nombre='Nombre'+ cast(idcliente as varchar), Apellido='Apellido'+ cast(idcliente as varchar), cuit=null,RazonSocial=null,
email = 'emailCliente' + cast(idcliente as varchar) + '@cliente' + cast(idcliente as varchar)+'.com' where  TipoCliente='p'

update Cliente set IdDireccion = IdCliente

SET IDENTITY_INSERT dbo.cliente off;  
GO  


SET IDENTITY_INSERT dbo.producto ON;  
GO  
INSERT INTO Producto ([IdProducto],[Categoria],[CodigoProducto],[Descripcion],[Unidad],[IdCliente]) VALUES(1,'categoria A',2332,'Producto A','u',1)

SET IDENTITY_INSERT dbo.producto  off;  
GO  


SET IDENTITY_INSERT dbo.PlanMantenimiento ON;  
GO  

INSERT INTO PlanMantenimiento (IdPlanMantenimiento, Comentarios, Descripcion) VALUES(1,'Plan A','plan mantenimiento A')
INSERT INTO PlanMantenimiento (IdPlanMantenimiento, Comentarios, Descripcion) VALUES(2,'Plan B','plan mantenimiento B')

SET IDENTITY_INSERT dbo.PlanMantenimiento off;  
GO  


SET IDENTITY_INSERT dbo.tareaMantenimiento ON;  
GO  

INSERT INTO tareaMantenimiento (IdTareaMantenimiento, tipo, tarea, CantidadKilometros, CantidadDias, IdPlanMantenimiento) VALUES(1,'k','cambiar ruedas',1000,null,1)
INSERT INTO tareaMantenimiento (IdTareaMantenimiento, tipo, tarea, CantidadKilometros, CantidadDias, IdPlanMantenimiento) VALUES(2,'t','revisar frenos',null,30,1)
INSERT INTO tareaMantenimiento (IdTareaMantenimiento, tipo, tarea, CantidadKilometros, CantidadDias, IdPlanMantenimiento) VALUES(3,'k','cambiar ruedas',2000,null,2)
INSERT INTO tareaMantenimiento (IdTareaMantenimiento, tipo, tarea, CantidadKilometros, CantidadDias, IdPlanMantenimiento) VALUES(4,'t','revisar frenos',null,60,2)

SET IDENTITY_INSERT dbo.tareaMantenimiento off;  
GO  


SET IDENTITY_INSERT dbo.vehiculo on;  
GO  

INSERT INTO Vehiculo ([IdVehiculo],[FechaIngreso],[Alto],[Ancho],[Anio],[CondicionTransporte],[Estado],[KmRecorridos],[Largo],[Marca],[Modelo],[Patente],[Peso],[Refrigerado],[Tara],[Volumen],[IdPlanMantenimiento],[idSucursal]) VALUES(1,'2010-01-01', 100, 200, 300, '', null, 1000, 1000, 'Mercedes Benz', 'Camion1', 'AAA0001', 2934, 0, 2334, 3234, 1, 1)
INSERT INTO Vehiculo ([IdVehiculo],[FechaIngreso],[Alto],[Ancho],[Anio],[CondicionTransporte],[Estado],[KmRecorridos],[Largo],[Marca],[Modelo],[Patente],[Peso],[Refrigerado],[Tara],[Volumen],[IdPlanMantenimiento],[idSucursal]) VALUES(2,'2010-01-01', 200, 400, 600, '', null, 1550, 1200, 'Mercedes Benz', 'Camion2', 'AAA0002', 2955, 0, 2334, 3234, 1, 1)
INSERT INTO Vehiculo ([IdVehiculo],[FechaIngreso],[Alto],[Ancho],[Anio],[CondicionTransporte],[Estado],[KmRecorridos],[Largo],[Marca],[Modelo],[Patente],[Peso],[Refrigerado],[Tara],[Volumen],[IdPlanMantenimiento],[idSucursal]) VALUES(3,'2010-01-01', 300, 600, 400, '', null, 1340, 1040, 'Mercedes Benz', 'Camion3', 'AAA0003', 3434, 0, 2334, 3234, 2, 2)
INSERT INTO Vehiculo ([IdVehiculo],[FechaIngreso],[Alto],[Ancho],[Anio],[CondicionTransporte],[Estado],[KmRecorridos],[Largo],[Marca],[Modelo],[Patente],[Peso],[Refrigerado],[Tara],[Volumen],[IdPlanMantenimiento],[idSucursal]) VALUES(4,'2010-01-01', 400, 400, 200, '', null, 1020, 1230, 'Mercedes Benz', 'Camion4', 'AAA0004', 2934, 0, 2334, 3234, 2, 2)


SET IDENTITY_INSERT dbo.vehiculo off;  
GO  


SET IDENTITY_INSERT dbo.proveedor on;  
GO  
--vane
INSERT INTO Proveedor (IdProveedor, Activo, Cuit, Email, RazonSocial, Telefono, IdDireccion) VALUES(1,1,'23434343','mail@mail.com','Proveedor A','234343',1)
INSERT INTO Proveedor (IdProveedor, Activo, Cuit, Email, RazonSocial, Telefono, IdDireccion) VALUES(2,1,'12323223','mailB@mail.com','Proveedor B','234343',2)

SET IDENTITY_INSERT dbo.proveedor off;  
GO  


INSERT INTO TallerMecanico VALUES(234,'oficial',1)
INSERT INTO TallerMecanico VALUES(2124,'lubricentro',2)
go

SET IDENTITY_INSERT dbo.TareaMantenimientoRealizada on;  
GO  

INSERT INTO TareaMantenimientoRealizada (IdTareaMantenimientoRealizada, CantidadKilometros, FechaRealizada, IdProveedor, IdTareaMantenimiento, IdVehiculo) VALUES(1,1000,GETDATE(),1,1,1)
INSERT INTO TareaMantenimientoRealizada (IdTareaMantenimientoRealizada, CantidadKilometros, FechaRealizada, IdProveedor, IdTareaMantenimiento, IdVehiculo)  VALUES(2,null,GETDATE(),1,2,1)
INSERT INTO TareaMantenimientoRealizada  (IdTareaMantenimientoRealizada, CantidadKilometros, FechaRealizada, IdProveedor, IdTareaMantenimiento, IdVehiculo) VALUES(3,1500,GETDATE(),2,3,2)
INSERT INTO TareaMantenimientoRealizada  (IdTareaMantenimientoRealizada, CantidadKilometros, FechaRealizada, IdProveedor, IdTareaMantenimiento, IdVehiculo) VALUES(4,1000,GETDATE(),1,3,3)
INSERT INTO TareaMantenimientoRealizada  (IdTareaMantenimientoRealizada, CantidadKilometros, FechaRealizada, IdProveedor, IdTareaMantenimiento, IdVehiculo) VALUES(5,null,GETDATE(),1,4,3)

SET IDENTITY_INSERT dbo.TareaMantenimientoRealizada off;  
GO  

SET IDENTITY_INSERT dbo.proveedor on;  
GO  
--vane
INSERT INTO Proveedor (IdProveedor, Activo, Cuit, Email, RazonSocial, Telefono, IdDireccion)  VALUES(3,1,'111111','seguro@mail.com','Seguro','234343',1)

SET IDENTITY_INSERT dbo.proveedor off;  
GO  

INSERT INTO Seguro VALUES('Seguro aloja',23422,432,'Todo riesgo',3)
GO  

SET IDENTITY_INSERT dbo.Proveedor on;  
GO  
INSERT INTO Proveedor (IdProveedor, Activo, Cuit, Email, RazonSocial, Telefono, IdDireccion)  VALUES(4,1,'22222','ss@mail.com','Servicio Seguridad','234343',2)

SET IDENTITY_INSERT dbo.proveedor off;  
GO  


INSERT INTO ServicioSeguridad VALUES('SS aloja',432,4)
go

SET IDENTITY_INSERT dbo.MapaDeRuta on;  
GO  

INSERT INTO MapaDeRuta (IdMapaDeRuta, CantKm, costo, Duracion, IdSucursalDestino, IdSucursalOrigen) VALUES(1,1000,48,100,2,1)

SET IDENTITY_INSERT dbo.MapaDeRuta off;  
GO  

insert into MapaDeRutaCoordenada VALUES(1,3)
insert into MapaDeRutaCoordenada VALUES(1,4)
insert into MapaDeRutaCoordenada VALUES(1,5)
insert into MapaDeRutaCoordenada VALUES(1,6)
