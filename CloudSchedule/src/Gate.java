import java.util.Scanner;

/**
 * TODO: Document me!
 *
 * @author souravmodak
 *
 */
public interface Gate {
    
    static void DataSetInput()
    {
        System.out.println("In Development\nWill be Back soon");
    }
    public static void main(String [] args)
    {
        while(true)
        {
            Scanner scan=new Scanner(System.in);
            System.out.println("\n\n1. ==> Mannual Input\n2. ==> DataSet Input\n3. ==> Automatic Input Server\n4. ==> Automatic Input Vm\n5. ==> Exit");
            int ch=scan.nextInt();
            switch(ch)
            {
                case 1: Main.MannualInput();
                break;
                case 2: DataSetInput();
                break;
                case 3: DefaultInput.defaultServerInput();
                break;
                case 4: DefaultInput.defaultVmInput();
                break;
                case 5:	System.out.println("Exiting..."); 
                		System.out.println("Terminated");
                		System.exit(0);
                default: System.out.println("Wrong choice");
            }
            
            
        }
        
    }

}
