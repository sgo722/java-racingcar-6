package racingcar.domain;

public class Car {
    private final String name;
    private int position;


    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public void move(int option){
        if(option >= 4){
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
