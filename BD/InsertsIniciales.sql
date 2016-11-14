USE AD2016
ALTER COLUMN unidad varchar(255)
SET IDENTITY_INSERT dbo.Rol ON

Insert into Rol (IdRol,Descripcion) VALUES(1,'ADMINISTRACION')

SET IDENTITY_INSERT dbo.Rol off;  

/*usuario administrador*/
SET IDENTITY_INSERT dbo.[Usuario] on;  
INSERT INTO [dbo].[Usuario]  (IdUsuario, Apellido, dni, fechaCreacion, Nombre, Password, UltimoAcceso, usuario, IdSucursal) 

SET IDENTITY_INSERT dbo.[Usuario] off;  

/*UsuarioRol*/
INSERT INTO pais (IdPais,Descripcion) VALUES(1,'Argentina')
INSERT INTO pais (IdPais,Descripcion) VALUES(5,'China')
INSERT INTO pais (IdPais,Descripcion) VALUES(6,'Peru')
INSERT INTO pais (IdPais,Descripcion) VALUES(7,'Mexico')
INSERT INTO pais (IdPais,Descripcion) VALUES(8,'USA')
INSERT INTO pais (IdPais,Descripcion) VALUES(9,'Inglaterra')
INSERT INTO pais (IdPais,Descripcion) VALUES(10,'Italia')
INSERT INTO pais (IdPais,Descripcion) VALUES(11,'Alemania')
INSERT INTO pais (IdPais,Descripcion) VALUES(12,'Japon')

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
