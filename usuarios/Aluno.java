/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

public class Aluno {
    
    private  String nome;
    private int acertos;
    
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
    
}
