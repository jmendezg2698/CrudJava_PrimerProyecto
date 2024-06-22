USE PRUEBA

CREATE TABLE Personas (
    Id int Identity,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Edad INT,
    Direccion VARCHAR(100),
    Telefono VARCHAR(15)
);

drop table Personas

INSERT INTO Personas (Nombre, Apellido, Edad, Direccion, Telefono)
VALUES
    ('Juan', 'Perez', 25, 'Calle A 123', '555-123-4567'),
    ('María', 'Gomez', 30, 'Avenida B 456', '555-987-6543'),
    ('Luis', 'Martinez', 22, 'Calle C 789', '555-567-8901'),
    ('Ana', 'Ramirez', 28, 'Avenida D 567', '555-234-7890'),
    ('Pedro', 'Sánchez', 35, 'Calle E 901', '555-678-1234'),
    ('Laura', 'Lopez', 29, 'Avenida F 234', '555-890-5678'),
    ('Carlos', 'Rodriguez', 26, 'Calle G 345', '555-456-2345'),
    ('Sofia', 'Fernandez', 31, 'Avenida H 678', '555-123-8901'),
    ('Javier', 'Gonzalez', 27, 'Calle I 456', '555-789-5678'),
    ('Elena', 'Diaz', 33, 'Avenida J 123', '555-234-9012');

SELECT Id, Nombre, Apellido, Edad, Direccion, Telefono FROM Personas 


CREATE TABLE Proveedor(
Id int Identity,
NombreProveedores VARCHAR(50) NOT NULL,
NitProveedor VARCHAR(50) NOT NULL,
Telefono VARCHAR(8) NOT NULL,
Direccion VARCHAR(MAX) NOT NULL,
Estado VARCHAR(15) NOT NULL
)


INSERT INTO Proveedor (NombreProveedores, NitProveedor, Telefono, Direccion, Estado)
VALUES ('Banco Azteca', '12345-678-9', '12345678', '123 Calle Principal, Ciudad1', 'Activo'),
('MultiServicios S.A', '98765-432-1', '98765432', '456 Avenida Secundaria, Ciudad2', 'Inactivo'),
('Cargo Expres', '54321-678-9', '54321678', '789 Calle Secundaria, Ciudad3', 'Activo'),
('Productos Diana', '12345-987-6', '12345987', '321 Avenida Principal, Ciudad4', 'Activo'),
('Rentokil', '98765-123-4', '98765123', '654 Calle Secundaria, Ciudad5', 'Inactivo'),
('OffiMarket', '54321-987-6', '54321987', '987 Avenida Principal, Ciudad6', 'Activo'),
('Evolution-Tec', '12345-678-1', '12345678', '123 Calle Principal, Ciudad7', 'Inactivo'),
('Cofino Stahl', '98765-432-5', '98765432', '456 Avenida Secundaria, Ciudad8', 'Activo'),
('Amazon', '54321-678-2', '54321678', '789 Calle Secundaria, Ciudad9', 'Inactivo'),
('Banco Industrial', '12345-987-3', '12345987', '321 Avenida Principal, Ciudad10', 'Activo')

select * from Proveedor

CREATE TABLE Productos (
    Id int IDENTITY(1, 1) PRIMARY KEY,
    NombreProducto VARCHAR(100) NOT NULL,
    Descripcion VARCHAR(MAX) NOT NULL,
    Precio DECIMAL(10, 2) NOT NULL,
    Stock INT NOT NULL,
    Categoria VARCHAR(50) NOT NULL
);

-- Insert 1
INSERT INTO Productos (NombreProducto, Descripcion, Precio, Stock, Categoria)
VALUES ('Laptop HP Pavilion', 'Laptop HP con procesador Intel Core i7, 16 GB de RAM, 512 GB de SSD.', 999.99, 50, 'Laptops'),
('PC de Escritorio Dell', 'PC de escritorio Dell con procesador AMD Ryzen 5, 8 GB de RAM, 1 TB de HDD.', 799.99, 30, 'Computadoras de Escritorio'),
('Monitor Acer 24 Pulgadas', 'Monitor Acer de 24 pulgadas con resolución Full HD.', 149.99, 100, 'Monitores'),
('Teclado Mecánico RGB', 'Teclado mecánico con retroiluminación RGB y switches Cherry MX.', 89.99, 60, 'Periféricos'),
('Ratón Inalámbrico Logitech', 'Ratón inalámbrico de alta precisión con botones programables.', 39.99, 75, 'Periféricos'),
('Impresora Epson EcoTank', 'Impresora de inyección de tinta con sistema EcoTank de tanques de tinta recargables.', 249.99, 40, 'Impresoras'),
('Disco Duro Externo WD 2TB', 'Disco duro externo Western Digital de 2 TB de capacidad.', 79.99, 90, 'Almacenamiento'),
('Memoria RAM Corsair 16 GB', 'Módulo de memoria RAM Corsair DDR4 de 16 GB.', 79.99, 120, 'Componentes de PC'),
('Router Inalámbrico TP-Link', 'Router inalámbrico de alta velocidad con banda dual.', 49.99, 65, 'Redes'),
('Webcam Logitech HD', 'Cámara web Logitech HD con calidad de video 1080p.', 59.99, 55, 'Periféricos')

