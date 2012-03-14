package editool.tool;


import java.net.InetAddress;


public class HostName
{

	public static String getHostName()
	{
		String str = null;

		try
		{
			str = InetAddress.getLocalHost().getHostName();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return str;

	}

}
