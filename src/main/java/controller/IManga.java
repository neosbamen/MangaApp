package controller;

import model.ChapterDTO;
import model.MangaDTO;
import model.PageDTO;

import java.util.List;

public interface IManga {

    List<MangaDTO>searchMangaByName(String name);
    List<ChapterDTO>searchByChapter(String mangaId, String languageIndex);
    List<PageDTO>gettingPages(String chapterID);
}
