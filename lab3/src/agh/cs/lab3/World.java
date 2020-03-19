package agh.cs.lab3;

import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
        // tworzenie zwierzaka
        Animal anAnimal = new Animal();

        //wczytywanie ruchow
        OptionsParser methodToParse = new OptionsParser();
        ArrayList<MoveDirection> moves = methodToParse.parser(args);

        //wykonanie ruchow
        System.out.println(anAnimal.toString());
        for(int i=0; i<moves.size(); i++){
            anAnimal.move(moves.get(i));
            System.out.println(anAnimal.toString());
        }
    }
}

