package model;

import java.util.List;

public class MangaDTO {

    private String title;
    private List<String> availibleLanguage;
    private List<String> genre;
    private String mangaId;
    private String description;

    public MangaDTO(){}

    public MangaDTO(String title,List<String> availibleLanguage, List<String> genre, String mangaId, String description){

        this.title=title;
        this.availibleLanguage=availibleLanguage;
        this.genre=genre;
        this.mangaId=mangaId;
        this.description = description;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAvailibleLanguage() {
        return availibleLanguage;
    }

    public void setAvailibleLanguage(List<String> availibleLanguage) {
        this.availibleLanguage = availibleLanguage;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public String getMangaId() {
        return mangaId;
    }

    public void setMangaId(String mangaId) {
        this.mangaId = mangaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MangaDTO{" +
                "title='" + title + '\'' +
                ", availibleLanguage='" + availibleLanguage + '\'' +
                ", genre='" + genre + '\'' +
                ", mangaId='" + mangaId + '\'' +
                ", descrption='" + description + '\'' +
                '}';
    }
}
