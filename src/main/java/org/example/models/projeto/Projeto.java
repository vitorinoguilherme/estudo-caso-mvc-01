package org.example.models.projeto;

import org.example.models.departamento.Departamento;

import java.util.Date;

public class Projeto {
    private Integer codigo;
    private String titulo;
    private Date data_inicio;
    private Date data_fim;
    private Departamento departamento;

    public Projeto(Integer codigo, String titulo, Date data_inicio,
            Date data_fim, Departamento departamento) {
        this.setCodigo(codigo);
        this.setTitulo(titulo);
        this.setData_inicio(data_inicio);
        this.setData_fim(data_fim);
        this.departamento = departamento;
    }

    public Projeto(Integer codigo) {
        this.codigo = codigo;
    }

    public void setCodigo(Integer codigo) {
        if (codigo == null) {
            throw new IllegalArgumentException("Codigo invalido.");
        }
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null) {
            throw new IllegalArgumentException("Titulo invalido.");
        }
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setData_inicio(Date data_inicio) {
        if (data_inicio == null) {
            throw new IllegalArgumentException("Data invalida.");
        }
        this.data_inicio = data_inicio;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_fim(Date data_fim) {
        if (data_fim == null) {
            throw new IllegalArgumentException("Data invalida.");
        }
        this.data_fim = data_fim;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Titulo: " + titulo + ", " +
                "Data_inicio: " + data_inicio + ", Data_fim: " + data_fim + " " +
                "Cod_departamento: " + departamento.codigo + "";
    }
}
