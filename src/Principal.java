import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        Produto produtoArroz = new Produto();
        produtoArroz.setNome("Arroz");
        produtoArroz.setCodigo(430);
        produtoArroz.setPreco(12.0f);
        produtoArroz.setValidade(new Date());

        Produto produtoBolacha = new Produto();
        produtoBolacha.setNome("Bolacha");
        produtoBolacha.setCodigo(130);
        produtoBolacha.setPreco(3.20f);
        produtoBolacha.setValidade(new Date());

        //criar estoque

        Estoque estoque = new Estoque();
        estoque.acrescertarProduto(produtoArroz);
        estoque.acrescertarProduto(produtoArroz);
        estoque.acrescertarProduto(produtoBolacha);

        estoque.calcularTotal(); //calcular soma


        //tipo nome =valor
        Caixa caixa =new Caixa();

        caixa.venderProduto(130,2);
        caixa.venderProduto(130,2);
        caixa.venderProduto(130,2)

                caixa.totalizarVenda();
    }
}
