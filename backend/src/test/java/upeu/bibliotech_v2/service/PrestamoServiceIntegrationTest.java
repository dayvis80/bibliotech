package upeu.bibliotech_v2.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PrestamoServiceIntegrationTest {

    @Autowired
    private PrestamoService prestamoService;

    @Test
    void debeAutorizarPrestamoConDatosReales() {

        // ARRANGE
        Long estudianteId = 1L;
        Long libroId = 1L;

        // ACT
        boolean resultado =
                prestamoService.puedePrestar(estudianteId, libroId);

        // ASSERT
        assertTrue(resultado);
    }

    @Test
    void debeLanzarExcepcionSiEstudianteNoExiste() {

        // ARRANGE
        Long estudianteId = 999L;
        Long libroId = 1L;

        // ACT + ASSERT
        RuntimeException excepcion =
                assertThrows(
                        RuntimeException.class,
                        () -> prestamoService
                                .puedePrestar(estudianteId, libroId)
                );

        assertEquals(
                "Estudiante no existe",
                excepcion.getMessage()
        );
    }

}
