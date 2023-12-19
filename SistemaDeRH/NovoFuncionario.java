public class NovoFuncionario {
    private String nome;
    private String cpf;
    private String rg;

    private NovoFuncionario(String nome, String cpf, String rg) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        return;
    }

    NovoFuncionario() {
    }

    // Recebe dados de fora;
    // Ele é interface publica para receber dados enviados por linha de comando ou interface grafica
    public NovoFuncionario insiraDadosCadastrais(String nome, String cpf, String rg) {
        return new NovoFuncionario(nome, cpf, rg);
    }

    public void obtenhaDadosCadastrais() {
        System.out.println(toString());
    }

    public void assinaContrato() {
        System.out.println("Assinatura de Contrato: " + this.nome);
    }

    @Override
    public String toString() {
        return "nome: %s, cpf: %s, rg: %s".formatted(nome, cpf, rg);
    }
}