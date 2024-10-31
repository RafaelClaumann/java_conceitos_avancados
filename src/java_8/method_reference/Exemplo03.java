package java_8.method_reference;

import java.util.List;

class Produto01 {
    private String nome;
    private double preco;

    public Produto01(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void imprime() {
        System.out.println("nome: " + this.getNome() + ", preço: " + this.getPreco());
    }
}

public class Exemplo03 {
    public static void main(String[] args) {
        List<Produto01> produtos = List.of(
                new Produto01("Televisão", 500.00),
                new Produto01("Videogame", 2500.50),
                new Produto01("Geladeira", 4900.99)
        );

        // Metodo de instância de uma classe
        // A diferença para o Exemplo02 é sutil:
        //  - Exemplo02: Invoca o metodo static a partir de uma classe
        //  - Exemplo03: Invoca o metodo a partir do objeto atual
        // Imprimindo produto via Method Reference
        produtos.forEach(Produto01::imprime);
    }

}
