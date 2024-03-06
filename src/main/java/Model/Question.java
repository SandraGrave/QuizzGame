package Model;

public record Question(int id,
                       String categorie,
                       String type,
                       String difficulty,
                       String questionStatement) {
}
