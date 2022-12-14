package telran.messages;

public class EmailMessage implements Message{
	//Usage: telran@java.com
	private static final String regex = "^(?=.{1,64}@)[\\p{L}0-9\\+_-]+(\\.[\\p{L}0-9\\+_-]+)*@{0}"
	        + "[^-][\\p{L}0-9\\+-]+(\\.[\\p{L}0-9\\+-]+)*(\\.[\\p{L}]{2,})$";
	String emailAddress;

	@Override
	public void send(String text) {
		System.out.printf("email message '%s' has been sent to email address %s\n", text, emailAddress );

	}

	public EmailMessage(String emailAddress) {
		
		this.emailAddress = emailAddress;
	}

	@Override
	public String getRegex() {
		
		return regex;
	}

}