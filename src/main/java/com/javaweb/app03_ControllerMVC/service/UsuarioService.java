package com.javaweb.app03_ControllerMVC.service;

import com.javaweb.app03_ControllerMVC.model.Usuario;
import com.javaweb.app03_ControllerMVC.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean validarCredenciais(String login, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByLogin(login);
        return usuarioOpt.isPresent() && usuarioOpt.get().getSenha().equals(senha);
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuarioRepository.findByLogin(usuario.getLogin()).isPresent()) {
            throw new RuntimeException("Usuário já existe!");
        }
        usuarioRepository.save(usuario);
    }
}