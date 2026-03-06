import java.util.ArrayList;

public class Menu {
    public void exibirMenu(){
        System.out.println();
        System.out.println("    --- Menu ---");
        System.out.println("1: Listar Produtos");
        System.out.println("2: Adicionar ao Carrinho");
        System.out.println("3: Finalizar Venda");
        System.out.println("0: Sair");
        System.out.print("Escolha uma opção: ");
    }
    public void mostrarOpcoes(int opcao){

        switch (opcao) {
            case 1:
                System.out.println("Listando Produtos");
                mostrarEstoque();
                break;
            case 2:
                System.out.println("Adicionar ao Carrinho");
                break;

            case 3:
                System.out.println("3. Finalizar Venda");
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Opção Invalida");
                break;
        }
    }

    public void mostrarEstoque(ArrayList<Itens> estoque){
        for(int i = 0; i<estoque.size(); i++){
                    System.out.println((i + 1) + " - " +"Id " + estoque.get(i).getId() + "Nome do Produto: " + estoque.get(i).getProdutoNome() + "Preço: "+ estoque.get(i).getPreco());
        }
    }
}
