package br.com.fabio.service.quarto;

import br.com.fabio.exceptions.QuartoException;
import br.com.fabio.mock.MockQuarto;
import br.com.fabio.exceptions.DataSourceException;
import br.com.fabio.model.quartos.Quarto;
import br.com.fabio.model.validador.quarto.ValidadorQuarto;
import java.util.List;

//Classe de serviço de quarto
public class ServicoQuarto {

    //Insere um quarto na fonte de dados
    public static void cadastrarQuarto(Quarto quarto)
            throws QuartoException, DataSourceException {
        
        //Realiza validações no quarto
        ValidadorQuarto.validar(quarto);

        try {
            //Realiza a chamada de inserção na fonte de dados
            MockQuarto.inserir(quarto);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Atualiza um quarto na fonte de dados
    public static void atualizarQuarto(Quarto quarto)
            throws QuartoException, DataSourceException {
        
        //Realiza validações no quarto
        ValidadorQuarto.validar(quarto);

        try {
            //Realiza a chamada de atualização na fonte de dados
            MockQuarto.atualizar(quarto);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Realiza a pesquisa de um quarto por número na fonte de dados
    public static List<Quarto> procurarQuarto(Long numero)
            throws QuartoException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do mock.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            if (numero == null) {
                return MockQuarto.listar();
            } else {
                return MockQuarto.procurar(numero);
            }
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Obtem o quarto com ID informado do mock
    public static Quarto obterQuarto(Integer id)
            throws QuartoException, DataSourceException {
        try {
            //Retorna o quarto obtido com o DAO
            return MockQuarto.obter(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Exclui o quarto com ID informado do mock
    public static void excluirQuarto(Integer id)
            throws QuartoException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão do quarto informado
            MockQuarto.excluir(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}