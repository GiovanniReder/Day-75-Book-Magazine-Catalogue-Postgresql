package giovanni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "utenti")

public class Utenti {
    @Id
    @GeneratedValue
    private long numeroTessera;

    private String nome;

    private String cognome;

    private LocalDate dataDiNascita;

    public Utenti (){}

    public Utenti( LocalDate dataDiNascita, String nome, String cognome) {
        this.dataDiNascita = dataDiNascita;
        this.nome = nome;
        this.cognome = cognome;
    }


    public long getNumeroTessera() {
        return numeroTessera;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Utenti{" +
                "numeroTessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
