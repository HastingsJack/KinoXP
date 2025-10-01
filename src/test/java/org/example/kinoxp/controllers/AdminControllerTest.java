package org.example.kinoxp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.kinoxp.dto.UserDto;
import org.example.kinoxp.mappers.UserMapper;
import org.example.kinoxp.models.enums.Role;
import org.example.kinoxp.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = AdminController.class)
class AdminControllerTest {

    @Autowired
    MockMvc mockMvc;


    @MockBean
    UserService userService;


    @Test
    void createUser_returns201_andBody() throws Exception {
        // Arrange

        String json = """
                {
                  "name": "testname",
                  "email": "testEmail",
                  "password": "testPassword",
                  "age": 13,
                  "role": "ADMIN"
                }
                """;

        UserDto response = new UserDto( 43, "testName", "testEmail", "testPassword", 13, Role.ADMIN);

        //when the userservice.createUser method is called, just return the response object above
        when(userService.createUser(any(UserDto.class))).thenReturn(response);

        // Act + Assert
        mockMvc.perform(post("/admin/create")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(43))
                .andExpect(jsonPath("$.name").value("testName"))
                .andExpect(jsonPath("$.email").value("testEmail"))
                .andExpect(jsonPath("$.password").value("testPassword"))
                .andExpect(jsonPath("$.age").value(13));



    }
}