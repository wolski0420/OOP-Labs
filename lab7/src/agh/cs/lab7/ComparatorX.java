package agh.cs.lab7;

import java.util.Comparator;

public class ComparatorX implements Comparator {
    @Override
    public int compare(Object firstO, Object secondO){
        Vector2d first=(Vector2d)firstO;
        Vector2d second=(Vector2d)secondO;

        if(first.x < second.x) return -1;
        if(first.x > second.x) return 1;

        //jezeli nie po X to porownuje po Y
        if(first.y < second.y) return -1;
        if(first.y > second.y) return 1;
        return 0;
    }
}
