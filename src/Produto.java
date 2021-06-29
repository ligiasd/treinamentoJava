import java.time.LocalDate;
import java.util.Date;

public class Produto {

    //atributos
    private String nome;
    private int codigo;
    private float preco;
    private LocalDate validade;
    private int quantidade;

    private Promocao promocao;
    private Categoria categoria;

    public Produto(String nome, int codigo, float preco, int quantidade, LocalDate validade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.validade = validade;  //validar LocalDate com if/else com throw
        this.quantidade = quantidade;


    }





    //public int getQuantidade() {
       // return quantidade;
    //}

    //public void setQuantidade(int quantidade) {
        //this.quantidade = quantidade;
    //}
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public Produto(){

    }
    // acoes construtor metodo especial para transformar a classe de forma global, objetos à ser estanciados


    //public boolean validaDataDeVencimento(LocalDate dataDeValidade){
        //hoje é dia 15
        //LocalDate dataLimite = LocalDate.now().plusDays(16);

        //produto
        //f (dataDeValidade.isBefore(LocalDate.now())){
          // return true;
        //}else{
            //return false;

        //}


    //}

    //getter e setter metodos especiais alt+insert


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public LocalDate getValidade(LocalDate validade) {
        return validade;
    }

    public LocalDate getValidade() {
        return validade;
    }
}
