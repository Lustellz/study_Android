import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class NetworkParameter2_for_InetAddress {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Enumeration<NetworkInterface> en =NetworkInterface.getNetworkInterfaces();
		while(en.hasMoreElements()) {
			NetworkInterface ni = en.nextElement();
			printParameter(ni);
		}
		
	}
	
	public static void printParameter(NetworkInterface ni) throws SocketException
			{
				Enumeration<InetAddress> addresses = ni.getInetAddresses();
				
				while (addresses.hasMoreElements()) {
					InetAddress inetAddress = (InetAddress) addresses.nextElement();
					System.out.println("Name = "+ni.getName());
					System.out.println("Display Name = "+ni.getDisplayName());
					System.out.println("Host Address = "+inetAddress.getHostAddress());
					System.out.println("Support multicast = "+inetAddress.getHostName());
				
					if(inetAddress instanceof Inet4Address)
						System.out.println("IP Address: IPv4");
					else
						System.out.println("IP Address: IPv6");
					System.out.println("");
				}
			}

}
