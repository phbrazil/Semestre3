/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Produtos;

import Model.Produtos.Produtos;
import View.Produtos.CadastroProdutosTela;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo.bezerra
 */
public class DadosProdutos {

    private boolean tudook = false;

    public boolean ValidaDadosCadastroProdutos(CadastroProdutosTela cadastroproduto, Produtos produtos) {

        //TENTA PEGAR OS DADOS DO NOVO PRODUTO
        do {
            try {
                produtos.setCodigobarras(Integer.valueOf(cadastroproduto.JCodigoBarras.getText()));
                produtos.setNomeProduto(String.valueOf(cadastroproduto.JNomeProduto.getText()));

                produtos.setFabricante(String.valueOf(cadastroproduto.JFabricante.getText()));
                produtos.setFaixaEtaria(String.valueOf(cadastroproduto.jComboFaixa.getSelectedItem()));
                produtos.setGarantia(String.valueOf(cadastroproduto.jComboGarantia.getSelectedItem()));
                //VALOR TEM UM REPLACE CASO O USER INSIRA VIRGULA EM VEZ DE PONTO
                produtos.setValor(Double.valueOf(cadastroproduto.jFormattedValorProduto.getText().replace(",", ".")));
                produtos.setQuantidade((Integer) cadastroproduto.jSpinnerQuantidadeProd.getValue());
                produtos.setValorDesconto(Double.valueOf(cadastroproduto.jFormattedValorProduto.getText().replace(",", ".")));
                tudook = true;

            } catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(null, "Verifique os dados inseridos");
                break;
            }
        } while (tudook == false);

        return tudook;
    }

}
