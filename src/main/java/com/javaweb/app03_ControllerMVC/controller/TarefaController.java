package com.javaweb.app03_ControllerMVC.controller;

import com.javaweb.app03_ControllerMVC.model.Tarefa;
import com.javaweb.app03_ControllerMVC.model.Usuario;
import com.javaweb.app03_ControllerMVC.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TarefaController
{

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public String listarTarefas(Model model, HttpSession session)
    {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }

        List<Tarefa> tarefas = tarefaService.listarTarefas(usuario);
        model.addAttribute("tarefas", tarefas);
        return "tarefas";
    }

    @PostMapping("/adicionar")
    public String adicionarTarefa(@RequestParam String descricao,
                                  HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario != null) {
            tarefaService.adicionarTarefa(usuario, descricao);
        }
        return "redirect:/tarefas";
    }

    @PostMapping("/concluir/{id}")
    public String concluirTarefa(@PathVariable int id)
    {
        tarefaService.marcarComoConcluida(id);
        return "redirect:/tarefas";
    }
}