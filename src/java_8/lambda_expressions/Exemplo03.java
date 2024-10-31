package java_8.lambda_expressions;

import java.util.List;
import java.util.function.Consumer;

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

public class Exemplo03 {
    public static void main(String[] args) {
        // Criando uma lista de produtos
        List<Produto> produtos = List.of(
                new Produto("Televisão", 500.00),
                new Produto("Videogame", 2500.50),
                new Produto("Geladeira", 4900.99)
        );

        // Foreach recebe um Consumer como parâmetro que é uma @FunctionalInterface
        // Seu único metodo é o 'void accept(T var1)', ou seja, recebe um parâmetro e nao tem retorno
        Consumer<Produto> consumer = new Consumer<>() {
            @Override
            public void accept(Produto produto) {
                System.out.println("nome: " + produto.getNome() + ", preço: " + produto.getPreco());
            }
        };
        produtos.forEach(consumer);

        // Usando expressões lambda
        // Fornecendo uma implementação de Consumer<T> usando Lambda Expressions como parâmetro do foreach()
        produtos.forEach(produto -> System.out.println("nome: " + produto.getNome() + ", preço: " + produto.getPreco()));
    }
}
