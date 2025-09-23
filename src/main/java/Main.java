import controller.SearchByName;
import model.MangaModel;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        System.out.println("            Bienvenido a Cueva Manga\n" +
                "1. Buscar Manga por nombre\n" +
                "2. Sugerir Manga popular\n" +
                "3. Buscar Manga por genero\n");

        String optionInput= scanner.nextLine();


        switch (optionInput){


            case "1":

                 SearchByName buscarMangas = new SearchByName();

                System.out.println("Ingrese nombre del Manga");
                String mangaName=scanner.nextLine();
                System.out.println("elije un manga");
                List<MangaModel> mangas = buscarMangas.searchMangaByName(mangaName);

                IntStream.range(0, mangas.size())
                        .forEach(i -> System.out.println((i+1) + " - " + mangas.get(i).getTitle()));

                String mangaOption= scanner.next();
                int index=Integer.parseInt(mangaOption)-1;

                MangaModel mangaDTOModel = mangas.get(index);

                System.out.println("Title"+" "+mangaDTOModel.getTitle());
                System.out.println("Available Languages"+" "+mangaDTOModel.getAvailibleLanguage());
                System.out.println();
                System.out.println("### "+mangaDTOModel.getDescription()+" ###");

                break;

            case "2":


        }



        //SearchByNameImp searchByNameImp = new SearchByNameImp();
        /*El main espera recibir un input con el nombre del manga a buscar
        pero el metodo  searchMangaByName no reconoce espacios vacios
        se arregla asegurandonos de que si el input viene con espacios vacios cambiar por %20*/
        /*List<MangaDTO> dtoList=searchByNameImp.searchMangaByName("f");

        System.out.println();

        MangaDTO model=dtoList.stream().findFirst().get();//Lo dejo sin validar pero debemos tratar el posible null
        System.out.println();
        System.out.println("model = " + model);
        List<String> language= model.getAvailibleLanguage();
        Optional<String> optLanguage=language.stream().findAny();

        optLanguage.ifPresent(System.out::println);

        String id = model.getMangaId();
        System.out.println(language);
        System.out.println("id = " + id);*/

        //System.out.println(searchByNameImp.searchByChapter(id, optLanguage.orElse("en")));

    }
}
