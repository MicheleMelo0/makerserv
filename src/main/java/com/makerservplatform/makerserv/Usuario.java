package com.makerservplatform.makerserv;

import java.time.LocalDate;

public class Usuario {
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected LocalDate data_nascimento;
    protected String email;
    protected String senha;
    protected String foto;
    protected boolean ehPrestador;

    public Usuario () {

    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
