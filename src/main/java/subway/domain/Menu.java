package subway.domain;

import java.util.Scanner;

public interface Menu {
	String getMenuName();
	String getMenuKey();
	void run(Scanner scanner);
}
