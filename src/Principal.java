import javax.xml.catalog.CatalogResolver;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        //**********Instruções*********************
        //criar nova classe psvm +enter
        //regras de vencimento
        //regra 1 - não é possivel cadastrar produto vencido  ou para vencer 15 dias
        //regra 2 - retirar do estoque produtos vencidos
        // regra 3 - não vender produtos vencidos
        // regra 4 -   validar quantidade de produtos antes de vencer

        //Produto produtoArroz = new Produto();
        //produtoArroz.setNome("Arroz");
        //produtoArroz.setCodigo(430);
        //produtoArroz.setPreco(12.0f);
        //produtoArroz.setValidade(LocalDate.of(2021, 6, 29));
        //adicionando mais dois parametros---------------
        //produtoArroz.setPromocao(Promocao.nao);
        //produtoArroz.setCategoria(Categoria.alimentos);

        //Produto produtoDetergente = new Produto();
        //produtoDetergente.setNome("Detergente");
        //produtoDetergente.setCodigo(200);
        //produtoDetergente.setPreco(1.5f);
        //produtoDetergente.setValidade(LocalDate.of(2021, 6, 29));

        //adicionando mais dois parametros---------------
        //produtoDetergente.setPromocao(Promocao.nao);
        //produtoDetergente.setCategoria(Categoria.limpeza);


        //Produto produtoBolacha = new Produto();
        //produtoBolacha.setNome("Bolacha");
        //produtoBolacha.setCodigo(130);
        //produtoBolacha.setPreco(3.20f);
        //produtoBolacha.setValidade(LocalDate.of(2021, 6, 29));
        //adicionando mais dois parametros---------------
        //produtoBolacha.setPromocao(Promocao.sim);
        //produtoBolacha.setCategoria(Categoria.alimentos);

        //inserir regra de validade classe Produto


        //criar estoque

        Estoque estoque = new Estoque();
        //estoque.acrescertarProduto(produtoArroz);
        //estoque.acrescertarProduto(produtoBolacha);
        //stoque.acrescertarProduto(produtoDetergente);

        try {

            Produto produtoConsultado = estoque.consultarProduto(130);
            System.out.println("Consulta do produto cód:" + produtoConsultado.getCodigo() + "| Nome: " + produtoConsultado.getNome() + "| Preço:" + produtoConsultado.getPreco() + "| Categoria: " + produtoConsultado.getCategoria());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        int totalEstoque = estoque.calcularTotal(); //calcular soma
        System.out.println("Total de Produtos em estoque: " + totalEstoque);


        //Efetuando venda     ....tipo nome =valor
        Caixa caixa = new Caixa();

        Scanner scanner = new Scanner(System.in);



        //caixa.venderProduto(130,estoque);
        //caixa.venderProduto(430, estoque);
        //caixa.venderProduto(200,estoque);

        int opcao = 9;
        while (opcao != 0) {
            System.out.println("Digite a opção");
            System.out.println("0 - Finalizar compra");
            System.out.println("1 - Registrar venda de produto");
            System.out.println("2 - Cadastrar produto e adicionar no estoque");

            System.out.println("3 - Listar produtos por categoria cadastradas em estoque");
            System.out.println("4 - Listar produtos em estoque ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registrarProduto(estoque, caixa, scanner);
                    break;
                case 2:
                    cadastrarProduto(estoque, scanner);
                    break;
                case 3:
                    estoque.listarProdutosEmEstoqueAgrupadoPorCategoria();
                    break;
                case 4 :
                    estoque.listarProdutosEmEstoque();
                    break;


            }
        }

        caixa.totalizarVenda();

        //calcu

        totalEstoque = estoque.calcularTotal(); //exibir a quantidade
        System.out.println("Total de produtos em estoque: " + totalEstoque);

    }


    private static void listarProdutos(Estoque estoque) {
        // mostrar produtos em estque



        System.out.println("----------------------------------");
        System.out.println("Categoria Limpeza"); // --------------Agrupar por categoria-----------

        for (Produto produto : estoque.getListaEstoque().stream().filter(p -> p.getCategoria() == Categoria.limpeza)
                .collect(Collectors.toList()))
        {
            System.out.println("Cód."+ produto.getCodigo() + " - "+ produto.getNome() + "-   R$" +produto.getPreco());
        }



        System.out.println("----------------------------------");
        System.out.println("Categoria Alimentos"); // --------------Agrupar por categoria-----------
        for

        (Produto produto : estoque.getListaEstoque().stream().filter(p -> p.getCategoria() == Categoria.alimentos).collect(Collectors.toList())){
            System.out.println("Cód. produto:"+ produto.getCodigo() + " - "+ produto.getNome() + "   R$" +produto.getPreco());

        }




        System.out.println("----------------------------------");
        System.out.println("Categoria Bebidas"); // --------------Agrupar por categoria-----------
        for (Produto produto : estoque.getListaEstoque().stream().filter(p -> p.getCategoria() == Categoria.bebidas).collect(Collectors.toList())){
            System.out.println("Cód. produto:"+ produto.getCodigo() + " - "+ produto.getNome() + "   R$" +produto.getPreco());
            System.out.println("----------------------------------");

        }
        System.out.println("-----------------");
    }



    private static void cadastrarProduto(Estoque estoque, Scanner scanner) {
        System.out.println("Qual o nome do produto?");
        String nome = scanner.next();
        System.out.println("Qual o codigo do produto?");
        int codigo = scanner.nextInt();
        System.out.println("Qual o preco do produto?");
        float preco = scanner.nextFloat();
        System.out.println("Cadastrar desconto para o produto - Programa Fidelidade ?  0 - NÃO | 1 - SIM");
        int promocao = scanner.nextInt();
        System.out.println("Qual categoria?  0 - Alimentos | 1 - Limpeza | 2 - Bebidas");
        int categoria = scanner.nextInt();
        System.out.println("Qual a quantidade dos produtos");
        int quantidade = scanner.nextInt();


        System.out.println("Qual a data de vencimento? dd/mm/aaaa");
        String dataVencimentoString = scanner.next();

        String[] dataVencimentoArray = dataVencimentoString.split("/");
        LocalDate dataVencimento = LocalDate.of(Integer.parseInt(dataVencimentoArray[2]), Integer.parseInt(dataVencimentoArray[1]), Integer.parseInt(dataVencimentoArray[0]));

        //aplicando desconto promocional no produto

        Produto produto = new Produto(nome, codigo, preco,quantidade, dataVencimento);
        if (promocao == 0){
            produto.setPromocao(Promocao.nao);

        }else if (promocao == 1 ){
            produto.setPromocao(Promocao.sim);

        }

        //listar categoria do produto

        switch (categoria){
            case 0:
                produto.setCategoria(Categoria.alimentos);
                break;
            case 1:
                produto.setCategoria(Categoria.limpeza);
                break;
            case 2:
                produto.setCategoria(Categoria.bebidas);
                break;
        }


        estoque.acrescentarProduto(produto, quantidade);




    }

    private static void registrarProduto(Estoque estoque, Caixa caixa, Scanner scanner) {
        System.out.println("Qual o codigo do produto?");
        int codigo = scanner.nextInt();
        System.out.println("Qual a quantidade dos produtos");
        int quantidade = scanner.nextInt();

        caixa.venderProduto(codigo, estoque);
    }


}

