
-- DATOS INICIALES DE BIBLIOTECH V2

-- Estudiantes
INSERT INTO estudiantes (id, nombre, estado)
VALUES
    (1, 'Juan Perez', 'ACTIVO'),
    (2, 'Maria Quispe', 'ACTIVO'),
    (3, 'Carlos Mamani', 'SUSPENDIDO')
ON CONFLICT (id) DO NOTHING;

-- Libros
INSERT INTO libros (id, titulo, autor, ejemplares_disponibles)
VALUES
    (1, 'Programacion en Java', 'James Gosling', 5),
    (2, 'Desarrollo Web con Angular', 'Equipo Angular', 3),
    (3, 'Bases de Datos', 'Autor de prueba', 0)
ON CONFLICT (id) DO NOTHING;

-- Ajustar las secuencias de los IDs
SELECT setval(
    pg_get_serial_sequence('estudiantes', 'id'),
    COALESCE((SELECT MAX(id) FROM estudiantes), 1),
    true
);

SELECT setval(
    pg_get_serial_sequence('libros', 'id'),
    COALESCE((SELECT MAX(id) FROM libros), 1),
    true
);
