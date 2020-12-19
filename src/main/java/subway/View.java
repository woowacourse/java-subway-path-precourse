package subway;

import java.util.Scanner;

import subway.util.Input;
import subway.util.Output;

public class View {
	private final String FIRST = "1";
	private final String SECOND = "2";
	private final String QUITE = "Q";
	private final String BACK = "B";

	private Scanner scanner;
	private String selector;
	
	public View(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void main() {
		Output.mainView();
		selector = Input.nextLine(scanner);
		moveViewBySelector(selector);
	}
	
	private void moveViewBySelector(String selector) {
		if (selector.equals(FIRST)) {
//			stationManagement();
			return;
		} else if (selector.equals(QUITE)) {
//			lineManagement();
			return;
		}
	}
		
}
