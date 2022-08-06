/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Javier
 * Created: 15-07-2021
 */

CREATE DATABASE fastdevelopment;

CREATE TABLE categoria (
    cod_cate INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20)NOT NULL
);
    
CREATE TABLE editorial (
    cod_edi INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30)NOT NULL
);

CREATE TABLE idioma (
    cod_idioma INT PRIMARY KEY AUTO_INCREMENT,
    lengua VARCHAR(10) NOT NULL
);

INSERT INTO `categoria` (`cod_cate`, `nombre`) VALUES 
(NULL, 'Drama'),(NULL, 'Novela'), (NULL, 'Terror');

INSERT INTO `editorial` (`cod_edi`, `nombre` ) VALUES
(NULL, 'Editorial Cuneta'), (NULL, 'Editorial Hueders'), (NULL, 'Edicola Ediciones');

INSERT INTO `idioma` (`cod_idioma`, `lengua`) VALUES
(NULL, 'Español'), (NULL, 'Alemán'), (NULL, 'Portugués'), (NULL, 'Inglés');