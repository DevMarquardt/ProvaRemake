public class Professor extends Usuario{
    private Disciplina disciplina;
    private Turma turma;

    public Professor(int id, String nome, int idade, String endereco, Disciplina disciplina) {
        super(id, nome, idade, endereco);
        this.disciplina = disciplina;
    }

    @Override
    public String menu() {
        return """
                [1] - Cadastrar uma prova
                [2] - Listar media de um turma
                [0] - Voltar""";
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
