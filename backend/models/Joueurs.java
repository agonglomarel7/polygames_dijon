package models;

public record Joueurs(int id, String nomJoueur, String role) {
    @Override
    public final String toString() {
        return String.format("{id=%d, nomJoueur='%s', role='%s'}", id, nomJoueur, role);
    }

    public void setId(int id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
