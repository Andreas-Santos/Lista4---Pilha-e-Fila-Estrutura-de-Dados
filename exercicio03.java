// 3) Escreva um programa que simule a distribuição de senhas
// de atendimento a um grupo de pessoas. Cada pessoa pode receber
// uma senha prioritária ou normal. O programa deve obedecer os
// seguintes critérios:
// - Existe apenas um atendente.
// - 1 pessoa com senha normal deve ser atendida a cada 3 pessoas com senha
// prioritária
// - Não havendo prioridades, as pessoas com senha normal podem ser
// atendidas.

import javax.swing.JOptionPane;

public class exercicio03 {
    public static void main(String[] args) {
        Fila normal = new Fila(10);
        Fila pref = new Fila(10);
        int senhaPref = 1;
        int senhaNormal = 101;
        int tipoSenha;
        int opcao;
        int contadorPrefChamadas = 0;


        do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                null, 
                "Selecione a opção desejada:" +
                "\n1 - Gerar nova senha" +
                "\n2 - Chamar senha próxima senha" +
                "\n0 - Encerrar programa!"));

            switch (opcao) {
                case 1:
                    tipoSenha = Integer.parseInt(JOptionPane.showInputDialog(
                        null,
                        "Selecione o tipo da senha:" +
                        "\n1 - Normal" +
                        "\n2 - Preferencial"));

                    if(tipoSenha == 1) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Senha normal gerada: " + senhaNormal);
                        normal.enfileirar(senhaNormal);
                        senhaNormal++;
                    }
                    else if(tipoSenha == 2) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Senha preferencial gerada: " + senhaPref);
                        pref.enfileirar(senhaPref);
                        senhaPref++;
                    }
                    else{
                        JOptionPane.showMessageDialog(
                            null,
                            "O valor digitado não é válido, tente novamente!");
                    }
                    break;

                case 2:
                    if(contadorPrefChamadas == 3 || pref.vazia()) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Senha normal chamada: " + normal.desenfileirar());
                        contadorPrefChamadas = 0;
                    }
                    else {
                        JOptionPane.showMessageDialog(
                            null,
                            "Senha Preferencial chamada: " + pref.desenfileirar());
                        contadorPrefChamadas++;
                    }
                    break;

                case 0:
                    JOptionPane.showMessageDialog(
                        null,
                        "Programa encerrado!");
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
