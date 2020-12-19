package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import view.InputView;
import view.OutputView;

enum MainButton {
	LOOK_UP("1"),SYSTEM_OUT("Q");
	
	private final String button;
	
	MainButton(String button){
		this.button = button;
	}
	
	public String getButton() {
		return button;
	}
}

public class MainManagement {
	private static final List<String> menu = Arrays.asList(
		MainButton.LOOK_UP.getButton(),
		MainButton.SYSTEM_OUT.getButton()
	);
	
	public static void execute() {
		OutputView.printMainScreen();
		String function = InputView.selectFunction();
		proceduresExecute(function);
	}
	
	public static void proceduresExecute(String input) {
		if (input.equals(MainButton.SYSTEM_OUT.getButton())) {
			return;
		}
		else if (input.equals(MainButton.LOOK_UP.getButton())) {
			RouteManagement.execute();
		}
	}
}
