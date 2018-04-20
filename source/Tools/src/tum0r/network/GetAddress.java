package tum0r.network;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class GetAddress {
	public static String[] getAddress() {
		try {
			Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
			List<List<String>> list = new ArrayList<>();
			while (networkInterfaces.hasMoreElements()) {
				NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
				List<String> temp = new ArrayList<>();
				temp.add(networkInterface.getName());
				temp.add(networkInterface.getDisplayName());
				temp.add(networkInterface.getInterfaceAddresses().toString());
				list.add(temp);
			}
			String[] result = new String[list.size()];
			Iterator<List<String>> out = list.iterator();
			int count = 0;
			while (out.hasNext()) {
				Iterator<String> in = out.next().iterator();
				StringBuilder stringBuilder = new StringBuilder();
				while (in.hasNext()) {
					stringBuilder.append(in.next()).append(" ");
				}
				result[count] = stringBuilder.toString().trim();
				count++;
			}
			return result;
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return null;
	}
}
