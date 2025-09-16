import controller.ApiCall;
import controller.SearchByNameImp;

public class Main {

    public static void main(String[] args) {

        SearchByNameImp searchByNameImp = new SearchByNameImp();

        //System.out.println(searchByNameImp.searchMangaByName("h"));
        System.out.println(searchByNameImp.searchByChapter("75ee72ab-c6bf-4b87-badd-de839156934c","en"));

    }
}
