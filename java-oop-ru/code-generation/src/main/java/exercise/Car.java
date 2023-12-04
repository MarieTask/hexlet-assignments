package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;


// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonRepresentation = mapper.writeValueAsString(this);
        return jsonRepresentation;
    }

    public static Car unserialize(String jsonRepresentation) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonRepresentation, Car.class);
    }
    // END
}
