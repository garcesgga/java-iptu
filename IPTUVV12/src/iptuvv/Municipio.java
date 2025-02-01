/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iptuvv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author jv897
 */
public class Municipio {
   private static List<Imovel> relator = new ArrayList<>(100);
     
        public void Gerenciamento(){
        int matricula = InOut.leInt("Escreva a matricula do imovel : ");
        if(matriculaVV(matricula)){
            InOut.MsgDeAviso("Aviso","Matricula de Outro usuario, favor refazer o cadastro.");
            return;
        }
        String nome = InOut.leString("Escreva seu  nome: ");
        double preco = InOut.leDouble("Escreva o valor do iptu do imovel: ");
        double novoPreco = 0;
   
        int meses = InOut.leInt("Digite os meses atrasado");
        if (meses <= 0){
            InOut.MsgDeErro("Erro","Escreva um valor maior do que zero.");
        }
        if (meses > 0 && meses <= 5){
            InOut.MsgDeInformacao("Imposto",  "Imposto de 1% pelo mês(es)em atraso");
            novoPreco = ((10.0/1000.0) * preco);
        }
        if (meses > 5 && meses <= 8){
            InOut.MsgDeInformacao("Imposto", "Imposto de 2.3% pelo meses em atraso");
            novoPreco = ((23.0/1000.0) * preco);
        }
        if (meses > 8 && meses <= 10 ){
            InOut.MsgDeInformacao("Imposto", "Imposto de 3% pelo meses em atraso");
            novoPreco = ((30.0/1000.0) * preco);
        }
        if (meses > 10 && meses <= 12){
            InOut.MsgDeInformacao("Imposto", "Imposto de 5.4% pelo meses em atraso");
            novoPreco = ((54.0/1000.0) * preco);
        }
        if (meses > 12){
            InOut.MsgDeInformacao("Imposto", "Imposto de 10% pelo meses em atraso");
            novoPreco = ((100.0/1000.0) * preco);
        }
        
        Imovel imovel = new Imovel(matricula, nome, meses, preco, novoPreco);
        relator.add(imovel);
        double iptutotal = imovel.imposto + imovel.multa;
        InOut.MsgSemIcone("Relatorio","Matricula: " + imovel.matricula + "\n Nome: " + imovel.nome + "\n Meses Atrasados: " + imovel.meses 
        +"\n Valor da Multa: " + imovel.multa +"\n Valor a ser pago: " + iptutotal);
       }
    
    
    
        public void Imposto(){
         InOut.MsgDeInformacao("     Menu    ", """ 
        TABELA DE IMPOSTOS: 
        Limites Meses Percentual: Multa (%):
        0    |A meses|  5  | 1%  |                     
        6    |A meses|  8  |2.3% |
        9    |A meses| 10 | 3%  |
        11  |A meses| 12 |5.4& |                                                       
        Maoir que > 12 meses |10%|                    """);
    
    }
       private boolean matriculaVV(int matricula) {
          for ( Imovel imovel: relator) {
            if (imovel.matricula == matricula) {
                return true;
            }
        }
        return false;
    }
       public void ListaCasas(){
           if (relator.isEmpty()) {
            InOut.MsgDeErro("ERRO", "Nenhuma Casa Registrada");
            return;
        }

        Collections.sort(relator, Comparator.comparingInt(imovel -> imovel.matricula));

        for (Imovel imovel : relator) {
            double iptutotal = imovel.imposto + imovel.multa;
            InOut.MsgSemIcone("Casas Regitradas","Matricula: " + imovel.matricula + "\nProprietario: "
                    + imovel.nome + "\nMeses em Atraso: " + imovel.meses +"\n Valor da Multa: "+ imovel.multa +"\nIPTU a ser Pago: " + iptutotal);
        }
       }
}