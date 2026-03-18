import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Aunticar o pagamento do cliente, dar o troco e finalizar a venda (Por emquanto só no dinheiro)
//Concluindo a compra mostra a tela no console tb
//Depois se possivel tentar fazer um integracao com alguma api de pagamento(Se for de graca)
//Fazer a interface do programa
//Reduzir linhas de codigo, e fazer funcoes em outras classes para encurtar o codigo

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList <Itens> estoque = new ArrayList<>();
        ArrayList <Itens> carrinho = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();

        LocalDateTime agora = LocalDateTime.now(); //Data e Hora de agora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //Formata a Data e Hora para esse formato á esquerda
        String dataFormatada = agora.format(formatter);
        System.out.println("\n "+ dataFormatada);

        ArrayList<Funcionario> equipe = new ArrayList<>(); // Cadastro de Funcionarios
            Funcionario.iniciarEquipe(equipe);
            
        try{
            File arquivo = new File("Itens.txt"); //Caminho do Arquivo txt
            Scanner leitor = new Scanner(arquivo);
        while (leitor.hasNextLine()) { //Le o aquivo por linha
            String linha = leitor.nextLine();
            
            if(linha.isEmpty()){
                continue;
            }

            String[]dados = linha.split(";"); //Coloca espaco aonde tiver ";"
            
            if(dados.length < 4){
                System.out.println("Linha ignorada (formato inválido): " + linha);
            }
            // Converte os textos para os tipos certos
            int id1 = Integer.parseInt(dados[0]);
            double preco = Double.parseDouble(dados[1]);
            String nome = dados[2];
            int quantidade = Integer.parseInt(dados[3].trim());

            estoque.add(new Itens(id1, preco, nome, quantidade)); //Adiciona no ArrayList
        }
            leitor.close();
      
    }catch(FileNotFoundException e){
        System.out.println("Erro: Arquivo não encontrado");
    }
        boolean autenticado = false;        

         Funcionario.CapturaTeclado(equipe); //Pega o que foi digitado, ve se tem na lista, autentifica e retorna um boleano
        
        menu.exibirMenu(autenticado, estoque, carrinho); // Se logado mostrar todos os metodos que se pode acessar

        int escolha = -1;
        int escolhaProduto;
        while (escolha!=0) {

     //Mostra o Menu
            boolean contiuar = false;
            do{
            escolha = sc.nextInt();
        
            switch (escolha) {
                case 1:
                    System.out.println("Numero do Produto: (ou -1 para sair");
                    
                    do{
                        System.out.println("\n--- ESTOQUE ---");
                        System.out.println("Id -  Produto - Preço");
                        System.out.println("Numero do Produto: (ou -1 para sair): ");
                        for (int i = 0; i < estoque.size(); i++) {
                            Itens p = estoque.get(i);
                            System.out.print("0"+ i + " - ");
                            System.out.printf("%-20s | R$ %8.2f%n", p.getProdutoNome(), p.getPreco());
                        }
                        escolhaProduto = sc.nextInt();
                       

                    if(escolhaProduto>=0 && escolhaProduto <estoque.size()){
                        Itens escolhido = estoque.get(escolhaProduto);

                        if(escolhido.getQuantidade() > 0){
                            carrinho.add(escolhido); // adiciona a referência do produto ao carrinho

                            escolhido.setQuantidade(escolhido.getQuantidade() - 1);
                            System.out.println(escolhido.getProdutoNome() + " adicionado ao carrinho");

                        }else{
                            System.out.println("Produto sem estoque");
                        }
                    }else if(escolhaProduto!=1){
                        System.out.println("Opção Invalida.");
                    }
                    
                    }while (escolhaProduto !=-1);
                    //carrinho = 
                    break;
                case 2:
                    System.out.println("\n---Finalizando a Compra...\n");
                    
                    if(carrinho.isEmpty()){
                        System.out.println("Notamos que o carrinho esta vazio! Adicione itens antes de finalizar.");
                        System.out.print("Insira uma Opção do Menu novamente:");
                        contiuar = false;
                    } else if (contiuar==true) {

                        double total = 0;

                        for (int i = 0; i < carrinho.size(); i++) {                       
                                
                                Itens c = carrinho.get(i);
                                System.out.printf("%02d - %-20s | R$ %8.2f%n",i, c.getProdutoNome(), c.getPreco());
                                total += c.getPreco();

                            }
                                System.out.println("------------------------------------------");
                                System.out.printf("TOTAL DA COMPRA:          | R$ %8.2f%n", total);

                            try (java.io.FileWriter escritor = new java.io.FileWriter("Recibos.txt")){
                                
                                escritor.write("*********** Seven Eleven Recibo ***********\n");

                                for(Itens item : carrinho){
                                    escritor.write(item.getProdutoNome() + " -R$ " + item.getPreco() + "\n");
                                }

                                escritor.write("------------------------------------------\n");
                                escritor.write("Total: R$ " + String.format("%.2f", total) + "\n");
                                escritor.write("Muito Obrigado! ");
                                escritor.write("Data" + dataFormatada + "\n");
                                System.out.println();
                                System.out.println("Recibo gerado com sucesso!");
                            } catch (java.io.IOException e) {
                                System.out.println("Erro ao gerar recibo." + e.getMessage());
                            }

                            carrinho.clear();
                        }
                
                    

                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                break;
                default:
                    System.out.println("Opção Invalida");
                    
                    break;
            }
        }while(contiuar==false);
    }
    sc.close();
    }
}

