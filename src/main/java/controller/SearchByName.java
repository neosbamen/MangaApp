package controller;
import model.MangaModel;
import java.util.List;

public class SearchByName extends MangaManager {

    @Override
    public List<MangaModel> searchMangaByName(String name) {
        return super.searchMangaByName(name);
    }




    /*@Override
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
                    JsonArray mangaTags=mangaAttributes.getAsJsonArray("tags");
                    List<String>  tagsList= new ArrayList<>();

                    for (JsonElement element:mangaTags){

                        JsonObject tagObject= element.getAsJsonObject();
                        JsonObject tagAttributes=tagObject.getAsJsonObject("attributes");
                        JsonObject tagName=tagAttributes.getAsJsonObject("name");
                        Set<String> names=tagName.keySet();
                        String fileName="";
                        for (String nameEachTag: names){

                        fileName=tagName.get(nameEachTag).getAsString();

                        tagsList.add(fileName);
                        }
                    }

                    String mainTitle="";
                    JsonObject mangaTitle= mangaAttributes.get("title").getAsJsonObject();

                   Set<String> titleElement =mangaTitle.keySet();
                    for (String element: titleElement){
                        mainTitle=mangaTitle.get(element).getAsString();
                    }

                    JsonObject mangaDescription=mangaAttributes.getAsJsonObject("description");
                    Set<String> descriptions=mangaDescription.keySet();
                    String descriptionFound="No description";

                    for (String element:descriptions){

                        descriptionFound=mangaDescription.get(element).getAsString();

                    }

                    JsonArray languages = mangaAttributes.getAsJsonArray("availableTranslatedLanguages");
                    List<String>  languagesList= new ArrayList<>();

                    for (JsonElement element:languages){

                        languagesList.add(element.getAsString());
                    }

                    String mangaID= mangaObject.get("id").getAsString();
                    String mangaGenre="shsfdgsf";

                    MangaDTO mangaDTO= new MangaDTO(mainTitle,languagesList,tagsList,mangaID,descriptionFound);
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
    }*/

    /* @Override
   public List<ChapterDTO> searchByChapter(String mangaId, String languageIndex) {

        int offset = 0;
        String baseUrl="https://api.mangadex.org/chapter?manga=";
        String languages="&translatedLanguage[]=".concat(languageIndex);
        String baseLimit="&limit=10&offset=";
        String offsetCasted= Integer.toString(offset);
        String urlBuilt = baseUrl.concat(mangaId).concat(languages).concat(baseLimit).concat(offsetCasted);

        try {
            URL url = new URL(urlBuilt);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode()== HttpURLConnection.HTTP_OK){

                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {

                    stringBuilder.append(line);
                }
                reader.close();

                JsonObject chapterObject= JsonParser.parseString(stringBuilder.toString()).getAsJsonObject();
                JsonArray chapterArray= chapterObject.get("data").getAsJsonArray();

                chapterArray.forEach(jsonElement -> {
                    JsonObject singleChapter = jsonElement.getAsJsonObject();
                    JsonObject attributes = singleChapter.getAsJsonObject("attributes");

                    String chaperId = singleChapter.has("id") && !singleChapter.get("id").isJsonNull()
                            ? singleChapter.get("id").getAsString()
                            : "Sin Numero ID";

                    String titleChapter = attributes.has("title") && !attributes.get("title").isJsonNull()
                            ? attributes.get("title").getAsString()
                            : "sin titulo";

                    String numChapter = attributes.has("chapter") && !attributes.get("chapter").isJsonNull()
                            ? attributes.get("chapter").getAsString()
                            : "No numeracion para el capitulo";

                    String chapterLanguages = attributes.has("translatedLanguage") && !attributes.get("translatedLanguage").isJsonNull()
                            ? attributes.get("translatedLanguage").getAsString()
                            : "sin idioma";

                    String chapterUrl = attributes.has("externalUrl") && !attributes.get("externalUrl").isJsonNull()
                            ? attributes.get("externalUrl").getAsString()
                            : "No externa url";

                    ChapterDTO chapterDTO = new ChapterDTO(titleChapter,numChapter,chapterLanguages,chaperId,chapterUrl);
                    addMangaChapter(chapterDTO);
                });
            }else {
                throw new RuntimeException("Error");
            }

        }catch (Exception exception){

            throw new RuntimeException(exception.getMessage());
        }
        return getChapterList();
    }*/

   /* @Override
    public List<PageDTO> gettingPages(String chapterID) {
        return List.of();
    }*/
}
