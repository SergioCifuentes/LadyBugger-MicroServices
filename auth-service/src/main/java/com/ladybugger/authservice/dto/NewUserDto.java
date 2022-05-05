package com.ladybugger.authservice.dto;

import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewUserDto {
      @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
  
  @NotBlank
  @Size(max = 40)
  private String name;

  @NotBlank
  @Size(max = 40)
  private String middleName;

  @NotBlank
  @Size(max = 40)
  private String lastName;


  
  private String role;  
}
