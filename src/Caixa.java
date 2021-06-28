import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Caixa {

    //propriedades
    private List<Produto> listaDeVendas = new ArrayList<>();

    //ação

    public void venderProduto(Produto produto,int quantidade, Estoque estoque){

        //retirar estoque
        estoque.retirarProduto(produto, quantidade);


        //acrescentar na lista de vendas
        for (int indice = 0; indice < quantidade; indice++) {
            listaDeVendas.add(produto);
        }

    }

    public void aplicarDesconto(Produto produto){
        ProdutoPromocao promocao = new ProdutoPromocaoNao();

        if (produto.getPromocao()== Promocao.sim){
            promocao = new ProdutoPromocaoSim();
        }
        promocao.calcularPromocao(produto); //aplicando desconto
    }

    public void totalizarVenda(){
        //imprimir nf
        float precoTotal = 0f;

        for(Produto produto : listaDeVendas){
            aplicarDesconto(produto);
            precoTotal = precoTotal + produto.getPreco(); //preco total +=
            System.out.println("1x " + produto.getNome() + "   R$" +produto.getPreco());
        }


        System.out.println("-----------------");
        System.out.println("Total de produtos comprados" + listaDeVendas.size());
        System.out.println("Total vendas R$:" + precoTotal);
        System.out.println("");
        System.out.println("");
        System.out.println();

        System.out.println();

        System.out.println("*****************************");

        System.out.println("Categoria Limpeza"); // --------------Agrupar por categoria-----------
        for (Produto produto : listaDeVendas.stream().filter(p -> p.getCategoria() == Categoria.limpeza).collect(Collectors.toList())){
            System.out.println("1x " + produto.getNome() + "   R$" +produto.getPreco());
        }


        System.out.println("-----------------");

        System.out.println("Categoria Alimentos"); // --------------Agrupar por categoria-----------
        for (Produto produto : listaDeVendas.stream().filter(p -> p.getCategoria() == Categoria.alimentos).collect(Collectors.toList())){
            System.out.println("1x " + produto.getNome() + "   R$" +produto.getPreco());
        }

    }

}
