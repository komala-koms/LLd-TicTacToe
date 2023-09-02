public class Player 
{
	private int id;
	private String name;
	private int Symbol;
	
	public Player()
	{
		
	}
	public Player(int id, String name, int symbol) {
		super();
		this.id = id;
		this.name = name;
		this.Symbol = symbol;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSymbol() {
		return Symbol;
	}
	public void setSymbol(int symbol) {
		Symbol = symbol;
	}
}
