/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Clientes;

import Model.Clientes.Clientes;
import View.Clientes.CadastroClientesTela;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo.bezerra
 */
public class DadosClientes {

    private boolean tudook = false;
    private String CPFsemTraco = "";

    private long CPF = 0;

     
    
    

    public void ValidaDadosCadastroClientes(CadastroClientesTela cadastrotela, Clientes clientes) {

        //TENTA PEGAR TODOS OS DADOS NO CADASTRO DO CLIENTE
        do {
            try {
                clientes.setNome(String.valueOf(cadastrotela.JClienteNome.getText()));
                clientes.setLogradouro(String.valueOf(cadastrotela.JClienteLogradouro.getText()));
                clientes.setRG(String.valueOf(cadastrotela.jFormattedRG.getText()));

                //GAMBIS PRA TIRAR O TRACINHO E PONTO DO CEP
                clientes.setCPF(String.valueOf(cadastrotela.jFormattedCPF.getText()));
                CPFsemTraco = String.valueOf(cadastrotela.jFormattedCPF.getText().replace(".", ""));
                CPF = Long.valueOf(CPFsemTraco.replace("-", ""));
                clientes.setNumero(String.valueOf(cadastrotela.JClienteNumero.getText()));
                clientes.setCidade(String.valueOf(cadastrotela.JClienteCidade.getText()));
                clientes.setEstado(String.valueOf(cadastrotela.JClienteEstado.getText()));
                clientes.setUF(String.valueOf(cadastrotela.ComboUF.getSelectedItem()));
                clientes.setCep(String.valueOf(cadastrotela.jFormattedCEP.getText().replace("-", "")));
                clientes.setTelefone(String.valueOf(cadastrotela.jFormattedTelefone.getText()));
                clientes.setCelular(String.valueOf(cadastrotela.jFormattedCelular.getText()));
                clientes.setEmail(String.valueOf(cadastrotela.JClienteEmail.getText()));
                clientes.setSexo(String.valueOf(cadastrotela.ComboSexo.getSelectedItem()));
                clientes.setEstadoCivil(String.valueOf(cadastrotela.ComboEstadoCivil.getSelectedItem()));
                clientes.setNascimento(String.valueOf(cadastrotela.jFormattedNascimento.getText()));

                tudook = true;

            } catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(null, "Verifique os dados inseridos");
                break;
            }
        } while (tudook == false);

    }
    public long getCPF(){
        return CPF;
    }

}
