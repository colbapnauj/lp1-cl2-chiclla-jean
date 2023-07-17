CREATE DATABASE tienda_virtual

tienda_virtualtienda_virtual

CREATE TABLE Clientes (
	id_cliente INT AUTO_INCREMENT PRIMARY KEY,
	nombres_apellidos VARCHAR(100) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(70) NOT NULL
);

CREATE TABLE Productos (
	id_producto INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	precio DECIMAL(10, 2) NOT NULL,
	url_foto VARCHAR(255)
);

CREATE TABLE Calificaciones_Productos (
	id_calificacion INT AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT,
	id_producto INT,
	calificacion TINYINT,
	tipo_texto TINYINT,
	texto VARCHAR(250),
	fecha_calificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente),
	FOREIGN KEY (id_producto) REFERENCES Productos(id_producto),
	CONSTRAINT unq_cliente_producto UNIQUE (id_cliente, id_producto)
);

INSERT INTO clientes (nombres_apellidos, email, PASSWORD) VALUES
	('Cliente 1', 'cliente1@example.com', 'contrasena1'),
	('Cliente 2', 'cliente2@example.com', 'contrasena2'),
   ('Cliente 3', 'cliente3@example.com', 'contrasena3'),
   ('Cliente 4', 'cliente4@example.com', 'contrasena4'),
   ('Cliente 5', 'cliente5@example.com', 'contrasena5'),
   ('Cliente 6', 'cliente6@example.com', 'contrasena6'),
   ('Cliente 7', 'cliente7@example.com', 'contrasena7'),
   ('Cliente 8', 'cliente8@example.com', 'contrasena8'),
	('Cliente 9', 'cliente9@example.com', 'contrasena9');
	
INSERT INTO Clientes (nombres_apellidos, email, password) VALUES
  ('Cliente 10', 'cliente10@example.com', 'contrasena10'),
  ('Cliente 11', 'cliente11@example.com', 'contrasena11'),
  ('Cliente 12', 'cliente12@example.com', 'contrasena12'),
  ('Cliente 13', 'cliente13@example.com', 'contrasena13'),
  ('Cliente 14', 'cliente14@example.com', 'contrasena14'),
  ('Cliente 15', 'cliente15@example.com', 'contrasena15'),
  ('Cliente 16', 'cliente16@example.com', 'contrasena16'),
  ('Cliente 17', 'cliente17@example.com', 'contrasena17'),
  ('Cliente 18', 'cliente18@example.com', 'contrasena18'),
  ('Cliente 19', 'cliente19@example.com', 'contrasena19');
	
INSERT INTO Productos (id_producto, nombre, precio, url_foto) VALUES
  (1, 'SmartHomeHub', 199, 'https://example.com/smart-home-hub.jpg'),
  (2, 'DroneXplorer', 499, 'https://example.com/drone-xplorer.jpg'),
  (3, 'VR Pro-Goggles', 299, 'https://example.com/vr-pro-goggles.jpg'),
  (4, 'PhoneGuard Pro', 39, 'https://example.com/phone-guard-pro.jpg'),
  (5, 'FitTrack Plus', 129, 'https://example.com/fit-track-plus.jpg');
  
INSERT INTO Productos (id_producto, nombre, precio, url_foto) VALUES
	(6, 'FitTrack Plus', 149, 'https://example.com/fit-track-plus.jpg');
  
INSERT INTO Calificaciones_Productos (id_calificacion, id_cliente, id_producto, calificacion, tipo_texto, texto) VALUES
  (1, 1, 1, 5, 1, '¡Me encanta este SmartHomeHub! Es muy fácil de usar.'),
  (2, 2, 2, 1, 1, 'El DroneXplorer es genial para capturar imágenes aéreas.'),
  (3, 3, 3, 1, 2, 'Tengo algunas sugerencias para mejorar los VR Pro-Goggles.'),
  (4, 4, 4, 3, 1, 'El PhoneGuard Pro es una excelente protección para mi teléfono.'),
  (5, 5, 5, 4, 1, 'FitTrack Plus me ayuda a mantenerme en forma y monitorear mi progreso.');
  
INSERT INTO Calificaciones_Productos (id_cliente, id_producto, tipo_texto, texto, calificacion)
VALUES
  (10, 1, 1, 'Excelente producto, lo recomiendo', 5),
  (11, 1, 1, 'Buena calidad, fácil de usar', 4),
  (12, 2, 1, 'Gran drone para capturar imágenes aéreas', 5),
  (10, 3, 2, 'Me gustaría tener más opciones de ajustes', 3),
  (13, 4, 1, 'Ofrece una buena protección para mi teléfono', 4),
  (14, 5, 1, 'Me ayuda a mantenerme en forma, muy útil', 4),
  (15, 5, 1, 'Buena relación calidad-precio', 4),
  (16, 5, 1, 'Gran seguimiento de la actividad física', 5),
  (11, 5, 1, 'Fácil de usar, lo recomiendo', 4),clientesclientes
  (10, 5, 1, 'Buen producto, cumple con mis expectativas', 4);
  
