package telran.messages;

public class TcpMessage implements Message {
	//Usage: 250.0.199.249
	private static final String regex = getTcpRegex();
	String ipPort; //ipv4:port
	@Override
	public void send(String text) {
		System.out.printf("tcp message '%s' has been sent to ip:port %s\n", text, ipPort );

	}
	public TcpMessage(String ipPort) {
		this.ipPort = ipPort;
	}
	
	@Override
	public String getRegex() {
		
		return regex;
	}
	
	private static String getTcpRegex() {
		String ipRegex = "\\d\\d?|[0,1]\\d\\d|2[0-4]\\d|25[0-5]";
		String res = String.format("((%s)\\.){3}(%s)", ipRegex, ipRegex);
		return res;
	}

}