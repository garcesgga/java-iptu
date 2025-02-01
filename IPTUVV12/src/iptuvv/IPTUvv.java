/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iptuvv;


/**
 *
 * @author jv897
 */
public class IPTUvv {
       public static void main(String[] args) {
        Municipio ob1 = new Municipio();    
             InOut.MsgDeAviso("Menu",   """ 
                                   Bem Vindo!  Ao sistema de IPTU de VIla Velha""");
             InOut.MsgDeAviso("Inicio", "Você sabe a impotância do"
                     + " IPTU para o desenvolvimento da nossa cidade?");
             InOut.MsgDeInformacao("Importância do IPTU!", "Esse tributo é utilizado em prol da própria comunidade\n"
                     + "conforme escrito e determinado na Constituição Federal (artigo 156, inciso I)\n"
                     + "e é distribuído da seguinte forma:\n" +
                             "25% Educação\n" +
                             "15% Saúde\n" +
                       "O restante é dividido em investimentos em diversas áreas tais como exemplos\n"
                     + " obras de infraestrutura, pavimentação e asfaltamento de ruas e estradas,\n"
                     + "iluminação, programas sociais dentre outros.");
             InOut.MsgDeAviso("Indice", "Agora que você já sabe da importância do Iptu, vamos começar!\n"
                                        +"Avante para construir a Vila Velha do Futuro!");
             InOut.MsgDeInformacao("     Menu    ", """
                                                    1. Cadastrar imovel
                                                    2. tabela de Imposto
                                                    3. Lista de Casas Registradas
                                                    4. Sair""");
        while (true) {
        int opcao = InOut.leInt("Selecione umas das opções:\n 1 - para iniciar o cadastro.\n  2 - para ver tabela de imposto.\n 3 - Lista de Casas Registradas\n 4 - Sair");
        switch (opcao) {
            case 1:
                ob1.Gerenciamento();
                continue;
            case 2:
                ob1.Imposto();
                continue;
            case 3:
                ob1.ListaCasas();
            case 4:
                InOut.MsgDeInformacao("Fim", "Saindo do Programa");;
                System.exit(0);
                 break;
            default:
                InOut.MsgDeInformacao("Erro", "Opção invalida");
        
        }

  }
 }
}