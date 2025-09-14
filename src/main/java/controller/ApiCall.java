package controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.ChapterDTO;
import model.MangaDTO;
import model.PageDTO;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class ApiCall implements IManga{

    protected List<MangaDTO> mangaDTOList;
    protected List<ChapterDTO> chapterDTOList;
    protected List<PageDTO>pageDTOList;


    public ApiCall(){
        mangaDTOList=new ArrayList<>();
    }


    protected void addManga(MangaDTO mangaDTO){

        mangaDTOList.add(mangaDTO);

    }

    protected List<MangaDTO> getMangaList(){
        return mangaDTOList;
    }


}
