import java.io.Serializable;
import java.util.ArrayList;
 
/**
 * TODO: Document me!
 *
 * @author souravmodak
 *
 */
public class ServerClass implements Serializable {

    long ram, processor, diskspace;
    public static int serverId;
    
    public ServerClass(long ram, long processor, long diskspace)
    {
        this.diskspace=diskspace;
        this.processor=processor;
        this.ram=ram;
    }
    
    public ServerClass()
    {
        
    }
    
    public void addConf(long ram, long processor, long diskspace)
    {
        this.diskspace=diskspace;
        this.processor=processor;
        this.ram=ram;
    }
    
    public ArrayList getConf()
    {
        ArrayList <Long> conf=new ArrayList <Long>(3);
        conf.add(ram);
        conf.add(processor);
        conf.add(diskspace);
        return conf;
    }
}
