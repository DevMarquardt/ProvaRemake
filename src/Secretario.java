public class Secretario extends Usuario{
    private int quantidadeBoletins;

    public Secretario(int id, String nome, int idade, String endereco) {
        super(id, nome, idade, endereco);
    }

    @Override
    public String menu() {
        return """
                [1] - Criar turma
                [2] - Adicionar pessoas a turma
                [3] - Gerar boletins de uma turma
                [0] - Voltar""";
    }
}
