package telran.messagesAppl;

import java.lang.reflect.Constructor;
import telran.messages.MessageSender;

public class ApplicationMenu {
	static final String CLASS_REF = "telran.messages.";
	static String regex;
	static String input[] = new String[2];
	static Constructor<MessageSender> constructor;
	static MessageSender message;
public static void main(String[] args) {

		Menu menu = new Menu("Message sender", getItems());
		menu.perform(new ConsoleInputOutput());
}
	private static Item[] getItems() {
		Item[] res = {
				Item.of("Send message", ApplicationMenu::sendMessage),
				Item.exit()
		};
		return res;
	}
	
	static void sendMessage(InputOutput io) {
		Class<MessageSender> clazz  = io.readClass("Enter message type;"
				+ " usage: EmailMessage, SmsMessage, TcpMessage.", 
				"Wrong type: ", CLASS_REF);
		try {
			constructor = clazz.getConstructor();
		} catch (Exception e) {
			System.out.println("Error-1");
		}	
		io.writeObject(clazz.getName() + "\n");
		input[0] = io.readString("Enter message to be send");
		io.writeObject(input[0] + "\n");
		try {
			message = constructor.newInstance();
		} catch (Exception e) {
			System.out.println("Error-2");
		}
		message.send(io, input[0]);
}
	
}
