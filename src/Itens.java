public class Itens{
    private int id;
    private double preco;
    private String produtoNome;
    private int quantidade = 0;
    private String categoria;

    public Itens(int id, double preco, String produtoNome){
        this.id = id;
        this.preco = preco;
        this.produtoNome = produtoNome;
    }
    public int getId(){
        return id;
    }
    public double getPreco(){
        return preco;
    }
    public String getProdutoNome(){
        return produtoNome;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public String getCategoria(){
        return categoria;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    public void setProdutoNome(String produtoNome){
        this.produtoNome = produtoNome;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public int mostrarProdutos(int quantidade){
        return quantidade++;
    }


    

}