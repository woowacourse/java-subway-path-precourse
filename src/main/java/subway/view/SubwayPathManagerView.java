package subway.view;

public abstract class SubwayPathManagerView {
	private static final String TOP_MENU_PREFIX = "\n## ";
	private static final String INFO_PREFIX = "[INFO] ";
	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String MENU_LISTING_SEPARATOR = ". ";

	protected static final String FIRST_MENU = "1";
	protected static final String SECOND_MENU = "2";
	protected static final String BACK_MENU = "B";
	protected static final String QUIT_MENU = "Q";

	public abstract void print();

	public void printTopMenu(String message) {
		System.out.println(TOP_MENU_PREFIX + message);
	}

	public void printFirstMenu(String message) {
		System.out.println(FIRST_MENU + MENU_LISTING_SEPARATOR + message);
	}

	public void printSecondMenu(String message) {
		System.out.println(SECOND_MENU + MENU_LISTING_SEPARATOR + message);
	}

	public void printBackMenu(String message) {
		System.out.println(BACK_MENU + MENU_LISTING_SEPARATOR + message);
	}

	public void printQuitMenu(String message) {
		System.out.println(QUIT_MENU + MENU_LISTING_SEPARATOR + message);
	}

	public void printInfo(String message) {
		System.out.println(INFO_PREFIX + message);
	}

	public void printError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}
}
