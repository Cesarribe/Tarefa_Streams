import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SepararPorSexo {
    public static void main(String[] args) {
        List<Pessoa> pessoa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int option = -1;

        while (option != 0) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar pessoa");
            System.out.println("2 - Ver lista de homens");
            System.out.println("3 - Ver lista de mulheres");
            System.out.println("0 - Encerrar");

            option = scanner.nextInt();
            scanner.nextLine(); // para consumir uma linha

            switch (option) {
                case 1:
                    pessoa.addAll(lerPessoaNoConsole());
                    break;
                case 2:
                    List<Pessoa> homens = filtrarGenero(pessoa, 'M');
                    imprimirList(homens, "Lista de homens:");
                    break;
                case 3:
                    List<Pessoa> mulheres = filtrarGenero(pessoa, 'F');
                    imprimirList(mulheres, "Lista de mulheres:");
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static List<Pessoa> lerPessoaNoConsole() {
        List<Pessoa> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        char continueAdding;
        do {
            System.out.println("Digite o nome da pessoa:");
            String name = scanner.nextLine();

            System.out.println("Digite o sexo da pessoa (M/F):");
            char gender = scanner.nextLine().toUpperCase().charAt(0);

            people.add(new Pessoa(name, gender));

            System.out.println("Deseja continuar adicionando pessoas? (S/N):");
            continueAdding = scanner.nextLine().toUpperCase().charAt(0);
        } while (continueAdding == 'S');

        return people;
    }

    private static List<Pessoa> filtrarGenero(List<Pessoa> pessoa, char sexo) {
        return pessoa.stream()
                .filter(person -> person.getSexo() == sexo)
                .collect(Collectors.toList());
    }

    private static void imprimirList(List<Pessoa> pessoa, String tituloLista) {
        System.out.println(tituloLista);
        pessoa.forEach(person -> System.out.println(person.getNome()));
    }
}
