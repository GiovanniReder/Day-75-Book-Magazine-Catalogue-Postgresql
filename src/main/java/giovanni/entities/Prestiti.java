package giovanni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity


public class Prestiti {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "catalogo_id")
    private Catalogo elementoPrestato;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utenti utente;

    private LocalDate inizioPrestito;
    private LocalDate restituzionePrevista;
    private LocalDate restituzioneEffettiva;

    public Prestiti() {}

    public Prestiti(Utenti utente , Catalogo elementoPrestato , LocalDate inizioPrestito , LocalDate restituzioneEffettiva, LocalDate restituzionePrevista ) {
        this.restituzioneEffettiva = restituzioneEffettiva;
        this.restituzionePrevista = restituzionePrevista;
        this.inizioPrestito = inizioPrestito;
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Catalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Catalogo elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }

    public LocalDate getInizioPrestito() {
        return inizioPrestito;
    }

    public void setInizioPrestito(LocalDate inizioPrestito) {
        this.inizioPrestito = inizioPrestito;
    }

    public LocalDate getRestituzionePrevista() {
        return restituzionePrevista;
    }

    public LocalDate getRestituzioneEffettiva() {
        return restituzioneEffettiva;
    }

    public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
        this.restituzioneEffettiva = restituzioneEffettiva;
    }
}
