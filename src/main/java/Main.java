import controller.SearchByNameImp;

public class Main {

    public static void main(String[] args) {

        SearchByNameImp searchByNameImp = new SearchByNameImp();

        //System.out.println(searchByNameImp.searchMangaByName("h"));
        System.out.println(searchByNameImp.searchByChapter("db692d58-4b13-4174-ae8c-30c515c0689c","en"));

    }
}
