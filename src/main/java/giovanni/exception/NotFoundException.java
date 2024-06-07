package giovanni.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Il record con l'id " + id + " non è stato trovato!");
    }
}
