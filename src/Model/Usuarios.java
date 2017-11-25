/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author paulo.bezerra
 */
public class Usuarios {
    
    private String nomeuser;
    private String username;
    private String password;
    
    public String getNomeUser(){
        return nomeuser;
    }
    public void setNomeUser(String nomeuser){
        this.nomeuser = nomeuser;
    }
    
    public String getUserName(){
        return username;
    }
    public void setUserName(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

}
