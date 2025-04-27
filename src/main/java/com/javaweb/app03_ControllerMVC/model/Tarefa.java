package com.javaweb.app03_ControllerMVC.model;

import java.time.LocalDate;

public class Tarefa
{
    private String descricao;
    private boolean concluida;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;

    public Tarefa()
    {
        this.dataCriacao = LocalDate.now();
        this.concluida = false;
    }

    public Tarefa(String descricao)
    {
        this();
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public boolean isConcluida()
    {
        return concluida;
    }

    public void setConcluida(boolean concluida)
    {
        this.concluida = concluida;
        if (concluida) {
            this.dataConclusao = LocalDate.now();
        } else {
            this.dataConclusao = null;
        }
    }
    public LocalDate getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao)
    {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataConclusao()
    {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao)
    {
        this.dataConclusao = dataConclusao;
    }
    @Override
    public String toString()
    {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", concluida=" + concluida +
                ", dataCriacao=" + dataCriacao +
                ", dataConclusao=" + dataConclusao +
                '}';
    }
}