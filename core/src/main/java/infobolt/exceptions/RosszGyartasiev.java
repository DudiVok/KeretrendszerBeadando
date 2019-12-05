package infobolt.exceptions;

import java.time.LocalDate;

public class RosszGyartasiev extends Exception {
    public RosszGyartasiev(LocalDate releaseDate) {
        super(releaseDate.toString());
    }
}
