package exercise;

// BEGIN
class NegativeRadiusException extends Exception {

    private String errorMessage;

    NegativeRadiusException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static final NegativeRadiusException INVALID_RADIUS =
            new NegativeRadiusException("Не удалось посчитать площадь");

}
// END
