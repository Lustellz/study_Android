import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Reachable2_edited {

	
	//cf: 127.0.0.1(localhost, called roopback)
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		InetAddress thisComputer = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter names and IP addresses. Enter \"exit\" to quit.");
		try {//호스트 이름을 입력하거나 아니면 종료를 원하면, 'exit'를 입력.		
			while(true) {
				String host = in.readLine();
				if(host.equalsIgnoreCase("exit")||host.equalsIgnoreCase("quit")) {
					break;					
				}
				
				try {
					//get IP address about Host
					thisComputer = InetAddress.getByName(host);
					System.out.println(thisComputer.getHostAddress());
					//to check the regular activity status of server, wait for response message for 2 seconds maximum
					if(thisComputer.isReachable(2000))
						System.out.printf("%s is reachable \n", thisComputer.getHostName());
					else System.out.printf("%s is unreachable \n", thisComputer.getHostName());
					
					//process test using ping command, nested in Window
					
					Process p1 = Runtime.getRuntime().exec("ping -n 1" + thisComputer.getHostAddress());
					int returnVal = p1.waitFor();
					
					//if works normally, return 0
					boolean reachable = (returnVal==0);
					if(reachable) System.out.printf("%s is reachable\n", thisComputer.getHostName());
					else System.out.printf("%s is not reachable\n", thisComputer.getHostName());
				}catch(UnknownHostException e) {
					System.out.println("Cannot find host "+host);
				}
			}
		}catch(IOException e) {
		System.err.println(e);
		}
	}

}
