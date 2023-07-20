import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SepararPorSexo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int option = -1;
        while (option != 0) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar pessoa");
            System.out.println("2 - Ver lista de homens");
            System.out.println("3 - Ver lista de mulheres");
            System.out.println("0 - Encerrar");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining new line

            switch (option) {
                case 1:
                    people.addAll(readPeopleFromConsole());
                    break;
                case 2:
                    List<Person> males = filterPeopleByGender(people, 'M');
                    printPeopleList(males, "Lista de homens:");
                    break;
                case 3:
                    List<Person> females = filterPeopleByGender(people, 'F');
                    printPeopleList(females, "Lista de mulheres:");
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

    private static List<Person> readPeopleFromConsole() {
        List<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        char continueAdding;
        do {
            System.out.println("Digite o nome da pessoa:");
            String name = scanner.nextLine();

            System.out.println("Digite o sexo da pessoa (M/F):");
            char gender = scanner.nextLine().toUpperCase().charAt(0);

            people.add(new Person(name, gender));

            System.out.println("Deseja continuar adicionando pessoas? (S/N):");
            continueAdding = scanner.nextLine().toUpperCase().charAt(0);
        } while (continueAdding == 'S');

        return people;
    }

    private static List<Person> filterPeopleByGender(List<Person> people, char gender) {
        return people.stream()
                .filter(person -> person.getGender() == gender)
                .collect(Collectors.toList());
    }

    private static void printPeopleList(List<Person> people, String listTitle) {
        System.out.println(listTitle);
        people.forEach(person -> System.out.println(person.getName()));
    }
}
