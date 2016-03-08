package arun.problems.ds;

public class IP {

	public static void main(String a[]) {
		checkIpSubnetMask("10.238.45.104", "255.255.192.0");
	}
	
	 public static long getIpaddrInLong(final String ipAddr) {
	        long ipAddrIntVal = 0;
            final String[] addrArray = ipAddr.split("\\.");
            for (int i = 0; i < addrArray.length; i++) {
                final int power = 3 - i;
                ipAddrIntVal += ((Integer.parseInt(addrArray[i]) % 256 * Math.pow(256, power)));
            }
	        return ipAddrIntVal;
	    }
	 
	 public static boolean checkIpSubnetMask(final String ipAddress, 
             								 final String netmask) {
		 long ipaddressLong = getIpaddrInLong(ipAddress);
		 long netmaskLong = getIpaddrInLong(netmask);
		 return (ipaddressLong & netmaskLong) != 0;
	 }
}
