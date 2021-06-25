import java.util.Date;
import java.util.Scanner;

public class PrincipalInteracao {

    public static void main(String[] args) {

        // criando produtos
        Produto produtoArroz = new Produto();
        produtoArroz.setNome("Arroz");
        produtoArroz.setCodigo(130);
        produtoArroz.setPreco(12.0f);
        produtoArroz.setValidade(new Date());

        Produto produtoBolacha = new Produto("Bolacha", 430, 3.20f, new Date());

        // Criar estoque
        Estoque estoque = new Estoque();
        estoque.acrescentarProduto(produtoArroz);
        estoque.acrescentarProduto(produtoArroz);
        estoque.acrescentarProduto(produtoArroz);
        estoque.acrescentarProduto(produtoBolacha);
        estoque.acrescentarProduto(produtoBolacha);

        int totalEstoque = estoque.calcularTotal(); // exibir a quantidade 5 produtos
        System.out.println("Total de produtos em estoque: " + totalEstoque);

        // Efetuar venda
        Caixa caixa = new Caixa();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o codigo do produto?");
        int codigo = scanner.nextInt();

        if (codigo == 430) {
            caixa.venderProduto(produtoArroz, 1, estoque);
        } else if (codigo == 130) {
            caixa.venderProduto(produtoBolacha, 1, estoque);
        } else {
            System.out.println("Codigo nao encontrado");
        }

        caixa.totalizarVenda();
        totalEstoque = estoque.calcularTotal(); // exibir a quantidade 1 produto
        System.out.println("Total de produtos em estoque: " + totalEstoque);

    }

}
