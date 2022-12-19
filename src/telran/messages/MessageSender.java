package telran.messages;

import telran.messagesAppl.InputOutput;

public interface MessageSender {

	public void send(InputOutput io, String message);
}
