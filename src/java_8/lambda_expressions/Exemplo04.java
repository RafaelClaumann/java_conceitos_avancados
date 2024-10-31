package java_8.lambda_expressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Produto01 {
    private String nome;
    private Double preco;

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

public class Exemplo04 {
    public static void main(String[] args) {
        // Criando uma lista de produtos
        List<Produto01> produtos = List.of(
                new Produto01("Televisão", 500.00),
                new Produto01("Videogame", 2500.50),
                new Produto01("Geladeira", 4900.99),
                new Produto01("Aquecedor", 200.30)
        );

        System.out.println("PRODUTOS ANTES DA ORDENAÇÃO");
        produtos.forEach(produto -> System.out.println("nome: " + produto.getNome() + ", preço: " + produto.getPreco()));

        // Sort recebe uma instância da @FunctionalInterface Comparator<T> como parâmetro
        // O único metodo de Comparator<T> é int compare(T var1, T var2)
        Comparator<Produto01> comparator = new Comparator<>() {
            @Override
            public int compare(Produto01 p1, Produto01 p2) {
                final Double d1 = p1.getPreco();
                final Double d2 = p2.getPreco();

                if (d1 == null && d2 == null) return 0;
                if (d1 == null) return -1;
                if (d2 == null) return 1;
                return d1.compareTo(d2);
            }
        };
        List<Produto01> ordenadosSemLambda = new ArrayList<>(produtos);
        ordenadosSemLambda.sort(comparator);

        System.out.println("PRODUTOS APÓS A ORDENAÇÃO (IMPLEMENTANDO COMPARATOR)");
        ordenadosSemLambda.forEach(produto -> System.out.println("nome: " + produto.getNome() + ", preço: " + produto.getPreco()));

        // Demonstrando o uso do Comparator<T> como função anonima
        List<Produto01> ordenadosComLambda = new ArrayList<>(produtos);
        ordenadosComLambda.sort((p1, p2) -> p1.getPreco().compareTo(p2.getPreco()));

        System.out.println("PRODUTOS APÓS A ORDENAÇÃO (USANDO LAMBDA)");
        ordenadosComLambda.forEach(produto -> System.out.println("nome: " + produto.getNome() + ", preço: " + produto.getPreco()));

        // Mostrando novamente a lista original
        System.out.println("REEXIBINDO A LISTA ORIGINAL");
        produtos.forEach(produto -> System.out.println("nome: " + produto.getNome() + ", preço: " + produto.getPreco()));
    }

}
