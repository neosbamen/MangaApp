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

public class ApiCall {

    private List<MangaDTO> mangaDTOList;
    private List<ChapterDTO> chapterDTOList;
    private List<PageDTO>pageDTOList;


    public ApiCall(){
        mangaDTOList=new ArrayList<>();
    }


    public List<MangaDTO> callApiByName(String name){

        String baseUrl="https://api.mangadex.org/manga?title=blue%20lock&limit=2&offset=11";

        try {
            URL url = new URL(baseUrl);
            HttpsURLConnection connection =  (HttpsURLConnection) url.getContent();
            connection.setRequestMethod("Get");
            int code=connection.getResponseCode();

            if (code == HttpsURLConnection.HTTP_OK){
                StringBuilder stringBuilder =new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line= reader.readLine())!=null){

                    stringBuilder.append(line);
                }
                reader.close();

                JsonObject responseObject = JsonParser.parseString(stringBuilder.toString()).getAsJsonObject();
                JsonArray dataArray = responseObject.getAsJsonArray("data");


                for (int x=0; x<=dataArray.size(); x++ ){

                    JsonObject mangaObject=dataArray.get(x).getAsJsonObject();
                    JsonObject mangaAttributes=mangaObject.get("attributes").getAsJsonObject();
                    JsonObject mangaTitle= mangaAttributes.get("title").getAsJsonObject();
                    JsonObject mangaDescription=mangaAttributes.getAsJsonObject("description");
                    JsonArray languages = mangaAttributes.getAsJsonArray("availableTranslatedLanguages");

                    List<JsonElement> allLanguages = new ArrayList<>();

                    for (JsonElement element: languages){

                        allLanguages.add(element);
                    }
                    String title= mangaTitle.get("title").getAsString();
                    String mangaID= mangaObject.get("id").getAsString();
                    String mangaDesc=mangaDescription.get("description").getAsString();
                    String mangaGenre="shsfdgsf";

                    MangaDTO mangaDTO= new MangaDTO(title,"dfgnfhg",mangaID,mangaGenre,mangaDesc);
                    mangaDTOList.add(mangaDTO);
                }


            }else {
                System.out.println("Error");
                return null;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mangaDTOList;
    }


}
