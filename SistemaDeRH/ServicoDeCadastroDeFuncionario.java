import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class ServicoDeCadastroDeFuncionario implements Serializable{
    public static void main(String...args) throws InterruptedException, IOException {
        try {
            Socket socket = new Socket("localhost", 1234);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // Criando um objeto de exemplo para enviar
            ServicoDeCadastroDeFuncionario funcionario = new ServicoDeCadastroDeFuncionario();
            funcionario.cadastraNovoFuncionario();

            // Enviando o objeto para o servidor
            outputStream.writeObject(funcionario);

            // Recebendo a confirmação do servidor
            String resposta = (String) inputStream.readObject();
            System.out.println("Resposta do servidor: " + resposta.toString());

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void cadastraNovoFuncionario(){
        NovoFuncionario novoFuncionario = new NovoFuncionario();
        novoFuncionario = novoFuncionario.insiraDadosCadastrais("Pablo", "123.123.123-12", "12.123.123-1");
        System.out.println("Cadastrando novo funcionario: " + novoFuncionario.toString());
    }
}
