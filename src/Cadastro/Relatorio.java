package Cadastro;

import java.util.Scanner;

public class Relatorio {
    
    int qntAtleta;
    String[] nome;
    char[] sexo;
    double[] altura;
    double[] peso;

    public int qntAtleta() {
        return qntAtleta;
    }

    public String erroQntAtleta() {
        if (qntAtleta <= 0) {
            return "Não há inscritos";
        }
        return null;
    }

    public void impressao() {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Qual a quantidade de atletas: ");
        qntAtleta = leitor.nextInt();
        leitor.nextLine();

        nome = new String[qntAtleta];
        sexo = new char[qntAtleta];
        altura = new double[qntAtleta];
        peso = new double[qntAtleta];

        for (int i = 0; i < qntAtleta; i++) {
            System.out.println("Digite os dados do atleta número " + (i + 1));
            System.out.print("Nome: ");
            nome[i] = leitor.nextLine();

            while (true) {
                System.out.print("Sexo: ");
                char entradaSexo = leitor.next().toUpperCase().charAt(0);

                if (entradaSexo == 'F' || entradaSexo == 'M') {
                    sexo[i] = entradaSexo;
                    leitor.nextLine();
                    break;
                } else {
                    System.out.println("Valor inválido! Favor digitar F ou M.");
                }
            }

            while (true) {
                System.out.print("Altura: ");
                double entradaAltura = leitor.nextDouble();

                if (entradaAltura > 0) {
                    altura[i] = entradaAltura;
                    break;
                } else {
                    System.out.println("Valor inválido! Favor digitar um valor positivo.");
                }
            }

            while (true) {
                System.out.print("Peso: ");
                double entradaPeso = leitor.nextDouble();

                if (entradaPeso > 0) {
                    peso[i] = entradaPeso;
                    leitor.nextLine();
                    break;
                } else {
                    System.out.println("Valor inválido! Favor digitar um valor positivo.");
                }
            }
        }
        leitor.close();
    }

    public void exibirAtletas() {
        double somaPeso = 0;
        int contadorHomens = 0;
        double somaAlturaMulheres = 0;
        int contadorMulheres = 0;

        for (int i = 0; i < qntAtleta; i++) {
            somaPeso += peso[i];

            if (sexo[i] == 'M') {
                contadorHomens++;
            } else if (sexo[i] == 'F') {
                contadorMulheres++;
                somaAlturaMulheres += altura[i];
            }
        }

        double pesoMedio = somaPeso / qntAtleta;
        double porcentagemHomens = (double) contadorHomens / qntAtleta * 100;

        System.out.println("\n### RELATÓRIO ###");
        System.out.printf("Peso médio dos Atletas: %.2f kg\n", pesoMedio);
        System.out.printf("Porcentagem de homens: %.2f%%\n", porcentagemHomens);

        if (contadorMulheres > 0) {
            double alturaMediaMulheres = somaAlturaMulheres / contadorMulheres;
            System.out.printf("Altura média das mulheres: %.2f m\n", alturaMediaMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas");
        }
    }

    public static void main(String[] args) {
        Relatorio relatorio = new Relatorio();
        relatorio.impressao();
        relatorio.exibirAtletas();
    }
}