SELECT * FROM Productos

CREATE TABLE Empleados (
    Id int IDENTITY(1, 1) PRIMARY KEY,
    NombreCompleto VARCHAR(100) NOT NULL,
    Direccion VARCHAR(MAX),
    FechaNacimiento DATE,
    FechaContratacion DATE,
    Salario DECIMAL(10, 2),
    Departamento VARCHAR(50) NOT NULL
);

-- Insert 1
INSERT INTO Empleados (NombreCompleto, Direccion, FechaNacimiento, FechaContratacion, Salario, Departamento)
VALUES ('Juan Pérez', '123 Calle Principal, Ciudad1', '1990-05-15', '2022-03-10', 45000.00, 'Ventas'),
('María García', '456 Avenida Secundaria, Ciudad2', '1988-08-20', '2021-06-05', 52000.00, 'Recursos Humanos'),
('Carlos Rodríguez', '789 Calle Secundaria, Ciudad3', '1992-03-30', '2020-11-15', 48000.00, 'Contabilidad'),
('Luisa Martínez', '321 Avenida Principal, Ciudad4', '1985-11-10', '2019-08-02', 55000.00, 'Tecnología'),
('Pedro López', '654 Calle Secundaria, Ciudad5', '1993-07-25', '2020-01-20', 49000.00, 'Ventas'),
('Ana Sánchez', '987 Avenida Principal, Ciudad6', '1991-01-05', '2021-10-12', 53000.00, 'Recursos Humanos'),
('Manuel Torres', '123 Calle Principal, Ciudad7', '1994-09-18', '2018-12-08', 58000.00, 'Contabilidad'),
('Laura Gómez', '456 Avenida Secundaria, Ciudad8', '1987-06-12', '2021-04-25', 51000.00, 'Tecnología'),
('Javier Ríos', '789 Calle Secundaria, Ciudad9', '1990-04-01', '2019-02-14', 56000.00, 'Ventas'),
('Sofía Díaz', '321 Avenida Principal, Ciudad10', '1986-12-28', '2020-07-30', 54000.00, 'Recursos Humanos')

select * from Empleados

CREATE TABLE Ventas (
    Id int IDENTITY(1, 1) PRIMARY KEY,
    FechaVenta DATETIME NOT NULL,
    IdEmpleado int NOT NULL,
    IdProducto int NOT NULL,
    CantidadVendida INT NOT NULL,
    PrecioUnitario DECIMAL(10, 2) NOT NULL,
    TotalVenta DECIMAL(10, 2) NOT NULL
);

-- Insert 1
INSERT INTO Ventas (FechaVenta, IdEmpleado, IdProducto, CantidadVendida, PrecioUnitario, TotalVenta)
VALUES ('2023-11-08 10:00:00', 1, 3, 5, 49.99, 249.95),
('2023-11-08 11:30:00', 2, 1, 3, 29.99, 89.97),
('2023-11-08 12:45:00', 3, 2, 2, 149.99, 299.98),
('2023-11-08 14:15:00', 4, 4, 4, 19.99, 79.96),
('2023-11-08 15:30:00', 5, 5, 1, 39.99, 39.99),
('2023-11-08 16:45:00', 6, 7, 3, 89.99, 269.97),
('2023-11-08 18:00:00', 7, 8, 2, 79.99, 159.98),
('2023-11-08 19:30:00', 8, 10, 6, 9.99, 59.94),
('2023-11-08 20:45:00', 9, 6, 2, 34.99, 69.98),
('2023-11-08 22:00:00', 10, 9, 1, 54.99, 54.99)

select * from ventas
