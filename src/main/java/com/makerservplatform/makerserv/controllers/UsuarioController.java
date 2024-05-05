package com.makerservplatform.makerserv.controllers;

import com.makerservplatform.makerserv.models.entities.Usuario;
import com.makerservplatform.makerserv.models.services.validators.UsuarioValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @GetMapping(path="listaUsuarios")
    public ArrayList<Usuario> listarUsuarios(){
        Usuario user1 = new Usuario("Maria dos Santos", "594.511.390-52", "5768-1235", "maria@email.com", "senhaforte", "1968-10-22",  true);
        Usuario user2 = new Usuario("João Henrique", "174.059.440-19", "5876-3214", "joao@email.com", "teste", "2000-04-14", false);
        Usuario user3 = new Usuario("Rafael Alves", "555.514.280-36", "4002-8922", "rafael@email.com", "semprefuitriste", "2003-06-15", true);

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        return usuarios;
    }
    @GetMapping(path="testeSenha")
    public boolean testaSenha(){
        Usuario usuario1 = new Usuario();
        usuario1.setSenha("V@ad34");
        return UsuarioValidator.validaSenha(usuario1.getSenha());
    }

    @GetMapping(path="testeCpf")
    public boolean testeCpf(){
        Usuario usuario1 = new Usuario();
        usuario1.setCpf("222.222.222-22");
        return UsuarioValidator.validaCpf(usuario1.getCpf());
    }
}
