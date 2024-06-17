package com.platform.makerserv.models.entities;

import java.time.LocalDate;

import com.platform.makerserv.enums.UserTypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="testando")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;
    private final String cpf;
    private String telefone;
    private LocalDate data_nascimento;
    private String email;
    private String senha;
    private UserTypeEnum type;

    public Usuario (
    		String nome,
    		String cpf, 
    		String telefone,
    		String email,
    		String senha,
    		String dataNascimento,
    		UserTypeEnum type ) {
    	
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.data_nascimento = LocalDate.parse(dataNascimento);
        this.type = type;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public String getTelefone(){
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getData_nascimento(){
        return data_nascimento;
    }
    
    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    private Enum getType() {
    	return type;
    }

}
