package fiap.com.programacao.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.programacao.demo.Model.Produto;
import fiap.com.programacao.demo.Service.ProdutoService;
import reactor.core.publisher.Mono;

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
    @GetMapping("/produto/{id}")
    public Mono<ResponseEntity<Produto>> getProduto(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorIdBloqueante(id);
        if (produto != null) {
            return Mono.just(ResponseEntity.ok(produto));
        } else {
            return Mono.just(ResponseEntity.notFound().build());
        }
    }
}