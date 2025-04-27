package com.javaweb.app03_ControllerMVC.repository;

import com.javaweb.app03_ControllerMVC.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();

    public UsuarioRepository()
    {
        usuarios.add(new Usuario("admin", "123456"));
        usuarios.add(new Usuario("usuario1", "senha123"));
    }

    public Optional<Usuario> findByLogin(String login)
    {
        return usuarios.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
    }

    public void save(Usuario usuario)
    {
        usuarios.add(usuario);
    }

    public List<Usuario> findAll()
    {
        return new ArrayList<>(usuarios);
    }
}
