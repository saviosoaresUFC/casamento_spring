package springbootintellij.casamento.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springbootintellij.casamento.modelo.ProdutoModelo;
import springbootintellij.casamento.modelo.RespostaModelo;
import springbootintellij.casamento.repositorio.ProdutoRepositorio;

import java.util.UUID;

@Service

public class ProdutoServico {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private RespostaModelo respostaModelo;

    //    Metodo para listar todos os produtos
    public Iterable<ProdutoModelo> listarAllProducts() {
        return produtoRepositorio.findAll();
    }

    //    Metodo para adicionar um produto
    public ResponseEntity<?> cadastrarEditarProduto(ProdutoModelo produtoModelo, String acao) {
        if (produtoModelo.getNome().equals("") || produtoModelo.getValor_minimo().equals("") || produtoModelo.getValor_maximo().equals("") || produtoModelo.getUrl_imagem().equals("")) {
            respostaModelo.setMensagem("Por favor, preencha todos os campos!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        }
        if (acao.equals("cadastrar")) {
            produtoModelo.setDisponibilidade(true);
            return new ResponseEntity<ProdutoModelo>(produtoRepositorio.save(produtoModelo), HttpStatus.CREATED);
        }
        if (acao.equals("alterar")) {
            produtoRepositorio.save(produtoModelo);
            return new ResponseEntity<ProdutoModelo>(produtoRepositorio.save(produtoModelo), HttpStatus.OK);
        }
        respostaModelo.setMensagem("Ação inválida!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
    }

    //    Metodo para remover produto
    public ResponseEntity<RespostaModelo> removerProduto(UUID id) {
        produtoRepositorio.deleteById(id);
        respostaModelo.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}