package models;

public record Mots(int id, String nomMots) {
    @Override
    public final String toString() {
        return String.format("{id=%d, nomMots='%s'}", id, nomMots);
    }

    public void setId(int id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
