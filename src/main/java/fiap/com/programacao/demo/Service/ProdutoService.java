package fiap.com.programacao.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fiap.com.programacao.demo.Model.Produto;

@Service
public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();

    public ProdutoService() {
        // Criar alguns produtos fictícios para fins de demonstração
        produtos.add(new Produto(1L, "Produto 1", "Descrição do Produto 1", 50.0));
        produtos.add(new Produto(2L, "Produto 2", "Descrição do Produto 2", 100.0));
        produtos.add(new Produto(3L, "Produto 3", "Descrição do Produto 3", 75.0));
    }

    public Produto buscarPorIdBloqueante(Long id) {
        try {
            Thread.sleep(3000); // Simulando uma operação demorada de consulta ao banco de dados
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Procurar o produto na lista pelo ID
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }

        // Se o produto não for encontrado, retornar null
        return null;
    }
}