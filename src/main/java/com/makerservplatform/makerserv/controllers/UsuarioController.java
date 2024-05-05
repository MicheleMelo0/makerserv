package com.makerservplatform.makerserv.controllers;

import com.makerservplatform.makerserv.models.entities.Usuario;
import com.makerservplatform.makerserv.models.services.validators.UsuarioValidator;
import com.makerservplatform.makerserv.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @PostMapping("/adicionarUsuario")
    public ResponseEntity<String> adicionarUsuario(@RequestBody Usuario usuario){
        if(UsuarioValidator.validaCpf(usuario.getCpf()) && UsuarioValidator.validaSenha(usuario.getSenha())){
            Usuario UsuarioObj = usuarioRepo.save(usuario);
            return new ResponseEntity<>("Usuário criado com sucesso!", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Cpf ou senha inválidos!", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("listaUsuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        usuarioRepo.findAll().forEach(listaUsuarios::add);
        if(listaUsuarios.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }
}
