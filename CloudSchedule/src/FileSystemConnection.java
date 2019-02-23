import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * TODO: Document me!
 *
 * @author souravmodak
 *
 */
public abstract class FileSystemConnection implements Serializable {
        
    public static File data=new File ("data");
    public static File config=new File ("data/config");
    public static File cluster=new File("data/clusters");
    public static File Vm=new File("data/clusters/VM");
 
    
    public static void createDirectories()
    {
        
        if(!data.exists())
        {
            System.out.println("Creating new \""+data.getAbsolutePath()+"\" directory");
            data.mkdir();
        } 
        
        if(!config.exists())
        {
            System.out.println("Creating new \""+config.getAbsolutePath()+"\" directory");
            config.mkdir();
        }
        
        if(!cluster.exists())
        {
            System.out.println("Creating new \""+cluster.getAbsolutePath()+"\" directory");
            cluster.mkdir();
        }
        
        if(!Vm.exists())
        {
            System.out.println("Creating new \""+Vm.getAbsolutePath()+"\" directory");
            Vm.mkdir();
        }
    }
    public static File createNewFile(String path)
    {
        File file=new File(path);
       // System.out.println(file.getAbsolutePath());
        try
        {
        
            if(file.createNewFile())
                System.out.println("File Created Successfully");
            else if(file.exists())
                {
            		System.out.println("File Already exist... continuing");
            		return file;
                }
            else
            	System.out.println("Error in creating file");
        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return file;
    
    }
    
    @SuppressWarnings("unchecked")
    public static ArrayList<ServerClass> readServerDetails(File file)
    {
        ArrayList<ServerClass> returnTemp=new ArrayList<ServerClass>();
        try
        {
            FileInputStream fileIn=new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(fileIn);
            returnTemp=(ArrayList<ServerClass>)objIn.readObject();
            
            objIn.close();
            fileIn.close();
        }
        catch(FileNotFoundException e)
        {
            e.getSuppressed();
            System.out.println("File Not found in location "+e.getMessage());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return returnTemp;
    }
    
    public static ArrayList<VmClass> readVmDetails(File file)
    {
        ArrayList<VmClass> returnTemp=new ArrayList<VmClass>();
        try
        {
            FileInputStream fileIn=new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(fileIn);
            returnTemp=(ArrayList<VmClass>)objIn.readObject();
            
            objIn.close();
            fileIn.close();
        }
        catch(FileNotFoundException e)
        {
            e.getSuppressed();
            System.out.println("File Not found in location "+e.getMessage());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return returnTemp;
    }
    public static void writeServerDetails(File file, ArrayList<ServerClass> arr)
    {
        try
        {
            FileOutputStream fileOut=new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(fileOut);
            objOut.writeObject(arr);
            
            objOut.close();
            fileOut.close();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void writeVmDetails(File file, ArrayList<VmClass> arr)
    {
        try
        {
            FileOutputStream fileOut=new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(fileOut);
            objOut.writeObject(arr);
            
            objOut.close();
            fileOut.close();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
