import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ProdutoService {

    public List<Produto> filtrar(List<Produto> produtos, Predicate<Produto> criterio) {
        return produtos.stream().filter(criterio).toList();
    }

    public List<String> obterNomes(
            List<Produto> produtos) {
        return produtos.stream().map(Produto::getNome).toList();
    }

    public void ordenarPorPreco(List<Produto> produtos) {
        produtos.sort(Comparator.comparing(Produto::getPreco));
    }
}
