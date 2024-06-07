package giovanni.entities;

import giovanni.enums.Periodicita;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Entity

public class Riviste extends Catalogo{

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Riviste(){}

    public Riviste(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public Riviste( Integer numeroPagine, Integer annoPubblicazione, String titolo, Periodicita periodicita) {
        super( numeroPagine, annoPubblicazione, titolo);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "titolo='" + getTitolo() + '\'' +
                ", periodicita=" + periodicita +
                ", ISBN='" + getISBN() + '\'' +
                ", numero di pagine='" + getNumeroPagine() + '\'' +
                ", anno di pubblicazione='" + getAnnoPubblicazione() + '\'' +
                '}';
    }
}


