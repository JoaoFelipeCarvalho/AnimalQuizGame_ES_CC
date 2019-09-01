/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorio;

import usuarios.Aluno;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ADM
 */
public class Relatorio {
    
    
    public void validarPergunta(int posicao_pergunta,boolean acertou){
       try{
            BufferedReader relatorio = new BufferedReader(new FileReader("c:/teste/relatorio.txt"));
            String[] verificacao;
            String update_row = "";
            for(String line = relatorio.readLine(); line != null; line = relatorio.readLine()){
                verificacao = line.split(";");
                if(Integer.parseInt(verificacao[0])==posicao_pergunta){
                    if(acertou){
                        int valor = Integer.parseInt(verificacao[2]) + 1;
                        update_row = update_row  + verificacao[0] + ";" + verificacao[1] + ";" + valor + ";" + verificacao[3]+ "\n";
                    }else{
                        int valor = Integer.parseInt(verificacao[3]) + 1;
                        update_row = update_row  + verificacao[0] + ";" + verificacao[1] + ";" + verificacao[2] + ";" + valor+ "\n";
                    }
                }else{
                    update_row = update_row  + verificacao[0] + ";" + verificacao[1] + ";" + verificacao[2] + ";" + verificacao[3]+ "\n";
                }
            }
            relatorio.close();
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter("c:/teste/relatorio.txt", false));
            buffWrite.write(update_row);
            buffWrite.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    
    
    public void carregarRelatorio(JTable table){
        DefaultTableModel dtmRanking = (DefaultTableModel) table.getModel();
        try{
            BufferedReader ranking = new BufferedReader(new FileReader("c:/teste/relatorio.txt"));
            String[] verificacao;
            for(String line = ranking.readLine(); line != null; line = ranking.readLine()){
                verificacao = line.split(";");
                byte[] b = verificacao[1].getBytes(StandardCharsets.UTF_8);  
                String teste = new String(b, StandardCharsets.US_ASCII);

                Object[] dados = {verificacao[0],verificacao[1],verificacao[2],verificacao[3]};
                dtmRanking.addRow(dados);
            }
            ranking.close(); 
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
