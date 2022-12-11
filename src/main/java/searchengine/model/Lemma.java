package searchengine.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lemma")
public class Lemma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name = "lemma_id")
    private Set<SearchIndex> searchIndices;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "site_id")
    private SiteInfo siteId;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String lemma;

    @Column(nullable = false)
    private int frequency;

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

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Set<SearchIndex> getSearchIndices() {
        return searchIndices;
    }

    public void setSearchIndices(Set<SearchIndex> searchIndices) {
        this.searchIndices = searchIndices;
    }

    @Override
    public String toString() {
        return "Lemma{" +
                "id=" + id + System.lineSeparator() +
                "siteID=" + siteId.getId() + System.lineSeparator() +
                "lemma=" + lemma + System.lineSeparator() +
                "frequency=" + frequency +
                '}';
    }
}
