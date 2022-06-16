create database ProyectoBase4;
use ProyectoBase4;

create table categoria(
	idCategoria int not null primary key auto_increment,
    nombreCategoria varchar(50) not null,
    descripcionCategoria varchar(150) not null
);

delimiter **
create procedure spInsertar(nom varchar(50), descrip varchar(150))
begin
	insert into categoria(nombreCategoria, descripcionCategoria) values(nom, descrip);
end **
delimiter ;

delimiter **
create procedure spActualizar(id int, nom varchar(50), descrip varchar(50))
begin
	update categoria set nombreCategoria=nom, descripcionCategoria=descrip where idCategoria=id;
end **
delimiter ;

delimiter **
create procedure spEliminar(id int)
begin 
	delete from categoria where idCategoria = id;
end **
delimiter ;

delimiter **
create procedure spSeleccionarUno(id int)
begin
	select * from categoria where idCategoria = id;
end **
delimiter ; 

delimiter **
create procedure spSeleccionarTodo()
begin 
	select * from categoria;
end **
delimiter ;

