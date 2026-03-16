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

    
    }    