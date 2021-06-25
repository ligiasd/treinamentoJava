import java.util.List;

public class Estoque {
    private List<Produto> listaEstoque;

    //ações

    public int calcularTotal(){
        //quantos produtos tem na lista?
        return listaEstoque.size();
    }

    public void acrescertarProduto(Produto){
        //acrescentar produto no estoque
        listaEstoque.add(produto);

    }

    public void retirarProduto(Produto){

    }

}
