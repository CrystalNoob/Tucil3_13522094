import CLI.CLI;

public class Main {
	public static void main(String[] args) {
		if (args.length < 4) {
			System.out.println("Usage: Main <algorithm> <PathToDictionary> <startWord> <goalWord>");
			System.exit(1);;
		}

		try {
			CLI c = new CLI();
			c.start(args);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
