package com.javaweb.app03_ControllerMVC.service;

import com.javaweb.app03_ControllerMVC.model.Tarefa;
import com.javaweb.app03_ControllerMVC.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService
{
    private List<Tarefa> tarefas = new ArrayList<>();

    public List<Tarefa> listarTarefas(Usuario usuario)
    {
        return tarefas;
    }

    public void adicionarTarefa(Usuario usuario, String descricao)
    {
        Tarefa tarefa = new Tarefa(descricao);
        tarefas.add(tarefa);
    }

    public void marcarComoConcluida(int idTarefa)
    {
        if (idTarefa >= 0 && idTarefa < tarefas.size()) {
            Tarefa tarefa = tarefas.get(idTarefa);
            tarefa.setConcluida(true);
            tarefa.setDataConclusao(LocalDate.now());
        }
    }
}