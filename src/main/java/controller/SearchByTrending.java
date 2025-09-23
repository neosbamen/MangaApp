package controller;

import model.MangaModel;

import java.util.List;

public class SearchByTrending extends MangaManager {


    @Override
    public List<MangaModel> searchMangaByName(String name) {
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
