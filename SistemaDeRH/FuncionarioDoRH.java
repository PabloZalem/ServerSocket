public class FuncionarioDoRH {
    private String numeroDeIdentificacao;
    private NovoFuncionario novoFuncionario;
 
    public FuncionarioDoRH(String numeroDeIdentificacao) {
       System.out.println(this.numeroDeIdentificacao = numeroDeIdentificacao);
    }

    public void solicitaCadastroDeNovoFuncionario() {
        System.out.println("Novo funcionario cadastrado com sucesso: " + novoFuncionario.toString());
    }

    public void assinaCarteiraDeTrabalho(String contrato) {
        System.out.println("Assinando contrato: " + contrato);
    }

    public String solicitaExameAdimissional() {
        return "Numero de identificacao da chefe do RH para solicitar exame adimissional: %s, ".formatted(numeroDeIdentificacao);
    }

    public String cadastraNovoFuncionarioNosCanaisDeComunicao() {
        return "Novo funcionario cadastrado no canal de comunicacao: %s".formatted(novoFuncionario.toString());
    }

}