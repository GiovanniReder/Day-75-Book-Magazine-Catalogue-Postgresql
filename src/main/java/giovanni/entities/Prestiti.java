package giovanni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")

public class Prestiti  {
    @Id
    private Catalogo elementoPrestato;

    private Utenti utente;

    private LocalDate inizioPrestito;

    private LocalDate restituzionePrevista;

    private LocalDate restituzioneEffettiva;

    public Prestiti(){}

    public Prestiti(Utenti utente, Catalogo elementoPrestato, LocalDate inizioPrestito,  LocalDate restituzionePrevista , LocalDate restituzioneEffettiva  ) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.inizioPrestito = inizioPrestito;
        this.restituzionePrevista = restituzionePrevista;
        this.restituzioneEffettiva = inizioPrestito.plusDays(30) ;
    }

    public Catalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Catalogo elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getRestituzioneEffettiva() {
        return restituzioneEffettiva;
    }

    public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
        this.restituzioneEffettiva = restituzioneEffettiva;
    }

    public LocalDate getRestituzionePrevista() {
        return restituzionePrevista;
    }

    public void setRestituzionePrevista(LocalDate restituzionePrevista) {
        this.restituzionePrevista = restituzionePrevista;
    }

    public LocalDate getInizioPrestito() {
        return inizioPrestito;
    }

    public void setInizioPrestito(LocalDate inizioPrestito) {
        this.inizioPrestito = inizioPrestito;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Prestiti{" +
                "elementoPrestato=" + elementoPrestato +
                ", utente=" + utente +
                ", inizioPrestito=" + inizioPrestito +
                ", restituzionePrevista=" + restituzionePrevista +
                ", restituzioneEffettiva=" + restituzioneEffettiva +
                '}';
    }
}
