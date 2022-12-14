package telran.messages;
public class SmsMessage implements Message {
	//Usage: 0531231212
	private static final String regex = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";
	String phoneNumber;

	@Override
	public void send(String text) {
		System.out.printf("sms message '%s' has been sent to phone %s\n", text, phoneNumber );

	}

	public SmsMessage(String phoneNumber) {
		
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String getRegex() {
		
		return regex;
	}

}