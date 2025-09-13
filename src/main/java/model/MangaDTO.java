package model;

public class MangaDTO {

    private String title;
    private String availibleLanguage;
    private String genre;
    private String mangaId;
    private String descrption;

    public MangaDTO(String title,String availibleLanguage, String genre, String mangaId, String descrption){

        this.title=title; this.availibleLanguage=availibleLanguage; this.genre=genre; this.mangaId=mangaId; this.descrption=descrption;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvailibleLanguage() {
        return availibleLanguage;
    }

    public void setAvailibleLanguage(String availibleLanguage) {
        this.availibleLanguage = availibleLanguage;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMangaId() {
        return mangaId;
    }

    public void setMangaId(String mangaId) {
        this.mangaId = mangaId;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }
}
