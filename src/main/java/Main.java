import controller.SearchByName;
import model.Manga;
import model.Chapter;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchByName buscarMangas = new SearchByName();


        System.out.println("\t\t\t Bienvenido a Cueva Manga\n" +
                "1. Buscar Manga por nombre\n" +
                "2. Sugerir Manga popular\n" +
                "3. Buscar Manga por genero\n");

        String optionInput = scanner.nextLine();


        switch (optionInput) {

            case "1": {
                System.out.print("Ingrese nombre del Manga ->\t");
                String mangaName = scanner.nextLine();
                System.out.print("elije un manga -> \t");
                List<Manga> mangas = buscarMangas.searchMangaName(mangaName);

                IntStream.range(0, mangas.size())
                        /*Los mangas pueden decir que vienen traducidos a un dicho idioma pero la verdad es que puede
                         * que no sea asi, entonces nos retornara una lista vacia porque ningun manga o capitulo
                         * coincide con el idioma que le pasamos*/
                        .forEach(i -> System.out.println((i + 1) + ". " + (mangas.get(i).getTitle()) + mangas.get(i).getAvailibleLanguage()));

                String mangaOption = scanner.next();
                int index = Integer.parseInt(mangaOption) - 1;

                Manga mangaFound = mangas.get(index);

                System.out.println("Title: " + mangaFound.getTitle());
                System.out.println("Available Languages" + " " + mangaFound.getAvailibleLanguage());
                System.out.println();
                System.out.println("### " + mangaFound.getDescription() + " ###");
                int results = 0;
                if (mangaFound.getAvailibleLanguage().size() > 1) {
                    System.out.println(mangaFound.getAvailibleLanguage().size());
                    System.out.print("Escoja el idioma que leera su manga -> \t");
                    scanner.nextLine();
                    String chosenLanguage = scanner.nextLine();

                    for (int i = 0; i < mangaFound.getAvailibleLanguage().size(); i++) {
                        if (mangaFound.getAvailibleLanguage().get(i).equals(chosenLanguage)) {
                            results = i;
                        }
                    }
                }
                List<Chapter> chapterList = buscarMangas.searchByChapter(mangaFound.getMangaId(), mangaFound.getAvailibleLanguage().get(results));

                /*Cuando le damos el idioma para filtrar, hay que tener en cuenta que no todos los capitulos van a estar
                disponibles en ese idioma. Lo mejor es primero verificar que idiomas estan disponibles por Manga y de ahi
                si podremos filtrar capitulos por idioma*/

                IntStream.range(0, chapterList.size())
                        .forEach(i -> System.out.println((i + 1) + ". " + chapterList.get(i).getTitle()));

                System.out.println(chapterList);
            }
            break;

            case "2":


        }


    }
}
