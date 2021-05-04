package pl.skiba.tekkenrankings.polskipunish.models.WebsiteModels;

import javax.persistence.*;

@Entity
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private String url;
    private boolean highlighted = false;

    public PostModel(String title, String text, String url, boolean highlighted) {
        this.title = title;
        this.text = text;
        this.url = url;
        this.highlighted = highlighted;
    }

    public PostModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isHighlighted() {
        return highlighted;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }
}
