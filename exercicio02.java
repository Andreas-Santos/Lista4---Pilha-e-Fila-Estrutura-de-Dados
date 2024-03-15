// 2) Usando a classe Pilha disponibilizada, desenvolva um algoritmo que 
// realize a conversão de números decimais para binário.

import javax.swing.JOptionPane;

public class exercicio02 {
    public static void main(String[] args) {
        Pilha p = new Pilha(32);

        int numero;

        numero = Integer.parseInt(JOptionPane.showInputDialog(
            null,
            "Digite um número decimal que deseja converter para binário:"));

        while (numero > 0) {
            int resto = numero % 2;
            p.empilhar(resto);
            numero /= 2;
        }

        System.out.println("O número convertido para binário fica:");
        while(!p.vazia()) {
            System.out.print(p.desempilhar());
        }
    }
}
