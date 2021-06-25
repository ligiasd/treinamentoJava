import java.util.ArrayList;
import java.util.List;

public class Estoque {

    //atributos
    private List<Produto> listaEstoque = new ArrayList<>();

    // ações
    public int calcularTotal(){
        return listaEstoque.size();
    }

    public void acrescentarProduto(Produto produto){
        listaEstoque.add(produto);
    }

    public void retirarProduto(Produto produto, int quantidade){
        for (int i = 0; i < quantidade; i++) {
            listaEstoque.remove(produto);
        }
    }

}
