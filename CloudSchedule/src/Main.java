import java.io.File;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * TODO: Document me!
 *
 * @author souravmodak
 *
 */
public class Main implements Serializable {

    /**
     * @param args
     */
	
	public static String pathServer="data/config/Server.dat";
    public static String pathVm="data/config/VM.dat";
    
    static Scanner scan=new Scanner (System.in);
    public static DecimalFormat NumFormat=new DecimalFormat("#");
    public static int numServer, numVm;
    public static ArrayList<ServerClass> inputServer()
    {
        long ram, processor, diskspace;
        
            System.out.println("How many servers?");
            numServer=scan.nextInt();
            //ServerClass s[]=new ServerClass[numServer]; 
            ArrayList<ServerClass> s=new ArrayList<ServerClass>(numServer);
            for(int i=0; i<numServer; i++)
            {
                ServerClass temp=new ServerClass();
                System.out.println("Enter the ram for server "+(i+1));
                ram=scan.nextLong();
                System.out.println("Enter the processor for server "+(i+1));
                processor=scan.nextLong();
                System.out.println("Enter the Disk Space for server "+(i+1));
                diskspace=scan.nextLong();
                temp.addConf(ram, processor, diskspace);
                s.add(i, temp);
            }
         return s;
    }
   
    public static ArrayList <VmClass> inputVm()

    {
        long ram, processor, diskspace;
            System.out.println("How many VM's?");
            numVm=scan.nextInt();
           // VmClass[] v=new VmClass[numVm]; 
            ArrayList <VmClass> v=new ArrayList<VmClass>(numVm);
            for(int i=0; i<numVm; i++)
            {
                VmClass temp=new VmClass();
                System.out.println("Enter the ram for VM "+(i+1));
                ram=scan.nextLong();
                System.out.println("Enter the processor for VM "+(i+1));
                processor=scan.nextLong();
                System.out.println("Enter the Disk Space for VM "+(i+1));
                diskspace=scan.nextLong();
                temp.addConf(ram, processor, diskspace);
                System.out.println("Do you want to input priority?");
                int ch=scan.nextInt();
                if(ch==0)
                    temp.priority=10;
                else
                {
                    System.out.println("Input Priority");
                    temp.priority=scan.nextInt();
                }
                v.add(i, temp);
                
            }
        return v;
    }
    
  
    
    
    public static void MannualInput() {
        // TODO Auto-generated method stub
       FileSystemConnection.createDirectories();    ////CREATE THE FOLDER DIRECTORIES WITH RESPECT TO DEFINATIVE AND ORGANISED STRUCTURE
       
       System.out.println("Server or VM. Enter 0 or 1 respectively");
       
       int flag=scan.nextInt();
       System.out.println("Do you want to read the file?");
       int ch=scan.nextInt();
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
               ArrayList <ServerClass> s=inputServer();
               File file=FileSystemConnection.createNewFile(pathServer);            //to write in server file
               pathServer=file.getAbsolutePath();
               FileSystemConnection.writeServerDetails(file, s); 
               
              // for(int i=0; i<s.size(); i++)
                 //  System.out.println(s.get(i).getConf());
                
           }
           else if (flag==1)
           {
               ArrayList <VmClass> v=inputVm();
               File file=FileSystemConnection.createNewFile(pathVm);                // to write in vm file
               pathVm=file.getAbsolutePath();
               FileSystemConnection.writeVmDetails(file, v);
              // for(int i=0; i<v.size(); i++)
                //   System.out.println(v.get(i).getConf());
           }
           else
               System.out.println("Illegal input");
        }
       }
       
/*
 * CLEAR THE MAIN AND MAKE IT MORE READABLE AND CLEAR WITH PROPER AND HIERARCHICAL STRUCTURE
 */
    
}
