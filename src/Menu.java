import java.util.ArrayList;
public class Menu {

    public void exibirMenu(boolean atenticado, ArrayList <Itens> estoque, ArrayList <Itens> carrinho){
        System.out.println();
        System.out.println("    --- Menu ---");
        System.out.println("1: Mostrar Produtos e Adicionar ao Carrinho");
        System.out.println("2: Finalizar Venda");
        System.out.println("0: Sair");
        System.out.print("Escolha uma opção: ");
    }
   
    public void mostrarEstoque(ArrayList<Itens> estoque){
            System.out.println();
            System.out.println("Id -  Nome - Valor");
            System.out.println();
        for(int i = 0; i<estoque.size(); i++){  
            System.out.println("0" + i + " "+ estoque.get(i).getProdutoNome() + " = "+ estoque.get(i).getPreco());
        }
    }
    

    public void validar(ArrayList<Itens>carrinho){
      
        
    }
}
