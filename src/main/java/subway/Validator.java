package subway;

public class Validator {
	public static boolean isSameStation(String departureStation, String arrivalStation) {
		if (departureStation.equals(arrivalStation)) {
			return true;
		}
		return false;
	}
}
