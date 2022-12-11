package searchengine.model;

import javax.persistence.*;

@Entity
@Table(name = "index")
public class SearchIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "page_id")
    private Page pageId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "lemma_id")
    private Lemma lemmaId;

    @Column(nullable = false, columnDefinition = "FLOAT")
    private float rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Page getPageId() {
        return pageId;
    }

    public void setPageId(Page pageId) {
        this.pageId = pageId;
    }

    public Lemma getLemmaId() {
        return lemmaId;
    }

    public void setLemmaId(Lemma lemmaId) {
        this.lemmaId = lemmaId;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "SearchIndex{" +
                "id=" + id + System.lineSeparator() +
                "pageID=" + pageId.getId() + System.lineSeparator() +
                "lemmaID=" + lemmaId.getId() + System.lineSeparator() +
                "rank=" + rank +
                '}';
    }
}
