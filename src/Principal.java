import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        //criar nova classe psvm +enter

        try {


        Produto produtoArroz = new Produto();
        produtoArroz.setNome("Arroz");
        produtoArroz.setCodigo(430);
        produtoArroz.setPreco(12.0f);
        produtoArroz.setValidade(new Date());
        produtoArroz.setPromocao(Promocao.nao);
        produtoArroz.setCategoria(Categoria.alimentos);

        Produto produtoDetergente = new Produto();
        produtoDetergente.setNome("Detergente");
        produtoDetergente.setCodigo(200);
        produtoDetergente.setPreco(1.5f);
        produtoDetergente.setValidade(new Date());
        produtoDetergente.setPromocao(Promocao.nao);
        produtoDetergente.setCategoria(Categoria.limpeza);


        Produto produtoBolacha = new Produto();
        produtoBolacha.setNome("Bolacha");
        produtoBolacha.setCodigo(130);
        produtoBolacha.setPreco(3.20f);
        produtoBolacha.setValidade(new Date());
        produtoBolacha.setPromocao(Promocao.sim);
        produtoBolacha.setCategoria(Categoria.alimentos);

        //criar estoque

        Estoque estoque = new Estoque();
        estoque.acrescertarProduto(produtoArroz, 10);
        estoque.acrescertarProduto(produtoBolacha, 20);
        estoque.acrescertarProduto(produtoDetergente,15);

        Produto produtoConsultado = estoque.consultarProduto(130);
        System.out.println("Consulta do produto cód:" + produtoConsultado.getCodigo() +"| Nome: " + produtoConsultado.getNome() + "| Preço:" + produtoConsultado.getPreco() +"| Categoria: " +produtoConsultado.getCategoria());

        int totalEstoque = estoque.calcularTotal(); //calcular soma
        System.out.println("Total de Produtos em estoque: "+ totalEstoque);


        //tipo nome =valor
        Caixa caixa = new Caixa();

        caixa.venderProduto(produtoArroz,4, estoque);
        caixa.venderProduto(produtoBolacha,1, estoque);
        caixa.venderProduto(produtoDetergente,1, estoque);

        caixa.totalizarVenda();

        }catch (Exception msg){
            System.out.println(msg.getMessage());      } //mensagem atraves do exception
        }

    }

