package java_8.method_reference;

import java.util.List;

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
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
}

class Impressora {
    static void imprime(Produto produto) {
        System.out.println("nome: " + produto.getNome() + ", preço: " + produto.getPreco());
    }
}

public class Exemplo02 {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(
                new Produto("Televisão", 500.00),
                new Produto("Videogame", 2500.50),
                new Produto("Geladeira", 4900.99)
        );

        // Usando expressões lambda
        produtos.forEach(produto -> System.out.println("nome: " + produto.getNome() + ", preço: " + produto.getPreco()));

        // Metodo estático de uma classe
        // Imprimindo produto via Method Reference
        produtos.forEach(Impressora::imprime);
    }

}
