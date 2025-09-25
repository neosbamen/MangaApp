package controller;
import model.Chapter;
import model.Manga;
import model.Page;
import java.util.ArrayList;
import java.util.List;

public abstract class ApiStorage {

    protected List<Manga> mangaList;
    protected List<Chapter> chapterList;
    protected List<Page> pageList;


    public ApiStorage(){
        mangaList =new ArrayList<>();
        chapterList =new ArrayList<>();
        pageList =new ArrayList<>();
    }


    protected void addManga(Manga manga){

        mangaList.add(manga);

    }

    protected void addMangaChapter(Chapter chapter){

        chapterList.add(chapter);

    }

    protected void addMangaPage(Page page){

        pageList.add(page);

    }

    protected List<Manga> getMangaList(){
        return mangaList;
    }

    protected List<Chapter> getChapterList(){
        return chapterList;
    }

    public List<Page> getPageList() {
        return pageList;
    }
}
