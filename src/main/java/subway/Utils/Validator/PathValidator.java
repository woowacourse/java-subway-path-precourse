package subway.Utils.Validator;

import subway.Utils.Constants;
import subway.domain.StationRepository;

public class PathValidator {
	private final String name1;
	private final String name2;

	public PathValidator(String name1, String name2) {
		this.name1 = name1;
		this.name2 = name2;
		validate();
	}

	private void validate() {
		isStation(name1);
		isStation(name2);
		isSameName();
	}

	private void isStation(String name) {
		StationRepository.getStation(name);
	}

	private void isSameName() {
		if (name1.equals(name2)) {
			throw new IllegalArgumentException(Constants.ERROR_SAME_NAME);
		}
	}
}
