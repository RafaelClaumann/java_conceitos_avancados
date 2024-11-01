package java_8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// OPÇÃO 01: Implementando Comparator personalizado com classe separada
// Essa implementação não está sendo usado, serve apenas como exemplo
class ComparatorClasseSeparada implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return p1.getPreco().compareTo(p2.getPreco());
    }
}

public class Exemplo01 {

    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Videogame", 2500.50),
                new Produto("Geladeira 1200L", 4900.99),
                new Produto("Geladeira 500L", 1000.99),
                new Produto("Televisão", 500.00),
                new Produto("Geladeira 2000L", 5900.99)
        );

        // OPÇÃO 02: Implementando comparador customizado usando classe Anonima
        // Lembre-se que é possível declarar uma @FunctionalInterface como função anonima em expressões lambda
        // (p1, p2) -> p1.getPreco().compareTo(p2.getPreco());
        Comparator<Produto> comparatorAnonimo = new Comparator<>() {
            @Override
            public int compare(Produto p1, Produto p2) {
                return p1.getPreco().compareTo(p2.getPreco());
            }
        };

        // Veja que as linhas abaixo representam apenas a ordenação por preço...
        // Foram necessárias 3 linhas de código para conseguir uma ordenação meia boca
        // Queremos:
        //  - Filtrar as geladeiras
        //  - Ordenar por preço
        //  - Transformar o nome das geladeiras em upperCase
        //  - Retornar a lista de nomes de geladeiras
        // Seria preciso executar cada uma dessas operações manualmente
        // Vamos usar streams para simplificar tais operações
        System.out.println("PRODUTOS ORDENADOS POR PREÇO USANDO - COMPARATOR ANONIMO");
        final List<Produto> produtosOrdenadosPorPreco = produtos;
        produtosOrdenadosPorPreco.sort(comparatorAnonimo);
        System.out.println(produtosOrdenadosPorPreco);

        // Veja a facilidade de executar as operações com listas usando streams
        // .sorted(new ComparatorClasseSeparada())
        System.out.println("OPÇÃO 01: TRABALHANDO COM GELADEIRAS USANDO STREAMS");
        List<String> geladeiras = produtos.stream()
                .sorted(comparatorAnonimo)
                .filter(produto -> produto.getNome().contains("Geladeira"))
                .map(produto -> produto.getNome().toUpperCase())
                .toList();
        System.out.println(geladeiras);

        // Veja agora um exemplo usando o Comparator fornecido por Double
        // sorted((p1, p2) -> p1.getPreco().compareTo(p2.getPreco()))
        System.out.println("OPÇÃO 02: TRABALHANDO COM GELADEIRAS USANDO STREAMS");
        List<String> geladeiras1 = produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco))
                .filter(produto -> produto.getNome().contains("Geladeira"))
                .map(produto -> produto.getNome().toUpperCase())
                .toList();
    }

}
