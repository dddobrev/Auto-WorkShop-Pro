package com.example.AutoWorkShop.web;

import com.example.AutoWorkShop.domain.entities.ClientEntity;
import com.example.AutoWorkShop.repository.ClientRepository;
import com.example.AutoWorkShop.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class ClientControllerTest {
    private static final String CLIENT_CONTROLLER_PREFIX = "/clients";

    private Long testClientId;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;


    @BeforeEach
    public void setUp() {
        this.init();
    }

    @Test
    @WithMockUser(value = "admin", roles = {"USER", "ADMIN"})
    void testShouldReturnValidStatusViewNameAndModel() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                CLIENT_CONTROLLER_PREFIX + "/view/{id}", testClientId
        ))
                .andExpect(status().isOk())
                .andExpect(view().name("client-view"))
                .andExpect(model().attributeExists("client"));
    }


    @Test
    @WithMockUser(value = "admin", roles = {"USER", "ADMIN"})
    void addClient() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(CLIENT_CONTROLLER_PREFIX + "/add")
                .param("firstName", "Mitko")
                .param("secondName", "Dobrev")
                .param("telephone", "0888429635")
                .with(csrf()))
                .andExpect(status().is3xxRedirection());
        Assertions.assertEquals(2, clientRepository.count());

    }


    private void init() {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity
                .setFirstName("Mitko")
                .setSecondName("Dobrev")
                .setTelephone("0888429635");
        clientRepository.save(clientEntity);
        testClientId = clientEntity.getId();
    }
}
