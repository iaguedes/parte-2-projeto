package entity;

public class Assinante {

    private String nome;
    private String celular;

    public Assinante(String nome, String celular) {
        this.nome = nome;
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public String getCelular() {
        return celular;
    }
}