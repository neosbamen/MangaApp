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
import java.util.*;

public class SearchByNameImp extends ApiCall {


    @Override
    public List<MangaDTO> searchMangaByName(String name) {

        int offset = 0;
        String baseUrl="https://api.mangadex.org/manga?title=";
        String baseLimit="&limit=10&offset=";
        String offsetCasted= Integer.toString(offset);
        String urlBuilt = baseUrl.concat(name).concat(baseLimit).concat(offsetCasted);

        try {
            URL url = new URL(urlBuilt);
            HttpsURLConnection connection =  (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code=connection.getResponseCode();

            if (code == HttpsURLConnection.HTTP_OK) {
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {

                    stringBuilder.append(line);
                }
                reader.close();

                JsonObject responseObject = JsonParser.parseString(stringBuilder.toString()).getAsJsonObject();
                JsonArray dataArray = responseObject.getAsJsonArray("data");

                for (int x = 0; x < dataArray.size(); x++) {
                    JsonObject mangaObject=dataArray.get(x).getAsJsonObject();
                    JsonObject mangaAttributes=mangaObject.get("attributes").getAsJsonObject();
                    String mainTitle="";
                    JsonObject mangaTitle= mangaAttributes.get("title").getAsJsonObject();

                   Set<String> titleElement =mangaTitle.keySet();
                    for (String element: titleElement){
                        mainTitle=mangaTitle.get(element).getAsString();
                    }

                    JsonObject mangaDescription=mangaAttributes.getAsJsonObject("description");
                    String description=mangaDescription.get("en").getAsString();
                    JsonArray languages = mangaAttributes.getAsJsonArray("availableTranslatedLanguages");
                    List<String>  languagesList= new ArrayList<>();

                    for (JsonElement element:languages){

                        languagesList.add(element.getAsString());
                    }

                    String mangaID= mangaObject.get("id").getAsString();
                    String mangaGenre="shsfdgsf";

                    MangaDTO mangaDTO= new MangaDTO(mainTitle,languagesList,"jhg",mangaID,description);
                    addManga(mangaDTO);
                }
            }else {
                System.out.println("Error");
                return null;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return getMangaList();
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
