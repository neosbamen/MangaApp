package controller;

import model.MangaDTO;

import java.util.List;

public class SearchByTrending extends Manga {


    @Override
    public List<MangaDTO> searchMangaByName(String name) {
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
