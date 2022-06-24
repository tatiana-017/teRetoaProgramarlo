USE reto4;
DROP table usuario;
CREATE TABLE usuario(
	alias 			varchar(200) primary key,
    nombre_usua		varchar(200) not null,
    apellido_usua	varchar(200) not null,
    email_usua		varchar(500) not null,
    celular 		bigint not null,
    contrasenia 	varchar(500) not null,
    fecha_usua		date not null 
);
INSERT INTO usuario (alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua) 
values ('lucky', 'Pedro', 'Perez', 'pedro@gmail.com', 3114872345, '1234p', '1990-05-17');
INSERT INTO usuario (alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua) 
values ('malopez', 'Maria', 'Lopez', 'maria@gmail.com', 3114872321, '1234m', '1995-12-4');
INSERT INTO usuario (alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua)
values ('diva', 'Ana', 'Diaz', 'ana@gmail.com', 3124872345,'1234a', '2000-09-26');
INSERT INTO usuario (alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua) 
values ('dreamer', 'Luis', 'Rojas', 'luis@gmail.com',3104872356, '1234l', '1998-06-20');
INSERT INTO usuario (alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua)
values ('ninja', 'Andres', 'Cruz', 'andres@gmail.com',3114232345, '1234b', '2001-07-14');
INSERT INTO usuario (alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua) 
values ('neon', 'Nelson', 'Ruiz', 'nelson@gmail.com', 3004872345,'1234n', '1993-04-30');
INSERT INTO usuario (alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua) 
values ('rose', 'Claudia', 'Mendez', 'claudia@gmail.com', 3112342345, '1234c', '1998-03-12');
INSERT INTO usuario (alias, nombre_usua, apellido_usua, email_usua, celular, contrasenia, fecha_usua)
values ('green', 'Jorge', 'Rodriguez', 'jorge@gmail.com', 3014872345,'1234j', '1999-05-10');