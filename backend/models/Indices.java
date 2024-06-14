package models;

public record Indices(int id, String nomIndices, int nombreMots) {
    @Override
    public final String toString() {
        return String.format("{id=%d, nomIndices='%s', nombreMotes='%d'}", id, nomIndices, nombreMots);
    }

    public void setId(int id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
