import java.util.ArrayList;

public class Turma {
    private String nome;
    public static ArrayList<Turma> turmas = new ArrayList<>();
    public static ArrayList<Aluno> alunos = new ArrayList<>();
    public static ArrayList<Professor> professores = new ArrayList<>();

    public Turma(String nome) {
        this.nome = nome;
    }

    public static void adicionarTurma(Turma turma){
        turmas.add(turma);
    }

    public static Turma procurarTurma(String nome){
        for (Turma turma: turmas) {
            if (turma.getNome().equals(nome)){
                return turma;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public static ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public static ArrayList<Professor> getProfessores() {
        return professores;
    }
}
