package cliente;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PainelDeCadastroDeFuncionario {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 9999);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // Instanciando um cadastro de usuario
            System.out.print("Informar Nome: ");
            String nome = sc.nextLine();

            System.out.print("Informa sua Idade: ");
            int idade = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha pendente

            System.out.print("Informar cargo dentro da empresa: ");
            String cargo = sc.nextLine();
            
            Funcionario funcionario = new Funcionario(nome, idade, cargo);

            // Enviando o objeto para o servidor
            outputStream.writeObject(funcionario);

            // Recebendo a confirmação do servidor
            String resposta = (String) inputStream.readObject();
            System.out.println("Resposta do servidor: " + resposta);

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
