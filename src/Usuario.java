import java.util.ArrayList;

public abstract class Usuario {
    private int id;
    private String nome;
    private int idade;
    private String endereco;
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public Usuario(int id, String nome, int idade, String endereco) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public abstract String menu();

    public static Usuario procurarUser(int id){
        for (Usuario usuario: usuarios) {
            if (usuario.getId()==id){
                return usuario;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }
}
