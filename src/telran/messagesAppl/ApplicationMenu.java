package telran.messagesAppl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import telran.messages.Message;

public class ApplicationMenu {
	static final String CLASS_REF = "telran.messages.";
	static String regex;
	static String input[] = new String[2];
	static Constructor<Message> constructor;
	static Message message;
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
		Class<Message> clazz  = io.readClass("Enter message type", 
				"Wrong type: ", CLASS_REF);
		try {
			constructor = clazz.getConstructor(String.class);
			Field field = clazz.getDeclaredField("regex");
			field.setAccessible(true);
			Object value = field.get(clazz);
			regex = (String) value;
		} catch (Exception e) {
			System.out.println("Error");
		}	
		io.writeObject(clazz.getName() + "\n");
		input[0] = io.readString("Enter message to be send");
		io.writeObject(input[0] + "\n");
		input[1] = io.readPredicate("Enter direction message to be send", "Wrong message direction!", 
				(p) -> p.matches(regex.toString()));
		try {
			message = constructor.newInstance(input[1]);
		} catch (Exception e) {
			System.out.println("Wrong direction");
		}
		io.writeObject(input[1]+ "\n");
		message.send(input[0]);
}
	
}
