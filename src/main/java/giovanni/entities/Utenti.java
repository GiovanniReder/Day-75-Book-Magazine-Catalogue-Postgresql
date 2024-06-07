package giovanni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "utenti")
public class Utenti {
    @Id
    @GeneratedValue
    private long numeroTessera;

    private String nome;

    private String cognome;

    private Date dataDiNascita;

    public Utenti (){}

    public Utenti(long numeroTessera, Date dataDiNascita, String nome, String cognome) {
        this.numeroTessera = numeroTessera;
        this.dataDiNascita = dataDiNascita;
        this.nome = nome;
        this.cognome = cognome;
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
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
