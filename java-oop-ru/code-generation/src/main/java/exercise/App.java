package exercise;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) throws Exception {
        String jsonRepresentation = car.serialize();
        Files.writeString(path, jsonRepresentation, StandardOpenOption.WRITE);
    }

    public static Car extract(Path path) throws Exception {
        String jsonRepresentation = Files.readString(path);
        return Car.unserialize(jsonRepresentation);
    }
}
// END
