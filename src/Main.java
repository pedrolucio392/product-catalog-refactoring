import java.util.List;

public class Main {

    public static void main(String[] args) {

        Repository<Produto> repository = new Repository<>();

        repository.adicionar(new Produto("Notebook", "Eletrônicos", 3500));
        repository.adicionar(new Produto("Mouse", "Eletrônicos", 120));
        repository.adicionar(new Produto("Teclado", "Eletrônicos", 250));
        repository.adicionar(new Produto("Cadeira", "Móveis", 900));
        repository.adicionar(new Produto("Mesa", "Móveis", 700));

        ProdutoService service = new ProdutoService();
        List<Produto> produtos = repository.listarTodos();

        System.out.println("ELETRÔNICOS");
        service.filtrar(produtos, p -> p.getCategoria().equalsIgnoreCase("Eletrônicos"))
                .forEach(System.out::println);

        System.out.println("\nATÉ R$ 800:");
        service.filtrar(produtos, p -> p.getPreco() <= 800)
                .forEach(System.out::println);

        System.out.println("\nNOMES:");
        service.obterNomes(produtos).forEach(System.out::println);

        System.out.println("\nORDENADOS POR PREÇO:");
        service.ordenarPorPreco(produtos);
        produtos.forEach(System.out::println);
    }
}