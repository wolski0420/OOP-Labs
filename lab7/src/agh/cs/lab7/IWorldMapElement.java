package agh.cs.lab7;

public interface IWorldMapElement {
    // zwraca pozycje elementu na mapie
    Vector2d getPosition();

    // zwraca reprezentacje obiektu na mapie
    String toString();
}
