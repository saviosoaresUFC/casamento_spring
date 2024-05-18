package springbootintellij.casamento.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootintellij.casamento.modelo.ProdutoModelo;
import springbootintellij.casamento.modelo.RespostaModelo;
import springbootintellij.casamento.servico.ProdutoServico;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProdutoControle {
    @Autowired
    private ProdutoServico produtoServico;

    @GetMapping("/produtos")
        public String rota() {
        return "API de produtos estao funcionando!";
    }

    @GetMapping("/listar_produtos")
    public Iterable<ProdutoModelo> listarProdutos() {
        return produtoServico.listarAllProducts();
    }

    @PostMapping("/cadastrar_produto")
    public ResponseEntity<?> adicionarProduto(@RequestBody ProdutoModelo produtoModelo) {
        return produtoServico.cadastrarEditarProduto(produtoModelo, "cadastrar");
    }

    @PutMapping("/editar_produto")
    public ResponseEntity<?> editarProduto(@RequestBody ProdutoModelo produtoModelo) {
        return produtoServico.cadastrarEditarProduto(produtoModelo, "alterar");
    }

    @DeleteMapping("/deletar_produto/{id}")
    public ResponseEntity<RespostaModelo> deletarProduto(@PathVariable UUID id) {
        return produtoServico.removerProduto(id);
    }
}
