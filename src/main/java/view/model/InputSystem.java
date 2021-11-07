package view.model;

import java.util.Scanner;

import utility.Assert;

public final class InputSystem {

	private final GuidePrinter guidePrinter;
	private final Scanner scanner;

	private InputSystem(GuidePrinter guidePrinter, Scanner scanner) {
		Assert.notNull(scanner, "'scanner' must not be null");
		Assert.notNull(guidePrinter, "'guidePrinter' must not be null");
		this.guidePrinter = guidePrinter;
		this.scanner = scanner;
	}

	public static InputSystem of(GuidePrinter guidePrinter, Scanner scanner) {
		return new InputSystem(guidePrinter, scanner);
	}

	public String input() {
		guidePrinter.print();
		return scanner.nextLine();
	}
}
