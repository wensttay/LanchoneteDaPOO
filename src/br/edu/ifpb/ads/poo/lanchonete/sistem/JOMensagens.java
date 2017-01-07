package br.edu.ifpb.ads.poo.lanchonete.sistem;

import javax.swing.JOptionPane;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class JOMensagens {

    public static void error(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public static void error() {
        JOptionPane.showMessageDialog(null, "Opção Inválida !\nEscolha um Número Válido !", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public static void errorEmpty() {
        JOptionPane.showMessageDialog(null, "Sua Lista de Pedido Está Vazia !", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public static void welcome() {
        JOptionPane.showMessageDialog(null, "Bem Vindo ao Programa Lanchonet POO !"
                + "\nPara iniciar escolha um dos tipos de usuários a seguir:"
                + "\nTenha um Bom Dia !", "", JOptionPane.PLAIN_MESSAGE);
    }

    public static void bye() {
        JOptionPane.showMessageDialog(null, "Tenha um Bom dia !\nVolte Sempre !", "LANCHONETE POO FECHADA", JOptionPane.PLAIN_MESSAGE);
    }

    public static void info(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void notice(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "", JOptionPane.WARNING_MESSAGE);
    }
}
