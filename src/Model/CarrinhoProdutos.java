package Model;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paulo.hbezerra
 */
public class CarrinhoProdutos {

    public class Carrinho {

        private Integer idvenda;
        private int quantidateitens;
        private double valorvenda;
        private Date datavenda;
        private String CPFCliente;

        public Integer getIdVenda() {
            return idvenda;
        }

        public void setIdVenda(Integer idvenda) {
            this.idvenda = idvenda;
        }

        public int getQuantidadeItens() {
            return quantidateitens;
        }

        public void setQuantidadeItens(int quantidadeitens) {
            this.quantidateitens = quantidadeitens;
        }

        public double getValorVenda() {
            return valorvenda;
        }

        public void setValorVenda(double valorvenda) {
            this.valorvenda = valorvenda;
        }

        public String getCPFCliente() {
            return CPFCliente;
        }

        public void setCPFCliente(String CPFcliente) {
            this.CPFCliente = CPFcliente;
        }
        
        public Date getDatavenda() {
            return datavenda;
        }

        public void setDatavenda(Date datavenda) {
            this.datavenda = datavenda;
        }
    }

}
