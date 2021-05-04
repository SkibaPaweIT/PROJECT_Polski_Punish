package pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels;

public class PostModelDTO {

    private String title;
    private String text;
    private String url;

    public PostModelDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
