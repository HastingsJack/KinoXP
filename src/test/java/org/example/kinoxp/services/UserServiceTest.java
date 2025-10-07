package org.example.kinoxp.services;

import org.example.kinoxp.dtos.userDto.UserDto;
import org.example.kinoxp.mappers.UserMapper;
import org.example.kinoxp.models.User;
import org.example.kinoxp.models.enums.Role;
import org.example.kinoxp.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserService userService;

    @Mock
    PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createUser_maps_saves_SetsID_andReturnsDTO() {
        //arrange
        when(passwordEncoder.encode("testPassword")).thenReturn("testPassword");
        UserDto input = new UserDto(null, "testName", "testEmail", "testPassword", 13, Role.ADMIN);

        User mapped = new User();
        mapped.setName("testName");
        mapped.setEmail("testEmail");
        mapped.setPassword("testPassword");
        mapped.setRole(Role.ADMIN);

        User saved = new User();
        saved.setId(42);
        saved.setName("testName");
        saved.setEmail("testEmail");
        saved.setPassword("testPassword");
        saved.setAge(13);
        saved.setRole(Role.ADMIN);

        when(userMapper.toUserModel(input)).thenReturn(mapped);
        when(userRepository.save(mapped)).thenReturn(saved);

        //act
        UserDto result = userService.createUser(input);


        //assert
        assertThat(result).isSameAs(input);
        assertThat(result.getId()).isEqualTo(42);


    }
}