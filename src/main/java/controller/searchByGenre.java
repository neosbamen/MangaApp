package controller;

import model.ChapterDTO;
import model.MangaDTO;
import model.PageDTO;

import java.util.List;

public class searchByGenre implements IManga{


    @Override
    public List<MangaDTO> searchMangaByName(String name) {
        return List.of();
    }

    @Override
    public List<ChapterDTO> searchByChapter(String mangaId, String languageIndex) {
        return List.of();
    }

    @Override
    public List<PageDTO> gettingPages(String chapterID) {
        return List.of();
    }
}
