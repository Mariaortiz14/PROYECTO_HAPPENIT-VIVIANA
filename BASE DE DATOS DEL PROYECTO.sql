CREATE DATABASE gestion_eventos;
USE gestion_eventos;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL, -- La contraseña se almacenará cifrada
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE evento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha DATE NOT NULL,
    id_usuario INT, -- El usuario que creó el evento
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE calendario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_evento INT, -- El evento relacionado con esta entrada de calendario
    fecha DATE NOT NULL,
    descripcion TEXT,
    FOREIGN KEY (id_evento) REFERENCES evento(id)
);

CREATE TABLE comentario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_evento INT, -- El evento sobre el cual se está haciendo el comentario
    id_usuario INT, -- El usuario que hizo el comentario
    contenido TEXT NOT NULL,
    fecha_comentario TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_evento) REFERENCES evento(id),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE notificacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT, -- El usuario que recibe la notificación
    id_evento INT, -- El evento asociado a la notificación
    mensaje TEXT NOT NULL,
    fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    leido BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_evento) REFERENCES evento(id)
);

CREATE TABLE pago (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT, -- El usuario que realiza el pago
    id_evento INT, -- El evento para el cual se realiza el pago
    monto DECIMAL(10, 2) NOT NULL,
    fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_evento) REFERENCES evento(id)
);

CREATE TABLE venta_entrada (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT, -- El usuario que compra la entrada
    id_evento INT, -- El evento para el cual se vende la entrada
    cantidad INT NOT NULL,
    total DECIMAL(10, 2) NOT NULL, -- Total pagado
    fecha_venta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_evento) REFERENCES evento(id)
);

show tables;