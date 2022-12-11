package searchengine.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "page")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name = "page_id")
    private Set<SearchIndex> searchIndices;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "site_id")
    private SiteInfo siteId;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String path;

    @Column(nullable = false)
    private int code;

    @Column(nullable = false, columnDefinition = "MEDIUMTEXT")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SiteInfo getSiteId() {
        return siteId;
    }

    public void setSiteId(SiteInfo siteId) {
        this.siteId = siteId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<SearchIndex> getSearchIndices() {
        return searchIndices;
    }

    public void setSearchIndices(Set<SearchIndex> searchIndices) {
        this.searchIndices = searchIndices;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id + System.lineSeparator() +
                "siteID=" + siteId.getId() + System.lineSeparator() +
                "path=" + path + System.lineSeparator() +
                "code=" + code + System.lineSeparator() +
                "content=" + content +
                '}';
    }
}
