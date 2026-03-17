import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario {
    //public static int totalFuncionarios = 0;
    private String id;
    private String senha;
    private String nome;

    public Funcionario(String nome, String id, String senha){
        this.nome = nome;
        this.id = id;
        this.senha = senha;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getId(){
        return id;
    }
    public String getSenha(){
        return senha;
    }
    public void setID(String id){
        this.id = id;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public boolean AutenticarId(String id){
        return this.id.equals(id);
    }
    public boolean AutenticarSenha(String senha){
      return this.senha.equals(senha);
    }

    //Adicionando um metodo para adicionar funcionarios, e autenticar id e senha
    public static void iniciarEquipe(ArrayList<Funcionario> equipe){
        // Cadastro de Funcionarios
        equipe.add(new Funcionario("Akira","Akir4","Akira123"));
        equipe.add(new Funcionario("Tanaka","Tanak4","Tanaka123"));
        equipe.add(new Funcionario("Felipe","Fel1pe","Felipe123"));
        equipe.add(new Funcionario("João Paulo", "Nyan", "Nyan123"));
        equipe.add(new Funcionario("Pedro", "Pedrini", "Petro123"));
    }
    
    public static void CapturaTeclado(ArrayList<Funcionario> equipe){
        Scanner sc = new Scanner(System.in);
        int tentativas = 3;

        while (tentativas>0){
            System.out.println("\n\n--- Login  ---");
            System.out.print("Id: ");
            String idDigitado = sc.nextLine();
            System.out.print("Senha: " );
            String senhaDigitada = sc.nextLine();

            boolean autenticado = false;

            for(Funcionario f : equipe){
                if(f.getId().equals(idDigitado) && f.getSenha().equals(senhaDigitada)){
                    System.out.println("\nBem-Vindo, " + f.getNome() + "!");
                    autenticado = true;
                    return; 
                }
            }

            tentativas--;
            if(tentativas>0){
                System.out.println("Usuário ou senha incorretos. Tente Novamente." + tentativas );
            }
        }
        // Se sair do loop, é porque as tentativas acabaram
        System.out.println("\nMáximo de tentativas alcançado. Sistema bloqueado.");
        System.exit(0);
        sc.close();
    }

    


    }    