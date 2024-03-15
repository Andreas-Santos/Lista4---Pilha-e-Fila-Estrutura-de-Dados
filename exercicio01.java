// 1) Cadastre 5 números em uma fila e mais 5 em uma pilha. Em seguida,
// possibilite ao usuário escolher exibir as seguintes informações:
// 1- os números que estão nas duas estruturas.
// 2- os que estão na fila.
// 3- os que estão na pilha.
// 4- colocar os números pares da fila na pilha
// 5- colocar os números impares da pilha na fila

import javax.swing.JOptionPane;

public class exercicio01 {
    public static void main(String[] args) {
        Fila f = new Fila(10);
        Fila fAux = new Fila(5);
        Pilha p = new Pilha(10);
        Pilha pAux = new Pilha(5);
        int opcao;
        int valor;
        
        for(int x = 0; x < 5; x++) {
            valor = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Digite um valor inteiro para adicionar a fila:"));
            f.enfileirar(valor);
            fAux.enfileirar(valor);
        }

        for(int x = 0; x < 5; x++) {
            valor = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Digite um valor inteiro para adicionar a pilha:"));
            p.empilhar(valor);
            pAux.empilhar(valor);
        }

        do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "1 - Exibir os números da Fila e da Pilha" +
                "\n2 - Exibir os números da Fila" +
                "\n3 - Exibir os números da Pilha" +
                "\n4 - Colocar os números pares da Fila na Pilha" +
                "\n5 - Colocar os números ímpares da Pilha na Fila" +
                "\n0 - Encerrar programa" +
                "\nSelecione a opção desejada:"));
                
            switch (opcao) {
                case 1:
                    System.out.println("\nElementos da Fila:");
                    f.exibeFila();
                    System.out.println("\nElementos da Pilha:");
                    p.ExibePilha();
                    break;
                
                case 2:
                    System.out.println("\nElementos da Fila:");
                    f.exibeFila();
                    break;

                case 3:
                    System.out.println("\nElementos da Pilha:");
                    p.ExibePilha();
                    break;
                
                case 4:
                    while(!fAux.vazia()) {
                        int valorDesinfileirado = Integer.parseInt(fAux.desenfileirar());

                        if(valorDesinfileirado % 2 == 0) {
                            JOptionPane.showMessageDialog(
                                null,
                                "Valor empilhado: " + valorDesinfileirado);
                            p.empilhar(valorDesinfileirado);
                        }
                    }
                    break;

                case 5:
                    while (!pAux.vazia()) {
                        int valorDesempilhado = Integer.parseInt(pAux.desempilhar().toString());

                        if(valorDesempilhado % 2 == 1) {
                            JOptionPane.showMessageDialog(
                                null,
                                "Valor enfileirado: " + valorDesempilhado);
                            f.enfileirar(valorDesempilhado);
                        }
                    }
                    break;
                
                case 0:
                    JOptionPane.showMessageDialog(
                        null, "Programa encerrado!");
                    break;

                default:
                    JOptionPane.showMessageDialog(
                        null,
                        "O valor digitado não é válido");
                    break;
            }
        }while(opcao != 0);
    }
}