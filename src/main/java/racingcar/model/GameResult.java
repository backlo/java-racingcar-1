package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    public static List<String> racingResult(List<Car> cars) {
        int maxDistance = 0;
        maxDistance = compareMaxDistance(cars, maxDistance);

        return getWinners(cars, maxDistance);
    }

    private static int compareMaxDistance(List<Car> cars, int maxDistance) {
        for (Car car : cars) {
            maxDistance = car.comparePosition(maxDistance);
        }
        return maxDistance;
    }

    private static List<String> getWinners(List<Car> cars, int maxDistance) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            winners = checkMaxPosition(car, winners, maxDistance);
        }

        return winners;
    }

    private static List<String> checkMaxPosition(Car car, List<String> winners, int maxDistance) {
        if (car.matchPosition(maxDistance)) {
            winners.add(car.getName());
        }

        return winners;
    }

}
