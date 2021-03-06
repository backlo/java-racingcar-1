package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<Car> cars;

    public GameResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> racingResult() {
        int maxDistance = 0;
        maxDistance = compareMaxDistance(this.cars, maxDistance);

        return getWinners(cars, maxDistance);
    }

    private int compareMaxDistance(List<Car> cars, int maxDistance) {
        for (Car car : cars) {
            maxDistance = car.comparePosition(maxDistance);
        }
        return maxDistance;
    }

    private List<String> getWinners(List<Car> cars, int maxDistance) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            winners = checkMaxPosition(car, winners, maxDistance);
        }

        return winners;
    }

    private List<String> checkMaxPosition(Car car, List<String> winners, int maxDistance) {
        if (car.matchPosition(maxDistance)) {
            winners.add(car.getName());
        }

        return winners;
    }

}
