import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        //criar nova classe psvm +enter

        Produto produtoArroz = new Produto();
        produtoArroz.setNome("Arroz");
        produtoArroz.setCodigo(430);
        produtoArroz.setPreco(12.0f);
        produtoArroz.setValidade(new Date());
        produtoArroz.setPromocao(Promocao.nao);
        produtoArroz.setCategoria(Categoria.alimentos);

        Produto produtoDetergente = new Produto();
        produtoDetergente.setNome("Detergente");
        produtoDetergente.setCodigo(200);
        produtoDetergente.setPreco(1.5f);
        produtoDetergente.setValidade(new Date());
        produtoDetergente.setPromocao(Promocao.nao);
        produtoDetergente.setCategoria(Categoria.limpeza);


        Produto produtoBolacha = new Produto();
        produtoBolacha.setNome("Bolacha");
        produtoBolacha.setCodigo(130);
        produtoBolacha.setPreco(3.20f);
        produtoBolacha.setValidade(new Date());
        produtoBolacha.setPromocao(Promocao.sim);

        //criar estoque

        Estoque estoque = new Estoque();
        estoque.acrescertarProduto(produtoArroz);
        estoque.acrescertarProduto(produtoArroz);
        estoque.acrescertarProduto(produtoBolacha);

        int totalEstoque = estoque.calcularTotal(); //calcular soma
        System.out.println("Total de Produtos em estoque: "+ totalEstoque);


        //tipo nome =valor
        Caixa caixa = new Caixa();

        caixa.venderProduto(produtoArroz,4, estoque);
        caixa.venderProduto(produtoBolacha,1, estoque);
        caixa.venderProduto(produtoDetergente,1, estoque);

                caixa.totalizarVenda();
    }
}
