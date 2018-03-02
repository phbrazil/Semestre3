package br.com.fabio.mock;

import br.com.fabio.model.quartos.Quarto;
import java.util.ArrayList;
import java.util.List;

//Mock de Quarto. Realiza operações de mock com o quarto
public class MockQuarto {
    private static int totalQuartos = 0;
    /** Armazena a lista de quartos inseridos para manipulação. #MOCK **/    
    private static List<Quarto> listaQuartos = new ArrayList<Quarto>();

    //Insere um quarto no mock "quarto"
    public static void inserir(Quarto quarto)
            throws Exception {
        quarto.setId(totalQuartos++);
        listaQuartos.add(quarto);
    }

    //Realiza a atualização dos dados de um quarto, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Quarto"
    public static void atualizar(Quarto quartoProcura)
            throws Exception {
        if (quartoProcura != null && quartoProcura.getId() != null && !listaQuartos.isEmpty()) {
            for (Quarto quartoCli : listaQuartos) {
                if (quartoCli != null && quartoCli.getId() == quartoProcura.getId()) {
                    quartoCli.setAndar(quartoProcura.getAndar());
                    quartoCli.setNumero(quartoProcura.getNumero());
                    quartoCli.setTipo(quartoProcura.getTipo());
                    break;
                }
            }
        }
    }

    //Realiza a exclusão de um cliente no mock, com ID fornecido
    //como parâmetro.
    public static void excluir(Integer id) throws Exception {
        if (id != null && !listaQuartos.isEmpty()) {
            for (int i = 0; i < listaQuartos.size(); i++) {
                Quarto quartoLi = listaQuartos.get(i);
                if (quartoLi != null && quartoLi.getId() == id) {
                    listaQuartos.remove(i);
                    break;
                }
            }
        }
    }

    //Lista todos os quartos
    public static List<Quarto> listar()
            throws Exception {        
        //Retorna a lista de quartos 
        return listaQuartos;
    }

    //Procura um quarto na lista, de acordo com o numero
    //do quarto passado como parâmetro
    public static List<Quarto> procurar(Long valor)
            throws Exception {
        List<Quarto> listaResultado = new ArrayList<Quarto>();
        
        if (valor != null && !listaQuartos.isEmpty()) {
            for (Quarto quartoLi : listaQuartos) {
                if (quartoLi != null && quartoLi.getNumero() != null &&
                    quartoLi.getAndar() != null) {
                    if (quartoLi.getNumero() == valor ||
                        quartoLi.getAndar() == valor) {
                        listaResultado.add(quartoLi);
                    }
                }
            }
        }
        
        //Retorna a lista de clientes encontrados
        return listaResultado;
    }

    //Obtém um quarto da lista
    public static Quarto obter(Integer id)
            throws Exception {
        if (id != null && !listaQuartos.isEmpty()) {
            for (int i = 0; i < listaQuartos.size(); i++) {
                if (listaQuartos.get(i) != null && listaQuartos.get(i).getId() == id) {
                    return listaQuartos.get(i);
                }                
            }
        }
        return null;
    }
}
