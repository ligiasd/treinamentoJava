import java.util.ArrayList;
import java.util.List;

public class Caixa {

    // propriedades
    private List<Produto> listaDeVendas = new ArrayList<>();

    // ações
    public void venderProduto(Produto produto, int quantidade, Estoque estoque){
       // retirar do estoque
        estoque.retirarProduto(produto, quantidade);

       // acrescentar na lista de vendas
        for (int indice = 0; indice < quantidade; indice++) {
            listaDeVendas.add(produto);
        }
    }

    public void totalizarVenda(){
        float precoTotal = 0f;

        for (Produto produto : listaDeVendas) {
            precoTotal = precoTotal + produto.getPreco(); // precoTotal += produto.getPreco();
            System.out.println("1x "+produto.getNome()+"    -  R$"+produto.getPreco());
        }
        System.out.println("--------------");
        System.out.println("Total de produtos:   " + listaDeVendas.size());
        System.out.println("Total:             R$" + precoTotal);
    }

}
