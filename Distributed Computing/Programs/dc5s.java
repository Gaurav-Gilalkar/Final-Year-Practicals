import java.io.*;
import java.net.*;


public class dc5s
{
 
    private static Socket socket;
 
    public static void main(String[] args) throws IOException
    {
        try
        {
 
            int port = 1024;int count=0,a=0;
            ServerSocket sSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 1024");
 
            
            while(true)
            {
                
                socket = sSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String file = br.readLine();
                System.out.println("file received from client is "+file);
		//File transferFile =new File ("abc.txt"); 
 		byte [] bytearray = new byte [1024];
	      OutputStream os = socket.getOutputStream();
		
		 FileInputStream fin =new FileInputStream("abc.txt"); 
 		BufferedInputStream bin = new BufferedInputStream(fin); 
 	do
	{       count++; 
	 	bin.read(bytearray,0,count*10);
 		
 		//OutputStream os = socket.getOutputStream(); 
 		System.out.println("Sending Files...");
 		os.write(bytearray,0,count*10); 
 		os.flush();// os.close();
             System.out.println("Want to send more?(0-yess||1-no)");
             BufferedReader brd=new BufferedReader(new InputStreamReader(System.in));
              a=Integer.parseInt(brd.readLine());
	
	}while (a==0);
      		if(a==1) break;
            } 
//socket.close(); 		
System.out.println("File transfer complete");
		
	    
	}		  
                
              
       // catch (Exception e)
        //{
         //   System.out.println("No Such File Found");
       // }
        finally
        {
          //  try
            {
                socket.close();
            }
            //catch(Exception e){}
        }
    };
}
 



