package controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.ChapterModel;
import model.MangaModel;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class MangaManager extends ApiStorage{

    private final String BASE_URL_MANGA = "https://api.mangadex.org/manga?title=";
    private final String BASE_URL_CHAPTER = "https://api.mangadex.org/chapter?manga=";
    private final int LIMIT_MANGA = 10;
    private final String BASE_LIMIT_MANGA = "&limit=10&offset=";

    private int offset = 0;
    private String nameManga;
    private String languageManga = "";
    private String languageChaper = "&translatedLanguage[]=".concat(languageManga);
    private String urlBuilt = "";

    protected List<MangaModel> searchMangaByName(String name) {
        this.nameManga = name;
        this.urlBuilt = BASE_URL_MANGA.concat(name).concat(BASE_LIMIT_MANGA).concat(String.valueOf(offset));
        //List<MangaDTO> mangas = new ArrayList<>();

        try {
            int code = urlConnection().getResponseCode();

            if (code == HttpsURLConnection.HTTP_OK) {
                StringBuilder stringBuilder = getStringBuilder();

                JsonObject responseObject = JsonParser.parseString(stringBuilder.toString()).getAsJsonObject();
                JsonArray dataArray = responseObject.getAsJsonArray("data");

                dataArray.forEach(mangaElement -> {
                    JsonObject mangaObject = mangaElement.getAsJsonObject();
                    JsonObject mangaAttributes = mangaObject.get("attributes").getAsJsonObject();
                    JsonArray tagsArray = mangaAttributes.getAsJsonArray("tags");
                    String mangaID = mangaObject.get("id").getAsString();
                    MangaModel manga = new MangaModel();
                    manga.setGenre(listTagsManga(tagsArray));
                    manga.setTitle(titleManga(mangaAttributes));
                    manga.setMangaId(mangaID);
                    manga.setDescription(descriptionManga(mangaAttributes));
                    manga.setAvailibleLanguage(languageManga(mangaAttributes));

                   // mangas.add(manga);

                    addManga(manga);

                });
            } else {
                System.out.println("ERROR AL CONSUMIR");
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return getMangaList();
    }

    private List<String> languageManga(JsonObject mangaAttributes) {
        JsonArray languages = mangaAttributes.getAsJsonArray("availableTranslatedLanguages");
        List<String> languagesList = new ArrayList<>();

        for (JsonElement element : languages) {
            languagesList.add(element.getAsString());
        }
        return languagesList;
    }

    private String descriptionManga(JsonObject mangaAttributes) {
        JsonObject mangaDescription = mangaAttributes.getAsJsonObject("description");
        Set<String> descriptions = mangaDescription.keySet();
        String descriptionFound = "No description";

        for (String element : descriptions) {
            descriptionFound = mangaDescription.get(element).getAsString();
        }
        return descriptionFound;
    }

    private String titleManga(JsonObject mangaAttributes) {
        String title = "";
        JsonObject mangaTitle = mangaAttributes.get("title").getAsJsonObject();
        Set<String> titleElement = mangaTitle.keySet();
        for (String element : titleElement) {
            title = mangaTitle.get(element).getAsString();
        }
        return title;
    }

    private List<String> listTagsManga(JsonArray tagsArray) {
        List<String> tagsList = new ArrayList<>();
        tagsArray.forEach(elementTag -> {
            JsonObject tagObject = elementTag.getAsJsonObject();
            JsonObject tagAttributes = tagObject.getAsJsonObject("attributes");
            JsonObject tagNameObject = tagAttributes.getAsJsonObject("name");

            for (String langKey : tagNameObject.keySet()) {
                String tagName = tagNameObject.get(langKey).getAsString();
                tagsList.add(tagName);
            }
        });
        return tagsList;
    }

    private StringBuilder getStringBuilder() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection().getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {

            stringBuilder.append(line);
        }
        reader.close();
        return stringBuilder;
    }

    private HttpsURLConnection urlConnection() throws IOException {
        URL url = new URL(urlBuilt);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection;
    }

    List<ChapterModel> searchByChapter(String mangaId, String languageIndex) {


        return List.of();
    }

    /*List<PageDTO>gettingPages(String chapterID);*/


}
