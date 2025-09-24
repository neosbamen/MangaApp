package controller;

import model.Manga;

import java.util.List;

public class SearchByTrending extends MangaManager {


    @Override
    public List<Manga> searchMangaName(String name) {
        return List.of();
    }


    /*@Override
    public List<ChapterDTO> searchByChapter(String mangaId, String languages) {
        return List.of();
    }

    @Override
    public List<PageDTO> gettingPages(String chapterID) {
        return List.of();
    }*/
}
