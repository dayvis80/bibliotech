package upeu.bibliotech_v2.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import upeu.bibliotech_v2.service.PrestamoService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PrestamoController.class)
public class PrestamoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PrestamoService prestamoService;

    @Test
    void debeRetornarTrueCuandoPrestamoEsValido() throws Exception {

        // ARRANGE
        when(prestamoService.puedePrestar(1L, 1L))
                .thenReturn(true);

        // ACT + ASSERT
        mockMvc.perform(
                        get("/api/prestamos/validar")
                                .param("estudianteId", "1")
                                .param("libroId", "1")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
