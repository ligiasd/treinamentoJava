import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Estoque {
    //atributos
    private List<Produto> listaEstoque = new ArrayList<>();

    //ações


    public int calcularTotal() {
        //quantos produtos tem na lista?
        return listaEstoque.size();
    }


    //----------------------- CRUD ------------------------------

    //adicionar produto

    public void acrescentarProduto(Produto produto, int quantidade) {
        if (validadeProdutoVencido(produto.getValidade())) {
            System.out.println("Produto vencido ou vence em 15 dias");
        } else {

            for (int index = 0; index < quantidade; index++) {
                listaEstoque.add(produto);

            }
        }
    }


    public boolean validadeProdutoVencido(LocalDate dataDeValidade) {
        LocalDate dataLimite = LocalDate.now().plusDays(16);
        return dataDeValidade.isBefore(dataLimite);
    }


    //--------------------

    //retirar
    public Produto retirarProduto(int codigo) { //alterei parametro Produto produto, int quantidade
        //for (int i = 0; i <= quantidade; i++) {
        Optional<Produto> produtoOptional = listaEstoque.stream()
                .filter(produtoEstoque -> produtoEstoque.getCodigo() == codigo)
                .findFirst();
        //listaEstoque.remove(produto);
        //}
        //se estiver suficiente eu retiro, senao exibe msg
        if (produtoOptional.isPresent()) {
            listaEstoque.remove(produtoOptional.get());
            return produtoOptional.get();
        } else {
            System.out.println("Quantidade em estoque insuficiente ou produto nao encontrado.");
            return null;
        }


    }

    //consultar produto não utiliza metodo void...apenas consulta

    public Produto consultarProduto(int codigo) throws Exception {
        for (Produto produto : listaEstoque.stream().filter(p -> p.getCodigo() == codigo).collect(Collectors.toList())) {
            return produto;
        }
        throw new Exception("Produto não encontrado, por favor verificar código!");
    }

    //--------------------

    //alterar produto

    public void alterarProduto(
            String novoNome,
            int codigo,
            float alterarPreco,
            LocalDate alterarValidade,
            Promocao alterarPromocao,
            Categoria alterarCategoria
    ) {
        //tratamento de erros

        try {
            Produto produto = consultarProduto(codigo);
            produto.setPreco(alterarPreco);
            produto.setNome(novoNome);
            //produto.setValidade(alterarValidade);
            produto.setPromocao(alterarPromocao);
            produto.setCategoria(alterarCategoria);
        } catch (Exception msg) {

            System.out.println(msg.getMessage());
        } //mensagem atraves do exception
    }

    public List<Produto> getListaEstoque() {
        return listaEstoque;
    }

    public void setListaEstoque(List<Produto> listaEstoque) {
        this.listaEstoque = listaEstoque;
    }


    public void listarProdutosEmEstoque() {
        System.out.println("Produtos em Estoque");

        Map<String, Long> result = listaEstoque.stream().collect(
                Collectors.groupingBy(Produto::getNome, Collectors.counting()));
        for (Map.Entry itemMap : result.entrySet()) {
            System.out.println("Produto: " + itemMap.getKey() + " Quantidade: " + itemMap.getValue());
        }
    }

    public void listarProdutosEmEstoqueAgrupadoPorCategoria() {
        System.out.println("______________________________");
        System.out.println("Produtos em Estoque");

        Map<Categoria, Long> result = listaEstoque.stream().collect(
                Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));
        for (Map.Entry itemMap : result.entrySet()) {

            String nomeCategoria = "Limpeza";
            //add demais opçoes de categoria
            if (Categoria.alimentos == itemMap.getKey()){
                nomeCategoria = "Alimentos";
            }else if (Categoria.bebidas == itemMap.getKey()){
                System.out.println("Bebidas");
            }

            System.out.println("______________________________");
            System.out.println(" Categoria: " + nomeCategoria + " | Quantidade Total: " + itemMap.getValue());
            System.out.println(">>>                                   ");

            Map<Produto, Long> resultProdutosCategoria = listaEstoque.stream()
                    .filter(p -> p.getCategoria() == itemMap.getKey()).collect(
                    Collectors.groupingBy(Produto:: getProduto, Collectors.counting()));
            for (Map.Entry itemMapProdutos : resultProdutosCategoria.entrySet()) {

                Produto produto = (Produto) itemMapProdutos.getKey();
                Long quantidadeProduto = (Long) itemMapProdutos.getValue();

                System.out.println( "Cód. "+ produto.getCodigo() + " Quant. " + itemMapProdutos.getValue() + " Produto: " +" R$ "+ produto.getNome());
                System.out.println("______________________________");
            }
        }
    }
}
