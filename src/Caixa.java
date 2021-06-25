import java.util.ArrayList;
import java.util.List;


public class Caixa {

    //propriedades
    private List<Produto> listaDeVendas = new ArrayList<>();

    //ação

    public void venderProduto(
            Produto produto,
            int quantidade,
            Estoque estoque){

        //retirar estoque

        estoque.retirarProduto(produto, quantidade);


        //acrescentar na lista de vendas
        listaDeVendas.add(produto);
    }

    public void totalizarVenda(){
        float precoTotal = of;

        for(Produtos produto : listaDeVendas){
            precoTotal = precoTotal + produto.getPreco();
            System.out.println("1x " ?+ produto.getNome() + "   -R$" +produto.getPreço());
        }

    }

}
