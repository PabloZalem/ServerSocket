package cliente;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private String nome;
    private int idade;
    private String cargo;

    public Funcionario(String nome, int idade, String cargo) {
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "nome: %s, idade: %d, cargo: %s".formatted(nome, idade, cargo);
    }
}
