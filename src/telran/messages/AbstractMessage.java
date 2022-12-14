package telran.messages;

public abstract class AbstractMessage implements Message{
	protected String regex;
	
	@Override
	public String getRegex() {
		
		return regex;
	}
}
