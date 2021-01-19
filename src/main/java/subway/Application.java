package subway;

import subway.controller.MainController;
import subway.domain.SubwayMap;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO: 프로그램 구현
		OutputView.printMainScreen();
		MainController.run(scanner);
	}
}
