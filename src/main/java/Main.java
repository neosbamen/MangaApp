import controller.SearchByNameImp;

public class Main {

    public static void main(String[] args) {
        SearchByNameImp buscarMangas = new SearchByNameImp();
        buscarMangas.searchMangaByName("Pokemon")
                .forEach(manga -> System.out.println(manga.getTitle()));

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
