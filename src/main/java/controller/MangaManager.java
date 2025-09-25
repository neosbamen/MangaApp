package controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Chapter;
import model.Manga;
import model.Page;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class MangaManager extends ApiStorage{

    private final String BASE_URL_MANGA = "https://api.mangadex.org/manga?title=";
    private final String BASE_URL_CHAPTER = "https://api.mangadex.org/chapter?manga=";
    private final String BASE_URL_PAGE ="https://api.mangadex.org/at-home/server/";
    private final int LIMIT_MANGA = 10;
    private final String BASE_LIMIT_MANGA = "&limit=10&offset=";
    private final String chapterLimitation="&order[chapter]=asc&limit=10&offset=";

    private int offset = 0;
    private String nameManga;
    private String languageManga = "";
    private String languageChaper = "&translatedLanguage[]=";
    private String urlBuilt = "";
    protected List<Manga> searchMangaName(String name) {
        String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);
        this.nameManga = encodedName;
        this.urlBuilt = BASE_URL_MANGA.concat(nameManga).concat(BASE_LIMIT_MANGA).concat(String.valueOf(offset));

        try {
            int code = urlConnection(urlBuilt).getResponseCode();

            if (code == HttpsURLConnection.HTTP_OK) {
                StringBuilder stringBuilder = getStringBuilder();

                JsonObject responseObject = JsonParser.parseString(stringBuilder.toString()).getAsJsonObject();
                JsonArray dataArray = responseObject.getAsJsonArray("data");

                dataArray.forEach(mangaElement -> {
                    JsonObject mangaObject = mangaElement.getAsJsonObject();
                    JsonObject mangaAttributes = mangaObject.get("attributes").getAsJsonObject();
                    JsonArray tagsArray = mangaAttributes.getAsJsonArray("tags");
                    String mangaID = mangaObject.get("id").getAsString();
                    Manga manga = new Manga();
                    manga.setGenre(listTagsManga(tagsArray));
                    manga.setTitle(titleManga(mangaAttributes));
                    manga.setMangaId(mangaID);
                    manga.setDescription(descriptionManga(mangaAttributes));
                    manga.setAvailibleLanguage(languageManga(mangaAttributes));

                    addManga(manga);

                });
            } else {
                System.out.println("ERROR AL CONSUMIR");
                return List.of();
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection(urlBuilt).getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {

            stringBuilder.append(line);
        }
        reader.close();
        return stringBuilder;
    }

    private HttpsURLConnection urlConnection(String urlBuilt) throws IOException {
        URL url = new URL(urlBuilt);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection;
    }

   protected List<Chapter> searchByChapter(String mangaId, String languageIndex) {

        this.urlBuilt=BASE_URL_CHAPTER.concat(mangaId).concat(languageChaper).concat(languageIndex).concat(chapterLimitation).concat(String.valueOf(offset));

        try {
            int code = urlConnection(urlBuilt).getResponseCode();

            if (code == HttpsURLConnection.HTTP_OK) {
                StringBuilder stringBuilder = getStringBuilder();

                JsonObject responseObject = JsonParser.parseString(stringBuilder.toString()).getAsJsonObject();
                JsonArray dataArray = responseObject.getAsJsonArray("data");

                dataArray.forEach(jsonElement -> {
                    JsonObject singleChapter = jsonElement.getAsJsonObject();
                    String chapterId = singleChapter.has("id")&&!singleChapter.get("id").isJsonNull()
                            ?singleChapter.get("id").getAsString()
                            :"No Id avalable";

                    JsonObject attributes = singleChapter.getAsJsonObject("attributes");



                  /*  String chapterId = attributes.has("id")&&!attributes.get("id").isJsonNull()
                    ?attributes.get("id").getAsString()
                            :"No Id avalable";*/


                    String numChapter = attributes.has("chapter") && !attributes.get("chapter").isJsonNull()
                            ? attributes.get("chapter").getAsString()
                            : "No numeracion para el capitulo";

                    String titleChapter = attributes.has("title") && !attributes.get("title").isJsonNull()
                            ? attributes.get("title").getAsString()
                            : "Capitulo - " +numChapter;

                    String chapterLanguages = attributes.has("translatedLanguage") && !attributes.get("translatedLanguage").isJsonNull()
                            ? attributes.get("translatedLanguage").getAsString()
                            : "sin idioma";

                    String chapterUrl = attributes.has("externalUrl") && !attributes.get("externalUrl").isJsonNull()
                            ? attributes.get("externalUrl").getAsString()
                            : "No externa url";

                    Chapter chapterModel = new Chapter();

                    chapterModel.setChapterId(chapterId);
                    chapterModel.setTitle(titleChapter);
                    chapterModel.setNumChapter(numChapter);
                    chapterModel.setAvailibleLanguage(chapterLanguages);
                    chapterModel.setExternalUrl(chapterUrl);

                    addMangaChapter(chapterModel);


                });

            } else {

                System.out.println("No Chapter");
                return List.of();
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return getChapterList();
    }

    List<Page>gettingPages(String chapterID){

        this.urlBuilt= BASE_URL_MANGA.concat(chapterID);

        try {
            int code = urlConnection(urlBuilt).getResponseCode();

            if (code == HttpsURLConnection.HTTP_OK) {
                StringBuilder stringBuilder = getStringBuilder();

                JsonObject objectPage= JsonParser.parseString(stringBuilder.toString()).getAsJsonObject();
                JsonObject hashDataObject=objectPage.get("chapter").getAsJsonObject();
                JsonArray arrayDataPage = objectPage.get("data").getAsJsonArray();
                JsonArray arrayDataSaverPage=objectPage.get("dataSaver").getAsJsonArray();
                List<String> dataList=new ArrayList<>();
                List<String> dataSaverList=new ArrayList<>();
                arrayDataPage.forEach(JsonElement ->{

                    dataList.add(JsonElement.getAsString());

                });

                arrayDataSaverPage.forEach(JsonElement->{

                    dataSaverList.add(JsonElement.getAsString());

                });

                Page pageModel = new Page();

                pageModel.setBaseUrl(objectPage.get("baseUrl").getAsString());
                pageModel.setHash(hashDataObject.get("hash").getAsString());
                pageModel.setDataList(dataList);
                pageModel.setDataServerList(dataSaverList);

                addMangaPage(pageModel);


            }}catch (Exception exception){

            throw new RuntimeException(exception);
        }

        return getPageList();
    }
}
