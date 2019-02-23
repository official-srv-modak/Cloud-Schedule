import java.io.File;
import java.util.ArrayList;

/**
 * TODO: Document me!
 *
 * @author souravmodak
 *
 */
public abstract class ClusterVmPriorty {
    
    static int minVal(ArrayList<VmClass> vm)
    {
        int min=vm.get(0).priority;
        for(int i=0; i<vm.size(); i++)
            if(vm.get(i).priority<min)
                min=vm.get(i).priority;
        return min;
    }
    static int maxVal(ArrayList<VmClass> vm)
    {
        int max=vm.get(0).priority;
        for(int i=0; i<vm.size(); i++)
            if(vm.get(i).priority>max)
                max=vm.get(i).priority;
        return max;
    }
    protected static void clusterVm(ArrayList<VmClass> vm)
    {
        vm=FileSystemConnection.readVmDetails(new File(Main.pathVm));           //Read the values
//LOGIC
//----------------------------------------------------------------------------------------------------------------------------
        ArrayList<VmClass> highPriorityVm=new ArrayList<VmClass>();
        ArrayList<VmClass> lowPriorityVm=new ArrayList<VmClass>();
        
        long highPriority=maxVal(vm), mid, lowPriority=minVal(vm); 
        mid=(highPriority+lowPriority)/2;
        
        for(int i=0; i<vm.size(); i++)
        {
            if(vm.get(i).priority<=mid)
                highPriorityVm.add(vm.get(i));
            else
                lowPriorityVm.add(vm.get(i));
        }
//----------------------------------------------------------------------------------------------------------------------------
        //Write to file
        File highPriorityfile=new File(FileSystemConnection.Vm.getAbsolutePath()+"/High Priotity.dat");  // Write the output values
        FileSystemConnection.writeVmDetails(highPriorityfile, highPriorityVm);
        File lowPriorityfile=new File(FileSystemConnection.Vm.getAbsolutePath()+"/Low Priotity.dat");    // Write the output values
        FileSystemConnection.writeVmDetails(lowPriorityfile, lowPriorityVm);
//----------------------------------------------------------------------------------------------------------------------------
        highPriorityVm=FileSystemConnection.readVmDetails(highPriorityfile);
        lowPriorityVm=FileSystemConnection.readVmDetails(lowPriorityfile);
        
        System.out.println("High Priorities");
        for(int i=0; i<highPriorityVm.size(); i++)
            System.out.println(highPriorityVm.get(i).getConf()+" Priority ==>"+highPriorityVm.get(i).priority);
        
        System.out.println("\nLow Priorities");
        for(int i=0; i<lowPriorityVm.size(); i++)
            System.out.println(lowPriorityVm.get(i).getConf()+" Priority ==>"+lowPriorityVm.get(i).priority);
    }
}
