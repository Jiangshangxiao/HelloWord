package com.JSXExercise.homework.homework16;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class VehiclesFactory {
    public static Horse horse = new Horse();
    private VehiclesFactory() {}
    public static Horse getHorse() {
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }
}
