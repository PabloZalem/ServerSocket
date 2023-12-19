import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppRH {
    public static void main(String... args) throws ClassNotFoundException {
            ServicoDeCadastroDeFuncionario funcionario = new ServicoDeCadastroDeFuncionario();
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Aguardando o envio de cadastro de funcionario...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Servico de cadastro de funcionário foi estabelecido...");

                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                var novoFuncionario = inputStream.readObject();
                System.out.println("Funcionario cadastrado com sucesso " + novoFuncionario.toString());

                outputStream.writeObject(funcionario.toString());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
