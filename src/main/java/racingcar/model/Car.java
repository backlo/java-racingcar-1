package racingcar.model;

import java.util.Objects;

public class Car {

    private static final int FOWARD_NUM = 4;

    private String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveCarByRandom(int randomNumber) {
        move(randomNumber);
    }

    public int comparePosition(int position) {
        if (this.position > position) {
            return this.position;
        }

        return position;
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    private void move(int randomNumber) {
        if (randomNumber >= FOWARD_NUM) {
            this.position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
