package com.projectfinally.ProjectoADASchool.controller;

import com.projectfinally.ProjectoADASchool.Service.ExpenseService; // Asegúrate de importar el servicio
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = ExpenseController.class)
public class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Simula el ExpenseService
    private ExpenseService expenseService;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    void testGetAllExpenses() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/expenses"))
                .andExpect(MockMvcResultMatchers.status().isOk());  // Verifica que la respuesta es 200 OK
    }
}
