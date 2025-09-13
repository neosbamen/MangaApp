package controller;

import model.ChapterDTO;
import model.MangaDTO;
import model.PageDTO;

import java.util.List;

public class SearchByNameImp extends ApiCall implements IManga{

   /* public SearchByNameImp(){
        this.mangaDTOList=new ArrayList<>();
        this.chapterDTOList=new ArrayList<>();
        this.pageDTOList=new ArrayList<>();
    }*/
    @Override
    public List<MangaDTO> searchMangaByName(String name) {

        ApiCall apiCall = new ApiCall();

   return apiCall.callApiByName(name);
    }

    @Override
    public List<ChapterDTO> searchByChapter(String mangaId) {
        return List.of();
    }

    @Override
    public List<PageDTO> gettingPages(String chapterID) {
        return List.of();
    }
}
