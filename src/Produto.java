import java.util.Date;

public class Produto {

    //atributos
    private String nome;
    private int codigo;
    private float preco;
    private Date validade;

    public void cadastrarProduto(String novoNome,
                                 int novoCodigo,
                                 float novoPreco,
                                 Date novaData){
        this.nome = novoNome;
        this.codigo = novoCodigo;
        this.preco = novoPreco;
    }

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

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }






    //ações
    public void definirNome(String novoNome){
        this.nome = novoNome;
    }
}
