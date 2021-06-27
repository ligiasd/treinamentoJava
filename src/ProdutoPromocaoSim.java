public class ProdutoPromocaoSim implements ProdutoPromocao {
    @Override
    public void calcularPromocao(Produto produto) {
        float desconto = 0.3f;

        produto.setPreco(produto.getPreco() - (produto.getPreco() * desconto));
    }



}
