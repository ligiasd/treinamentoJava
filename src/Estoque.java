import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Estoque {
    //atributos
    private List<Produto> listaEstoque = new ArrayList<>();

    //ações

    public int calcularTotal(){
        //quantos produtos tem na lista?
        return listaEstoque.size();
    }

    //----------------------- CRUD ------------------------------

    //adicionar produto
    public void acrescertarProduto(Produto produto, int quantidade){
        //acrescentar produto no estoque
        for (int index = 0; index < quantidade; index++) {
            listaEstoque.add(produto);
        }
    }

    //--------------------

    //retirar
    public void retirarProduto(Produto produto, int quantidade){
        for (int i = 0; i <= quantidade; i++) {
            listaEstoque.remove(produto);
        }
    }

    //consultar produto não utiliza metodo voide ...apenas consulta

    public Produto consultarProduto(int codigo ) throws Exception{
        for (Produto produto : listaEstoque.stream().filter(p -> p.getCodigo() == codigo).collect(Collectors.toList())){
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
            Date alterarValidade,
            Promocao alterarPromocao,
            Categoria alterarCategoria
    ){
        //tratamento de erros

        try {
            Produto produto = consultarProduto(codigo);
            produto.setPreco(alterarPreco);
            produto.setNome(novoNome);
            produto.setValidade(alterarValidade);
            produto.setPromocao(alterarPromocao);
            produto.setCategoria(alterarCategoria);
        }catch (Exception msg){

            System.out.println(msg.getMessage());      } //mensagem atraves do exception

    }


}
