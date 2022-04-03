package br.com.puc.pucdentistaapi.model;

import lombok.Data;

@Data
public class LoginDTO {
  
  private String usuario;
  private String senha;
}
