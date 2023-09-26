import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main  {
    static Scanner sc = new Scanner(System.in);

    static Usuario logado;

    static Random random = new Random();

    static Disciplina java = new Disciplina("java", 340 , 3);

    static Disciplina poo = new Disciplina("poo", 100 , 2);

    static Disciplina logica = new Disciplina("logica", 160 , 1);

    public static void main(String[] args) {

        menuInicial();
    }

    private static void menuInicial() {
        int opcao;
        do {
            System.out.println("""
                    [1] - Logar
                    [2] - Cadastrar
                    [0] - Sair""");
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    menuLogin();
                    break;
                case 2:
                    menuCadastro();
                    break;
                case 0:
                    System.out.println("Saindo");
                    System.exit(0);
                default:
                    System.out.println("Erro");
                    break;
            }
        }while(opcao!=0);
    }

    private static void menuCadastro() {
        int opcao;
        int idade;
        String nome;
        String endereco;
        int id;
        do {
            System.out.println("""
                    [1] - Cadastrar professor
                    [2] - Cadastrar aluno
                    [3] - Cadastrar secretario
                    [0] - Voltar""");
            opcao = sc.nextInt();
            if (opcao==0){
                menuInicial();
            }
            id = random.nextInt(9999);
            System.out.println("ID de usuário: " + id);
            System.out.println("Qual o nome de usuario?");
            nome = sc.next();
            System.out.println("Qual a idade do usuário?");
            idade = sc.nextInt();
            System.out.println("Qual o endereço do usuário?");
            endereco = sc.next();
            switch (opcao){
                case 1:
                    System.out.println("""
                            Qual a disciplina do professor
                            [1] - Java
                            [2] - Lógica
                            [3] - POO""");
                    int disciplina = sc.nextInt();
                    switch (disciplina){
                        case 1:
                            Usuario professor = new Professor(id, nome, idade, endereco, java);
                            Usuario.usuarios.add(professor);
                            break;
                        case 2:
                            Usuario professor1 = new Professor(id, nome, idade, endereco, logica);
                            Usuario.usuarios.add(professor1);
                            break;
                        case 3:
                            Usuario professor2 = new Professor(id,nome, idade, endereco, poo);
                            Usuario.usuarios.add(professor2);
                    }
                    break;
                case 2:
                    Usuario aluno = new Aluno(id, nome, idade, endereco);
                    Usuario.usuarios.add(aluno);
                    break;
                case 3:
                    Usuario secretario = new Secretario(id, nome, idade, endereco);
                    Usuario.usuarios.add(secretario);
                case 0:
                    menuInicial();
                    break;
                default:
                    System.out.println("Erro");
                    break;
            }
        }while (opcao!=0);
    }

    private static void menuLogin() {
        int opcao;
        do {
            System.out.println("""
                    [1] - Logar
                    [0] - Voltar""");
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite o ID da sua conta:");
                    int id = sc.nextInt();

                    logado = Usuario.procurarUser(id);

                    if (logado==null){
                        System.out.println("Usuário não encontrado");
                    }else{
                        if(logado instanceof Professor){
                            menuProfessor();
                        }else if(logado instanceof Aluno){
                            menuAluno();
                        }else{
                            menuSecretario();
                        }
                    }
            }
        }while(opcao!=0);
    }

    private static void menuSecretario() {
        int opcao;
        int id;
        String nomeTurma;
        do {
            System.out.println(logado.menu());
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Crie um nome para a turma ");
                    nomeTurma = sc.next();
                    Turma turma = new Turma(nomeTurma);
                    Turma.adicionarTurma(turma);
                    break;
                case 2:
                    System.out.println("Digite o nome da turma que deseja adicionar pessoas");
                    nomeTurma = sc.next();
                    if (Turma.procurarTurma(nomeTurma)==null){
                        System.out.println("Turma não encontrada");
                    }else{
                        System.out.println("Digite o ID do usuário");
                        id = sc.nextInt();
                        if (Usuario.procurarUser(id)==null){
                            System.out.println("Usuario não encontrado");
                        }else {
                            if (Usuario.procurarUser(id) instanceof Professor){
                                Turma.professores.add(((Professor) Usuario.procurarUser(id)));
                                ((Professor) (Usuario.procurarUser(id))).setTurma(Turma.procurarTurma(nomeTurma));
                                System.out.println(Turma.alunos);
                                System.out.println(Turma.professores);
                            }else{
                                Turma.alunos.add(((Aluno) Usuario.procurarUser(id)));
                                ((Aluno) Usuario.procurarUser(id)).setTurma(Turma.procurarTurma(nomeTurma));
                                System.out.println(Turma.alunos);
                                System.out.println(Turma.professores);
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome da turma que deseja adicionar pessoas");
                    nomeTurma = sc.next();
                    if (Turma.procurarTurma(nomeTurma)==null){
                        System.out.println("Turma não encontrada");
                    }else{
//                        Falta implementar a lógica de gerar o boletim
                        System.out.println("BOLETIM");
                    }
            }
        }while (opcao!=0);
    }

    private static void menuAluno() {

    }

    private static void menuProfessor() {
        int opcao;
        do {
            logado.menu();
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Qual a turma");
                    String turma = sc.next();
                    if (Turma.procurarTurma(turma)==null){
                        System.out.println("Turma não econtrada");
                    }else{
                        for (Aluno aluno: Turma.getAlunos()) {
                            System.out.println("Que nota o aluno " + aluno.getNome() + " tirou");
                            aluno.getNotas().add(new Prova(((Professor)logado).getDisciplina(), sc.nextDouble()));
                        }
                    }
                case 2:

            }
        }while(opcao!=0);
    }
}
