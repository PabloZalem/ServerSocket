package servidor;

import java.io.*;
import java.net.*;

public class ServicoDeCadastroDeFuncionario {
    public static void main(String[] args) throws InterruptedException {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Aguardando conexão...");

            // Pedido de conexão está sendo feito aqui, apenas.
            // Nenhhum byte é enviado
            // Aqui entra o Looping infinito para que ele posssa aceitar vários pedidos
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Conexão estabelecida.");

                // Um novo socket é criado, portanto os dois estarão juntos
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                // Recebendo o objeto do cliente
                // Aqui ele está esperando os bytes chegarem
                // O método readObject() nos permite receber o loop dos bytes, o loop tem mas,
                // está ai dentro
                // Ele fica esperando os dados do funcionario chegar, caso o cliente fique enrolando de enviar os dados;
                // O servidor fica travado, esperando o cliente terminar portante, essa implementação de servidor é inaceitável
                var funcionario = inputStream.readObject();
                System.out.println("Funcionário recebido: " + funcionario.toString());

                // Processamento do objeto recebido (pode ser o cadastro em um banco de dados,
                // por exemplo)
                // Aqui, vamos simular apenas uma confirmação de cadastro
                String confirmacao = "Funcionário cadastrado com sucesso!";
                outputStream.writeObject(confirmacao);

                //Como nesse momento se encerrou o envio de dados para o cliente não faz sentido 
                //O servidor deixar o socket aberto com o cliente porque ele nao vai enviar mais nada
                socket.close();
            }
            
            //Não podemos colocar a linha baixo no looping pois, o servidor vai ser encerrado
            //Nao vamos conserguir escutar novas conexões.
            //Quando o processo morre instaneamente a porta é liberada no SO
            //Não precisamos mais nos preocupar com o serverSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
