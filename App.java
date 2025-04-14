/*
 * Programacao Orientada a Objetos
 * Exercicio E3
 * Prof. Daniel Callegari
 * 
 * NOME ALUNO(A): Maria Eduarda Schüler
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        
        // As filiais da farmacia
        
        Filial filial1 = new Filial("123.123.123", "Av. Ipiranga, 3000");
        Filial filial2 = new Filial("234.234.234", "Av. Bento Goncalves, 1215");
        Filial filial3 = new Filial("345.345.345", "Av. Ceara, 218");

        // Alguns de seus produtos
        Produto p1 = new Produto(10, "Paracetamol", 19.90);
        Produto p2 = new Produto(20, "Teste Covid19", 49.90);
        Produto p3 = new Produto(30, "Dipirona Caixa", 18.78);
        Produto p4 = new Produto(40, "Fralda Recem nascido 60unid.", 138.29);
        Produto p5 = new Produto(50, "Creme dental", 12.98);
        Produto p6 = new Produto(60, "Repelente", 14.93);
        Produto p7 = new Produto(70, "Suplemento Upa", 189.90);
        Produto p8 = new Produto(80, "Protetor solar", 40.72);
        Produto p9 = new Produto(90, "Desodorante", 18.33);
        Produto p10 = new Produto(100, "Sabonete liquido", 37.19);
        Produto p11 = new Produto(110, "Sensor de Glicose", 289.90);

        //=======================================================================================================
        // TAREFA 1: Vincular produtos às filiais
        // Vincule produtos às filiais (como quiser) - veja exemplo do Paracetamol e do sensor de glicose abaixo
        // Apenas garanta que:
        // - cada produto esteja em pelo menos uma das 3 filiais
        // - alguns dos produtos sejam vendidos POR MAIS DE UMA filial
        // - cada filial tenha produtos EXCLUSIVOS (ou seja, que nenhuma outra filial tambem venda)
        // Nota: Você pode criar outros produtos (p12, p13 etc.) se quiser.
        
        // Exemplo: Paracetamol (p1) é vendido em todas as filiais. Sensor de glicose é vendido apenas na filial 2.
        filial1.adicionarProduto(p1); // Paracetamol
        filial2.adicionarProduto(p1); // Paracetamol
        filial3.adicionarProduto(p1); // Paracetamol
        filial1.adicionarProduto(p2); // Teste Covid19
        filial2.adicionarProduto(p2); // Teste Covid19
        filial2.adicionarProduto(p3); // Dipirona Caixa
        filial1.adicionarProduto(p3); // Dipirona Caixa
        filial3.adicionarProduto(p3); // Dipirona Caixa
        filial2.adicionarProduto(p4); // Fralda Recem nascido 60unid.
        filial3.adicionarProduto(p4); // Fralda Recem nascido 60unid.
        filial1.adicionarProduto(p5); // Creme Dental
        filial2.adicionarProduto(p5); // Creme Dental
        filial3.adicionarProduto(p5); // Creme Dental
        filial2.adicionarProduto(p6); // Repelente
        filial1.adicionarProduto(p7); // Suplemento Upa
        filial3.adicionarProduto(p7); // Suplemento Upa
        filial2.adicionarProduto(p8); // Protetor Solar
        filial1.adicionarProduto(p9); // Desodorante
        filial2.adicionarProduto(p9); // Desodorante
        filial1.adicionarProduto(p10); // Sabonete Liquido
        filial2.adicionarProduto(p10); // Sabonete Liquido
        filial3.adicionarProduto(p10); // Sabonete Liquido
        filial2.adicionarProduto(p11); // Sensor de glicose

        //=======================================================================================================
        // TAREFA 2: Descobrir quais produtos são vendidos em TODAS as filiais
        // Você deve escrever um código que faça uso do framework de coleções do Java para
        // armazenar em uma coleção os produtos que são vendidos tanto na filial 1, como nas filiais 2 e 3.
        // No nosso exemplo, o Paracetamol é um desses produtos.
        // Tecnicamente você deverá escolher a coleção mais adequada e o(s) métodos(s) de Java que ajudam
        // a fazer esse trabalho. Você também terá de acrescentar código necessário nas classes Produto e Filial
        // já existentes para que elas suportem essa funcionalidade. Você não pode criar a solução manualmente,
        // seu algoritmo deve ser genérico, é claro.

        Set<Produto> produtosDisponiveisEmTodasFiliais = new HashSet<Produto>(filial1.getProdutosDisponiveis());
        produtosDisponiveisEmTodasFiliais.retainAll(filial2.getProdutosDisponiveis());
        produtosDisponiveisEmTodasFiliais.retainAll(filial3.getProdutosDisponiveis());

        System.out.println("Produtos em comum em todas as filiais: " + produtosDisponiveisEmTodasFiliais);
        System.out.println("--------------------------------------");

        //=======================================================================================================
        // TAREFA 3: Descobrir quais produtos são vendidos APENAS na filial 2
        // Você deve armazenar em uma coleção os produtos que são vendidos exclusivamente na filial 2 (ou seja,
        // que não sejam também vendidos ou pela filial 1 ou pela filial 3).
        // As mesmas observações da TAREFA 2 valem aqui.

        Set<Produto> produtosExclusivos = new HashSet<>(filial2.getProdutosDisponiveis());
        produtosExclusivos.removeAll(filial1.getProdutosDisponiveis());
        produtosExclusivos.removeAll(filial3.getProdutosDisponiveis());

        System.out.println("Produtos exclusivos da filal 2: " + produtosExclusivos);
        System.out.println("--------------------------------------");

        //=======================================================================================================
        // TAREFA 4: Exibir na tela os produtos resultantes da coleção preenchida na TAREFA 2, ordenados
        // pelo preço (do menor ao maior). Tecnicamente você deve acrescentar à classe Produto o código
        // necessário para que os métodos de ordenação (sort) de Java possam funcionar apropriadamente.

        ArrayList<Produto> produtosComunsOrdenadosPorPreço = new ArrayList<>(produtosDisponiveisEmTodasFiliais);
        Collections.sort(produtosComunsOrdenadosPorPreço);
        System.out.println("Produtos disponiveis em todas as filiais ordenado por preço:");
        for (Produto produto : produtosComunsOrdenadosPorPreço) {
            System.out.println(produto);
        }

        // Bom trabalho!
    }
}