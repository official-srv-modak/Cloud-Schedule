import java.io.File;
import java.util.ArrayList;

public abstract class AutoInput {

	static String pathServer=Main.pathServer;
	static String pathVm=Main.pathVm;
	static int numServer=Main.numServer, numVm=Main.numVm;
	private static ArrayList <VmClass> autoInputVm(int num, long ram, long processor, long diskspace, long chp, long p)

    {
            numVm=num;
            ArrayList <VmClass> v=new ArrayList<VmClass>(numVm);
            for(int i=0; i<numVm; i++)
            {
                VmClass temp=new VmClass();
                temp.addConf(ram, processor, diskspace);
                if(chp==0)
                    temp.priority=10;
                else
                {
                    temp.priority=(int)p;
                }
                v.add(i, temp);
                
            }
        return v;
    }
	private static ArrayList<ServerClass> autoInputServer(int num, long ram, long processor, long diskspace)
    {
            numServer=num; 
            ArrayList<ServerClass> s=new ArrayList<ServerClass>(numServer);
            for(int i=0; i<numServer; i++)
            {
                ServerClass temp=new ServerClass();
                temp.addConf(ram, processor, diskspace);
                s.add(i, temp);
            }
         return s;
    }
	public static void autoInput(int chs, int chr, int num, int chp, int p, long ram, long processor, long disk)
    {
    	FileSystemConnection.createDirectories();    ////CREATE THE FOLDER DIRECTORIES WITH RESPECT TO DEFINATIVE AND ORGANISED STRUCTURE
                
        int flag=chs;
        int ch=chr;
        if(ch==1)                            // remove and use proper branching statements
        {
  //----------------------------------------------------------------------------------------------------------------------------
            ArrayList<ServerClass> output=FileSystemConnection.readServerDetails(new File(pathServer)); //read from server file
            //output is an array list of server which contains the server instances, can be 
            //invoked by .get() method, with proper index and the corresponding config. can be
            //invoked by .getConf() function in the ServerClass;
  //----------------------------------------------------------------------------------------------------------------------------
            for(int i=0; i<output.size(); i++)
                System.out.println(output.get(i).getConf());         ////////////   VERY IMPORTANT
        } 
        else if (ch==2)
        {
 //----------------------------------------------------------------------------------------------------------------------------
            ArrayList<VmClass> output=FileSystemConnection.readVmDetails(new File(pathVm));              // read from vm file
            //output is an array list of VM which contains the server instances, can be 
            //invoked by .get() method, with proper index and the corresponding config. can be
            //invoked by .getConf() function in the VmClass;
 //----------------------------------------------------------------------------------------------------------------------------

            for(int i=0; i<output.size(); i++)
                System.out.println(output.get(i).getConf()+" Priority==>"+output.get(i).priority);         ////////////   VERY IMPORTANT
        }
        else if(ch==3)
        {
            ClusterVmPriorty.clusterVm(FileSystemConnection.readVmDetails(new File(pathVm)));
        }
        else
        {
            if(flag==0)
            {
                ArrayList <ServerClass> s=autoInputServer(num, ram, processor, disk);			//**************
                File file=FileSystemConnection.createNewFile(pathServer);            //to write in server file
                pathServer=file.getAbsolutePath();
                FileSystemConnection.writeServerDetails(file, s); 
                 
            }
            else if (flag==1)
            {
                ArrayList <VmClass> v=autoInputVm(num, ram, processor, disk, chp, p);					//**************
                File file=FileSystemConnection.createNewFile(pathVm);                // to write in vm file
                pathVm=file.getAbsolutePath();
                FileSystemConnection.writeVmDetails(file, v);
            }
            else
                System.out.println("Illegal input");
         }
    }
}
