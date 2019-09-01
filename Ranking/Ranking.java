/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ranking;

import usuarios.Aluno;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class Ranking {
    ArrayList lista = new ArrayList();
    FileWriter arq;

    
    
    public Ranking(){
        try{
            BufferedReader ranking = new BufferedReader(new FileReader("c:/teste/ranking.txt"));
            String[] verificacao;
            for(String line = ranking.readLine(); line != null; line = ranking.readLine()){
                verificacao = line.split(";");
                lista.add(new Aluno(verificacao[0],Integer.parseInt(verificacao[1])));
            }
            ranking.close(); 
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    
    public void adicionarRanking(Aluno novo){
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter("c:/teste/ranking.txt", true));
            String line = novo.getNome() + ";" + Integer.toString(novo.getAcertos()) + "\n";
            buffWrite.append(line);
            buffWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void carregarRanking(JTable table){
        Collections.sort(lista);
        for(int i = 0; i < lista.size(); i++) {
            Aluno player = (Aluno) lista.get(i);
            DefaultTableModel dtmRanking = (DefaultTableModel) table.getModel();
            Object[] dados = {i,player.getNome(),player.getAcertos()};
            dtmRanking.addRow(dados);
        }
    }
}
