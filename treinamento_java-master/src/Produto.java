import java.util.ArrayList;
import java.util.Date;

public class Produto {

    //atributos (sempre privados)

    private String nome;
    private int codigo;
    private float preco;
    private Date validade;
    ArrayList<Produto> ListarProduto; //listar produtos cadastrados

    public ArrayList<Produto> getListarProduto() {
        return ListarProduto;
    }

    public void setListarProduto(ArrayList<Produto> listarProduto) {
        ListarProduto = listarProduto;
    }

    public Produto(String nome, int codigo, float preco, Date validade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.validade = validade;
        this.ListarProduto = listarProdutos;
    }



    // getters e setters (métodos "especiais")
    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    public void setPreco(float novoPreco){
        this.preco = novoPreco;
    }

    public float getPreco(){
        return this.preco;
    }

    //adicionar Lista de Produtos--------------------------
    public ArrayList<Produto> listarProdutos?(){

    }


    //adicionar produtos------------------------------------

    public void addProduto(){

    }

}
