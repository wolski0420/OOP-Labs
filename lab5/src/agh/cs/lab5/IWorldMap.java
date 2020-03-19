
package agh.cs.lab5;

/**
 * The interface responsible for interacting with the mapOfAnimals of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo
 *
 */
public interface IWorldMap {
    /**
     * Indicate if any object can move to the given position.
     *
     * @param position
     *            The position checked for the movement possibility.
     * @return True if the object can move to that position.
     */
    boolean canMoveTo(Vector2d position);

    /**
     * Place a animal on the mapOfAnimals.
     *
     * @param animal
     *            The animal to place on the mapOfAnimals.
     * @return True if the animal was placed. The animal cannot be placed if the mapOfAnimals is already occupied.
     */
    boolean place(Animal animal);

    /**
     * Move the animal on the mapOfAnimals according to the provided move directions. Every
     * n-th direction should be sent to the n-th animal on the mapOfAnimals.
     *
     * @param directions
     *            Array of move directions.
     */
    void run(MoveDirection[] directions);

    /**
     * Return true if given position on the mapOfAnimals is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position
     *            Position to check.
     * @return True if the position is occupied.
     */
    boolean isOccupied(Vector2d position);

    /**
     * Return an object at a given position.
  0   *
     * @param position
     *            The position of the object.
     * @return Object or null if the position is not occupied.
     */
    Object objectAt(Vector2d position);
}
