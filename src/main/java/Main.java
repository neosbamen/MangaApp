import controller.ApiCall;
import controller.SearchByNameImp;

public class Main {

    public static void main(String[] args) {

        SearchByNameImp searchByNameImp = new SearchByNameImp();

        //System.out.println(searchByNameImp.searchMangaByName("h"));
        System.out.println(searchByNameImp.searchByChapter("d8a959f7-648e-4c8d-8f23-f1f3f8e129f3","es-la"));

    }
}