SELECT * FROM clientes

SELECT * FROM productos

SELECT cp.id_calificacion, p.nombre AS nombre_producto, c.nombres_apellidos AS nombre_cliente, cp.calificacion, cp.tipo_texto, cp.texto, cp.fecha_calificacion
FROM calificaciones_Productos cp
JOIN productos p ON cp.id_producto = p.id_producto
JOIN clientes c ON cp.id_cliente = c.id_cliente;

-- sp
DELIMITER //
CREATE PROCEDURE AgregarCalificacion(
	IN cliente_id INT,
	IN producto_id INT,
	IN calificacion TINYINT,
	IN tipo_texto TINYINT,
	IN comentario VARCHAR(250)
)
BEGIN
	INSERT INTO calificaciones_productos (id_cliente, id_producto, calificacion, tipo_texto, texto)
	VALUES (cliente_id, producto_id, calificacion, tipo_texto, comentario);
END //
DELIMITER ;

CALL AgregarCalificacion(1, 2, 1, 1, 'comentario de prueba');

ALTER TABLE calificaciones_productos
DROP calificacion

ALTER TABLE calificaciones_productos
ADD calificacion TINYINT UNSIGNED NOT NULL CHECK (calificacion >=1 AND calificacion <=5) AFTER id_producto;


SELECT p.id_producto, p.nombre, p.precio, p.url_foto, AVG(cp.calificacion) AS promedio_rating, COUNT(cp.id_calificacion) AS cantidad_calificaciones
FROM productos p
LEFT JOIN calificaciones_productos cp ON p.id_producto = cp.id_producto
GROUP BY p.id_producto, p.nombre;

SELECT p.id_producto, p.nombre, p.precio, p.url_foto, AVG(cp.calificacion) AS promedio_rating, COUNT(cp.id_calificacion) AS cantidad_calificaciones
FROM productos p
LEFT JOIN calificaciones_productos cp ON p.id_producto = cp.id_producto
WHERE p.id_producto = 1
GROUP BY p.id_producto, p.nombre;

DELIMITER //
CREATE PROCEDURE ObtenerProductosYCalificacion()
BEGIN
	SELECT p.id_producto, p.nombre, p.precio, p.url_foto, AVG(cp.calificacion) AS promedio_rating, COUNT(cp.id_calificacion) AS cantidad_calificaciones
	FROM productos p
	LEFT JOIN calificaciones_productos cp ON p.id_producto = cp.id_producto
	GROUP BY p.id_producto, p.nombre;
END //
DELIMITER ;

CALL ObtenerProductosYCalificacion();

DELIMITER //
CREATE PROCEDURE ObtenerProductoYPromedioCalificaion(IN producto_id TINYINT)
BEGIN
	SELECT p.id_producto, p.nombre, p.precio, p.url_foto, AVG(cp.calificacion) AS promedio_rating, COUNT(cp.id_calificacion) AS cantidad_calificaciones
	FROM productos p
	LEFT JOIN calificaciones_productos cp ON p.id_producto = cp.id_producto
	WHERE p.id_producto = producto_id
	GROUP BY p.id_producto, p.nombre;
END //
DELIMITER ;

CALL ObtenerProductoYPromedioCalificaion(6);

SELECT cp.id_calificacion, cp.id_cliente, cp.id_producto, cp.calificacion, cp.tipo_texto, cp.texto, c.nombres_apellidos AS nombre_cliente, cp.fecha_calificacion
FROM Calificaciones_Productos cp
JOIN Clientes c ON cp.id_cliente = c.id_cliente
WHERE cp.id_producto = 2;

DELIMITER //
CREATE PROCEDURE ObtenerCalificacionesPorProductoId(IN producto_id TINYINT)
BEGIN
	SELECT cp.id_calificacion, cp.id_cliente, cp.id_producto, cp.calificacion, cp.tipo_texto, cp.texto, c.nombres_apellidos AS nombre_cliente, cp.fecha_calificacion
	FROM Calificaciones_Productos cp
	JOIN Clientes c ON cp.id_cliente = c.id_cliente
	WHERE cp.id_producto = producto_id;
END //
DELIMITER ;

CALL ObtenerCalificacionesPorProductoId(2)


