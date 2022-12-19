package telran.messages;

import telran.messagesAppl.InputOutput;

public class SmsMessage implements MessageSender {
	//Usage: 0531231212
	@Override
	public void send(InputOutput io, String message) {
		String phoneNumber = io.readPredicate("Enter phone number", "Phone number not correct", 
				p -> p.matches(getRegex()));
		io.writeObject(phoneNumber);
		System.out.printf("\nsms message '%s' has been sent to phone %s\n", message, phoneNumber );
		
	}

	private String getRegex() {
		String regex = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";
		return regex;
	}



}