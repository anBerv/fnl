package searchengine.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "site")
public class SiteInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name = "site_id")
    private Set<Page> pages;

    @OneToMany
    @JoinColumn(name = "site_id")
    private Set<Lemma> lemmas;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('INDEXING', 'INDEXED', 'FAILED')")
    private Status status;

    @Column(nullable = false, columnDefinition = "DATETIME", name = "status_time")
    private Date statusTime;

    @Column(columnDefinition = "TEXT", name = "last_error")
    private String lastError;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String url;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Date statusTime) {
        this.statusTime = statusTime;
    }

    public String getLastError() {
        return lastError;
    }

    public void setLastError(String lastError) {
        this.lastError = lastError;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Page> getPages() {
        return pages;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }

    public Set<Lemma> getLemmas() {
        return lemmas;
    }

    public void setLemmas(Set<Lemma> lemmas) {
        this.lemmas = lemmas;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id + System.lineSeparator() +
                "status=" + status + System.lineSeparator() +
                "statusTime=" + statusTime + System.lineSeparator() +
                "lastError=" + lastError + System.lineSeparator() +
                "url=" + url + System.lineSeparator() +
                "name=" + name +
                '}';
    }
}
