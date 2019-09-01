/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

public class Aluno implements Comparable<Aluno> {
    
    private  String nome;
    private int acertos;
    
    public Aluno(String nome){
        this.nome = nome;
        acertos = 0;
    }
    
    
    public Aluno(String nome , int novoAcertos){
        this.nome = nome;
        acertos = novoAcertos;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String novoNome){
        nome = novoNome;
    }
    
    public int getAcertos(){
        return acertos;
    }
    
    public void setAcertos(int novoAcertos){
        acertos = novoAcertos;
    }
    
    public void addAcertos(){
        acertos++;
    }
    
    public int compareTo(Aluno outro) {
        if (this.getAcertos() > outro.getAcertos()) {
          return -1;
        }

        if (this.getAcertos() < outro.getAcertos()) {
          return 1;
        }
        return 0;
    }
}
