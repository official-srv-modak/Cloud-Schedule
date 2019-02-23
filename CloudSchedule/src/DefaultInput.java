import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public interface DefaultInput {
	
	public static void defaultServerInput()
	{
		try
		{
			File file=FileSystemConnection.createNewFile("BACKUP/Default Server Input.txt");
			//File file=new File("BACKUP/Default Server Input.txt");			//didn't use the FileSystemConnection because it is not for creating file
			BufferedReader buff=new BufferedReader(new FileReader(file));
			System.out.println("Getting input automatically from "+file.getAbsolutePath());
			String readLine;
			ArrayList<Long> arr=new ArrayList<Long>();
			for(int i=0; (readLine=buff.readLine())!=null; i++)
			{
				if(readLine==""|| readLine==" ")
					break;
				arr.add(Long.parseLong(readLine));
			}
			long chs=arr.get(0);
			long chr=arr.get(1);
			long num=arr.get(2);
			long ram=arr.get(3);
			long processor=arr.get(4);
			long disk=arr.get(5);
			AutoInput.autoInput((int)chs, (int)chr, (int)num, 0, 0, ram, processor, disk);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Input File not found of name \"Default Server Input.txt\" in the directory "+e.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void defaultVmInput()
	{
		try
		{
			File file=FileSystemConnection.createNewFile("BACKUP/Default VM Input.txt");
			BufferedReader buff=new BufferedReader(new FileReader(file));
			System.out.println("Getting input automatically from "+file.getAbsolutePath());
			String readLine;
			ArrayList<Long> arr=new ArrayList<Long>();
			for(int i=0; (readLine=buff.readLine())!=null; i++)
			{
				if(readLine==""|| readLine==" ")
					break;
				arr.add(Long.parseLong(readLine));
				
			}
			long chs=arr.get(0);
			long chr=arr.get(1);
			long num=arr.get(2);
			long ram=arr.get(3);
			long processor=arr.get(4);
			long disk=arr.get(5);
			long chp=arr.get(6);
			long p=arr.get(7);
			AutoInput.autoInput((int)chs, (int)chr, (int)num, (int)chp, (int)p, ram, processor, disk);

		}
		catch(FileNotFoundException e)
		{
			System.out.println("Input File not found of name \"Default VM Input.txt\" in the directory "+e.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
