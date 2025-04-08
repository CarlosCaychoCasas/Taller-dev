CREATE TABLE Proveedores (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nombre_proveedor NVARCHAR(100) NOT NULL,
    direccion NVARCHAR(255),
    telefono NVARCHAR(100),
    email NVARCHAR(225)
);

