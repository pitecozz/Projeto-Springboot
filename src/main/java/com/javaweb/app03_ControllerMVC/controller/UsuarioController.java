package com.javaweb.app03_ControllerMVC.controller;

import com.javaweb.app03_ControllerMVC.model.Usuario;
import com.javaweb.app03_ControllerMVC.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;


@Controller
public class UsuarioController
{

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarTelaLogin()
    {
        return "login";
    }

    @PostMapping("/validar")
    public String validarCredenciais(@ModelAttribute Usuario usuario, Model model, HttpSession session)
    {
        if (usuarioService.validarCredenciais(usuario.getLogin(), usuario.getSenha())) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/home";
        } else {
            model.addAttribute("msg", "Usuário ou senha incorretos!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/login";
    }
}