package model;

public class ChapterDTO {

    private String title;
    private String numChapter;
    private String availibleLanguage;
    private String chapterId;
    private String externalUrl;

    public ChapterDTO(String title, String numChapter, String availibleLanguage, String chapterId, String externalUrl) {
        this.title = title;
        this.numChapter=numChapter;
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

    public String getNumChapter() {
        return numChapter;
    }

    public void setNumChapter(String numChapter) {
        this.numChapter = numChapter;
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

    @Override
    public String toString() {
        return "ChapterDTO{" +
                "title='" + title + '\'' +
                ", numChapter='" + numChapter + '\'' +
                ", availibleLanguage='" + availibleLanguage + '\'' +
                ", chapterId='" + chapterId + '\'' +
                ", externalUrl='" + externalUrl + '\'' +
                '}';
    }
}
