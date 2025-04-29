package lab07;

public abstract class AbstractPlayer implements Player {
	protected String name;
	protected char symbol;

	public AbstractPlayer(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	public String getName() {
		return this.name;
	}

	public char getSymbol() {
		return this.symbol;
	}

}
