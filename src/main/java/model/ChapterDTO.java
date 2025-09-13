package model;

public class ChapterDTO {

    private String title;
    private String availibleLanguage;
    private String chapterId;
    private String externalUrl;

    public ChapterDTO(String title, String availibleLanguage, String chapterId, String externalUrl) {
        this.title = title;
        this.availibleLanguage = availibleLanguage;
        this.chapterId = chapterId;
        this.externalUrl = externalUrl;
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

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }
}
