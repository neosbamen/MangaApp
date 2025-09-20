package controller;;
import model.ChapterDTO;
import model.MangaDTO;
import model.PageDTO;
import java.util.ArrayList;
import java.util.List;

public abstract class ApiCall implements IManga{

    protected List<MangaDTO> mangaDTOList;
    protected List<ChapterDTO> chapterDTOList;
    protected List<PageDTO>pageDTOList;


    public ApiCall(){
        mangaDTOList=new ArrayList<>();
        chapterDTOList=new ArrayList<>();
        pageDTOList=new ArrayList<>();
    }


    protected void addManga(MangaDTO mangaDTO){

        mangaDTOList.add(mangaDTO);

    }

    protected void addMangaChapter(ChapterDTO  chapterDTO){

        chapterDTOList.add(chapterDTO);

    }

    protected void addMangaPage(PageDTO pageDTO){

        pageDTOList.add(pageDTO);

    }

    protected List<MangaDTO> getMangaList(){
        return mangaDTOList;
    }

    protected List<ChapterDTO> getChapterList(){
        return chapterDTOList;
    }


}
