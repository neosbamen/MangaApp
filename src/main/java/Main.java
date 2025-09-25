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

        System.out.print("\t\t-----Bienvenido a Cueva Manga-----\t\t\n" +
                "1. Buscar Manga por nombre\n" +
                "2. Sugerir Manga popular\n" +
                "3. Buscar Manga por genero\n\n" +
                "Opción ->\t"
        );
        int optionInput = Integer.parseInt(scanner.nextLine());

        switch (optionInput) {

            case 1: {
                System.out.print("Ingrese nombre del Manga ->\t");
                String mangaName = scanner.nextLine();

                List<Manga> mangas = buscarMangas.searchMangaName(mangaName);

                IntStream.range(0, mangas.size())
                        .forEach(i -> System.out.println((i + 1) + ". " + (mangas.get(i).getTitle()) + mangas.get(i).getAvailibleLanguage()));

                System.out.print("\n elije un manga -> \t");
                String mangaOption = scanner.nextLine();
                int index = Integer.parseInt(mangaOption) - 1;

                Manga mangaFound = mangas.get(index);

                System.out.println("Title: " + mangaFound.getTitle());
                System.out.println("Available Languages" + " " + mangaFound.getAvailibleLanguage() + "\n");
                System.out.println("### " + mangaFound.getDescription() + " ###\n");
                int results = 0;
                if (mangaFound.getAvailibleLanguage().size() > 1) {
                    System.out.print("Escoja el idioma que leera su manga -> \t");
                    String chosenLanguage = scanner.nextLine();

                    for (int i = 0; i < mangaFound.getAvailibleLanguage().size(); i++) {
                        if (mangaFound.getAvailibleLanguage().get(i).equals(chosenLanguage)) {
                            results = i;
                        }
                    }
                }
                List<Chapter> chapterList = buscarMangas.searchByChapter(mangaFound.getMangaId(), mangaFound.getAvailibleLanguage().get(results));

                IntStream.range(0, chapterList.size())
                        .forEach(i -> System.out.println((i + 1) + ". " + chapterList.get(i).getTitle()));

                System.out.print("\nTotal de capitulos disponibles: " + buscarMangas.getTotalChapters());

            }
            break;

            case 2:


        }


    }
}
