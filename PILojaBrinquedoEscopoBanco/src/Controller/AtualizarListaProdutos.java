package Controller;


import Model.Produtos;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paulo.hbezerra
 */
public class AtualizarListaProdutos {
    
    private static java.util.List<Produtos> listaCarrinho = new ArrayList<Produtos>();

    public void inserirProduto(Produtos produtos) {
        listaCarrinho.add(produtos);

    }
    
    public void RemoverProduto(int indice) {
        listaCarrinho.remove(indice);

    }

    public static Produtos atualizarListaCarrinho() {
        if (!listaCarrinho.isEmpty()) {
            for (int i = 0; i < listaCarrinho.size(); i++) {
                if (listaCarrinho.get(i) != null) {
                    return listaCarrinho.get(i);
                
                }
            }
        }
        return null;
    }
    
    public int TamanhoListaCarrinho(){
        return listaCarrinho.size();
    }
        
    

}
