public class Funcionario {
    private String id;
    private String senha;

    public Funcionario(){

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
    public Funcionario(String id, String senha){
        this.id = id;
        this.senha = senha;
    }
    public boolean AutenticarId(String id){
        System.out.println("Seja Bem-Vindo, " + id +"!!!");
        return this.id.equals(id);
    }
    public boolean AutenticarSenha(String senha){
      return this.senha.equals(senha);
    }
    
    }    