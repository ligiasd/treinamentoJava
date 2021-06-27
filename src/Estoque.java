import java.util.ArrayList;
import java.util.List;

public class Estoque {
    //atributos
    private List<Produto> listaEstoque = new ArrayList<>();

    //ações

    public int calcularTotal(){
        //quantos produtos tem na lista?
        return listaEstoque.size();
    }

    public void acrescertarProduto(Produto produto){
        //acrescentar produto no estoque
        listaEstoque.add(produto);
    }

    public void retirarProduto(Produto produto, int quantidade){
        for (int i = 0; i <= quantidade; i++) {
            listaEstoque.remove(produto);
        }


    }

}
