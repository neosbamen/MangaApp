package controller;
import model.ChapterModel;
import model.MangaModel;
import model.PageModel;
import java.util.ArrayList;
import java.util.List;

public abstract class ApiStorage {

    protected List<MangaModel> mangaDTOList;
    protected List<ChapterModel> chapterDTOList;
    protected List<PageModel>pageDTOList;


    public ApiStorage(){
        mangaDTOList=new ArrayList<>();
        chapterDTOList=new ArrayList<>();
        pageDTOList=new ArrayList<>();
    }


    protected void addManga(MangaModel mangaDTO){

        mangaDTOList.add(mangaDTO);

    }

    protected void addMangaChapter(ChapterModel chapterDTO){

        chapterDTOList.add(chapterDTO);

    }

    protected void addMangaPage(PageModel pageDTO){

        pageDTOList.add(pageDTO);

    }

    protected List<MangaModel> getMangaList(){
        return mangaDTOList;
    }

    protected List<ChapterModel> getChapterList(){
        return chapterDTOList;
    }


}
