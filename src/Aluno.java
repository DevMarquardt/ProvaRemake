import java.util.ArrayList;

public class Aluno extends Usuario{
    private Turma turma;
    public static ArrayList<Prova> notas = new ArrayList<>();

    public Aluno(int id, String nome, int idade, String endereco) {
        super(id, nome, idade, endereco);
    }

    @Override
    public String menu() {
        return "aluno";
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
