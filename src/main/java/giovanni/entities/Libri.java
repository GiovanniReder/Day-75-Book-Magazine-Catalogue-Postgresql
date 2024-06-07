package giovanni.entities;

import jakarta.persistence.Entity;


 @Entity
 public class Libri extends Catalogo{
    public String autore;
    public String genere;

    public Libri(){}

    public Libri(String autore, String genere) {
        this.autore = autore;
        this.genere = genere;
    }

    public Libri( Integer numeroPagine, Integer annoPubblicazione, String titolo, String autore, String genere) {
        super( numeroPagine, annoPubblicazione, titolo);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "titolo='" + getTitolo() + '\'' +
                ", autore='" + autore + '\'' +
                ", ISBN='" + getISBN() + '\'' +
                ", genere='" + getGenere() + '\'' +
                ", numero di pagine='" + getNumeroPagine() + '\'' +
                ", anno di pubblicazione='" + getAnnoPubblicazione() + '\'' +

                '}';
    }
}
