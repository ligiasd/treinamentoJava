import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    public void acrescentarProduto(Produto produto) {
        if(validadeProdutoVencido(produto.getValidade())){
            System.out.println("Produto vencido ou vence em 15 dias");
        }else {
            listaEstoque.add(produto);
        }
    }


    public boolean validadeProdutoVencido(LocalDate dataDeValidade){
        LocalDate dataLimite = LocalDate.now().plusDays(16);
        return dataDeValidade.isBefore(dataLimite);
    }


    //--------------------

    //retirar
    public Produto retirarProduto(int codigo){ //alterei parametro Produto produto, int quantidade
        //for (int i = 0; i <= quantidade; i++) {
        Optional<Produto>produtoOptional = listaEstoque.stream()
                .filter(produtoEstoque -> produtoEstoque.getCodigo() == codigo)
                .findFirst();
        //listaEstoque.remove(produto);
        //}
        //se estiver suficiente eu retiro, senao exibe msg
        if (produtoOptional.isPresent()) {
            listaEstoque.remove(produtoOptional.get());
            return produtoOptional.get();
        } else {
            System.out.println("Quantidade em estoque insuficiente ou produto nao encontrado.");
            return null;
        }



    }

    //consultar produto não utiliza metodo void...apenas consulta

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
            //produto.setValidade(alterarValidade);
            produto.setPromocao(alterarPromocao);
            produto.setCategoria(alterarCategoria);
        }catch (Exception msg){

            System.out.println(msg.getMessage());      } //mensagem atraves do exception

    }



}
