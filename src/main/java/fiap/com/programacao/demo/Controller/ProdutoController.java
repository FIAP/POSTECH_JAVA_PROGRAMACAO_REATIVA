package fiap.com.programacao.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.programacao.demo.Model.Produto;
import fiap.com.programacao.demo.Service.ProdutoService;

@RestController
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorIdBloqueante(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
