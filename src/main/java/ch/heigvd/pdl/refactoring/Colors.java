package ch.heigvd.pdl.refactoring;

public enum Colors {
    BLUE,
    RED,
    YELLOW,
    NO_COLOR;
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
