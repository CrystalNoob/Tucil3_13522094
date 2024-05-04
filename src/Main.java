import CLI.CLI;

public class Main {
	public static void main(String[] args) throws Exception {
        CLI c = new CLI();
        if (args.length < 4) {
            System.out.println("Usage: Main <algorithm> <PathToDictionary> <startWord> <goalWord>");
            System.exit(1);;
        }
        c.start(args);
    }
}
