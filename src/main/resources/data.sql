-- Usuario ACTIVO
INSERT INTO Usuarios (nombre, rol, email, contraseña, estado)
VALUES ('Carlos', 'Trabajador', 'carlitos@gmail.com', 'carlitosxd', 'ACTIVO');

-- Usuario INACTIVO
INSERT INTO Usuarios (nombre, rol, email, contraseña, estado)
VALUES ('Lucía', 'Trabajador', 'lucia@gmail.com', 'luciapass', 'INACTIVO');

-- Usuario ELIMINADO (para probar restaurar)
INSERT INTO Usuarios (nombre, rol, email, contraseña, estado)
VALUES ('Andrés', 'Dueño', 'andres@gmail.com', 'andres123', 'ELIMINADO');

-- Otro ACTIVO (Dueño)
INSERT INTO Usuarios (nombre, rol, email, contraseña, estado)
VALUES ('Rosa', 'Dueño', 'rosa@gmail.com', 'rosita456', 'ACTIVO');