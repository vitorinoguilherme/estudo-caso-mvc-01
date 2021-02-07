package org.example.models.departamento;

public class Departamento {
    public int codigo;
    public String nome;
    public String sigla;

    public Departamento(int codigo, String nome, String sigla) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Departamento(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "" + codigo + ", " + nome + ", " + sigla + "";
    }
}
