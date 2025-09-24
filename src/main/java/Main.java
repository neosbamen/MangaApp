import controller.SearchByName;
import model.Manga;
import model.Chapter;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        SearchByName buscarMangas = new SearchByName();



        System.out.println("            Bienvenido a Cueva Manga\n" +
                "1. Buscar Manga por nombre\n" +
                "2. Sugerir Manga popular\n" +
                "3. Buscar Manga por genero\n");

        String optionInput= scanner.nextLine();


        switch (optionInput){

            case "1":

                System.out.println("Ingrese nombre del Manga");
                String mangaName=scanner.nextLine();
                System.out.println("elije un manga");
                List<Manga> mangas = buscarMangas.searchMangaName(mangaName);

                IntStream.range(0, mangas.size())
                        /*Los mangas pueden decir que vienen traducidos a un dicho idioma pero la verdad es que puede
                        * que no sea asi, entonces nos retornara una lista vacia porque ningun manga o capitulo
                        * coincide con el idioma que le pasamos*/
                        .forEach(i -> System.out.println((i+1) + " - " + (mangas.get(i).getTitle())+mangas.get(i).getAvailibleLanguage()));

                String mangaOption= scanner.next();
                int index=Integer.parseInt(mangaOption)-1;

                Manga mangaFound = mangas.get(index);

                System.out.println("Title: "+mangaFound.getTitle());
                System.out.println("Available Languages"+" "+mangaFound.getAvailibleLanguage());
                System.out.println();
                System.out.println("### "+mangaFound.getDescription()+" ###");


                /*Cuando le damos el idioma para filtrar, hay que tener en cuenta que no todos los capitulos van a estar
                disponibles en ese idioma. Lo mejor es primero verificar que idiomas estan disponibles por Manga y de ahi
                si podremos filtrar capitulos por idioma*/
                List<Chapter> chapterList=buscarMangas.searchByChapter(mangaFound.getMangaId(),mangaFound.getAvailibleLanguage().get(0));

                IntStream.range(0, chapterList.size())
                        .forEach(i -> System.out.println((i+1) + " - " + chapterList.get(i).getTitle()));

                System.out.println(chapterList);

                break;

            case "2":


        }


    }
}
