//import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList <Itens> estoque = new ArrayList<>();
        Menu menu = new Menu();
        //Date date = new Date();

            Funcionario f1 = new Funcionario("Akira", "Akira123");
            Funcionario f2 = new Funcionario("Tanaka", "Tanaka123");
            boolean autenticado = false;
            System.out.println(" \n  Bem vindo ao Seven Eleven \n");
                int t = 3; // número de tentativas
        

       
        do {
            System.out.print("Id: ");
            String id = sc.nextLine();
            System.out.print("Senha: ");
            String senha = sc.nextLine();

            if (f1.AutenticarId(id) && f1.AutenticarSenha(senha)){
                autenticado = true;
            }else if(f2.AutenticarId(id) && f2.AutenticarSenha(senha)){
                autenticado = true;
            }else{
                    t--; // decrementa tentativas
                    System.out.println("Credencial Incorreta, Tentativas restantes: " + t);
                if (t==0) {
                    //Finaliza o Programa, caso erre as credenciais
                    System.out.println("Máximo de Tentativas Inseridas");
                    System.exit(0);
                }
            }

    
    }while(autenticado!=true);
        int escolha;
        //do{
        //Mostra o Menu
        menu.exibirMenu();

        escolha = sc.nextInt();
        //Opcoes
        menu.mostrarOpcoes(escolha);
        System.out.println("Mostrando estoque");
        menu.mostrarEstoque(estoque);
        

       
        
        
            try{
            //Caminho
            File arquivo = new File("Itens.txt");
            Scanner leitor = new Scanner(arquivo);
            //Le o aquivo por linha

        while (leitor.hasNextLine()) {
            String linha = leitor.nextLine();
                
            //Coloca espaco aonde tiver ;

            String[]dados = linha.split(";");

            // 4. Converte os textos para os tipos certos
            int id = Integer.parseInt(dados[0]);
            double preco = Double.parseDouble(dados[1]);
            String nome = dados[2];

            //Add no ArrayList
            estoque.add(new Itens(id, preco, nome));
        }
            leitor.close();
            System.out.println("Estoque carregado com sucesso");
      
    } catch(FileNotFoundException e){
            System.out.println("Erro: Arquivo não encontrado");
    }
        

    //}while(escolha != 0);

    


    


    sc.close();
    }
}
