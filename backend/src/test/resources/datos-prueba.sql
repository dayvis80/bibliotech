-- Datos de prueba para BiblioTech CI

INSERT INTO estudiantes (id, nombre, estado)
VALUES (1, 'Juan Perez', 'ACTIVO');

INSERT INTO libros (id, titulo, autor, ejemplares_disponibles)
VALUES (1, 'Programacion Java', 'Deitel', 3);

INSERT INTO prestamos
    (id, estado, fecha_prestamo, estudiante_id, libro_id)
VALUES
    (1, 'ACTIVO', '2026-09-17', 1, 1),
    (12, 'ACTIVO', '2026-09-24', 1, 1);