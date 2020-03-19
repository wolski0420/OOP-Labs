package agh.cs.lab4;
import java.util.ArrayList;
import java.util.HashMap;

public class RectangularMap implements IWorldMap{
    private Vector2d startMap;
    private Vector2d endMap;

    private ArrayList<Animal> listOfAnimals;
    private HashMap<Vector2d,Animal> map;

    /** konstruktory */

    public RectangularMap(){
        this.map=new HashMap<>();
        this.listOfAnimals=new ArrayList<>();
        this.startMap=new Vector2d(0,0);
        this.endMap=new Vector2d(4,4);              // przykladowe dane dla zwyklego konstruktora
    }

    public RectangularMap(int width, int height){
        this.map=new HashMap<>();
        this.listOfAnimals=new ArrayList<>();
        this.startMap=new Vector2d(0,0);
        this.endMap=new Vector2d(width,height);
    }

    /** metody */

    public String toString(){ return new MapVisualizer(this).draw(startMap,endMap); }

    @Override
    public boolean canMoveTo(Vector2d position){ return position.follows(startMap) && position.precedes(endMap) && !isOccupied(position); }

    @Override
    public boolean place(Animal animal){

        if (animal.getPosition()==null){                        // kiedy zwierze nie ma okreslonej pozycji
            boolean to_continue=true;
            int x=0;
            int y=0;

            while(y<=endMap.y && to_continue){
                x=0;
                while(x<=endMap.x && to_continue){
                    if(canMoveTo(new Vector2d(x,y))) to_continue=false;
                    else x++;
                }
                if(to_continue) y++;
            }

            if(!to_continue) {                                  // jezeli znalazlo to wrzuca
                animal.setPosition(new Vector2d(x,y));

                this.map.put(animal.getPosition(),animal);
                this.listOfAnimals.add(animal);

                return true;
            }
            else return false;                                  // a jak nie to trudno

        }

        if (this.canMoveTo(animal.getPosition())){              // kiedy ma okreslona pozycje i moze tam zostac
            map.put(animal.getPosition(),animal);
            listOfAnimals.add(animal);

            return true;

        }

        return false;
    }

    @Override
    public void run (MoveDirection[] directions){
        if (directions==null) {
            System.out.println("Brak ruchow!");
            return;
        }

        for(int i=0; i<directions.length; i++){
            map.remove(listOfAnimals.get(i%listOfAnimals.size()).getPosition());
            listOfAnimals.get(i%listOfAnimals.size()).move(directions[i]);
            map.put(listOfAnimals.get(i%listOfAnimals.size()).getPosition(),listOfAnimals.get(i%listOfAnimals.size()));
        }
    }

    @Override
    public boolean isOccupied(Vector2d position){ return this.map.containsKey(position); }

    @Override
    public Object objectAt(Vector2d position){
        return this.map.get(position);
    }
}


