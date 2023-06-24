package com.example.SpringHomework.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRequest {
    @NotBlank
    @Length(min = 3,message = "Name should contain at least 3 characters")
    private String firstName;
    @NotBlank
    @Length(min = 3)
    private String lastName;
    @Email(message = "Enter valid email")
    private String email;
    @Length(min = 8)
    private String password;

}
