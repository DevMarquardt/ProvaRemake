public class Professor extends Usuario{
    private Disciplina disciplina;
    private Turma turma;

    public Professor(int id, String nome, int idade, String endereco) {
        super(id, nome, idade, endereco);
    }

    @Override
    public String menu() {
        return "professor";
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
