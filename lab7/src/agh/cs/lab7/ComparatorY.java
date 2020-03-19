package agh.cs.lab7;

import java.util.Comparator;

public class ComparatorY implements Comparator {
    @Override
    public int compare(Object firstO, Object secondO){
        Vector2d first=(Vector2d) firstO;
        Vector2d second=(Vector2d) secondO;

        if(first.y < second.y) return -1;
        if(first.y > second.y) return 1;

        // jezeli nie po Y to porownuje po X
        if(first.x < second.x) return -1;
        if(first.x > second.x) return 1;
        return 0;
    }
}
