package giovanni.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Catalogo {

    @Id
    @GeneratedValue
    protected long ISBN;

    @Column(name = "titolo")
    protected String titolo;

    @Column(name = "annoPubblicazione")
    protected Integer annoPubblicazione;

    @Column(name = "numeroPagine")
    protected Integer numeroPagine;

    public Catalogo() {}

    public Catalogo(Integer numeroPagine, Integer annoPubblicazione, String titolo) {
        this.numeroPagine = numeroPagine;
        this.annoPubblicazione = annoPubblicazione;
        this.titolo = titolo;
    }


    public Integer getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(Integer numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public long getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
