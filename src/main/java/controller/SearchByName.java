package controller;
import model.Chapter;
import model.Manga;
import model.Page;

import java.util.List;

public class SearchByName extends MangaManager {

    @Override
    public List<Manga> searchMangaName(String name) {
        return super.searchMangaName(name);
    }

    @Override
    public List<Chapter> searchByChapter(String mangaId, String languageIndex) {
        return super.searchByChapter(mangaId, languageIndex);
    }

    @Override
    public List<Page> gettingPages(String chapterID){
        return super.gettingPages(chapterID);
    }

}
