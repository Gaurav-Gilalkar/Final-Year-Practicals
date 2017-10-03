import java.io.*;
import java.net.*;

public class dc5c
{
 
    private static Socket socket;
 
    public static void main(String args[]) throws IOException
    {
        try
        {
	    int filesize=1022386;
            byte [] bytearray = new byte [filesize];
            int bytesRead; 
            int current = 0,count=0,a=0;
	    String host ="10.21.21.32";
            int port = 1024;
            InetAddress address = InetAddress.getByName("localhost");
            socket = new Socket(address, port);
	    
	     //Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
 
            String file = "abc.txt"  ;
 
            String sendMessage = file + "\n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server : "+sendMessage);
 
           while(a==0)
           {
		//Get the return message from the server
            InputStream is = socket.getInputStream(); 
            FileOutputStream fos = new FileOutputStream("abcr.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bytesRead = is.read(bytearray,0,bytearray.length);
            current = bytesRead; 
            
 	bos.write(bytearray, 0 , count*10); 
	count++;
 	bos.flush(); 
 	bos.close(); 
 	 System.out.println("Want to receive more?(0-yess||1-no)");
             BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
              a=Integer.parseInt(br.readLine());
           }
	
            
        }
        //catch (Exception e)
        //{
        //    e.printStackTrace();
        //}
        finally
        {
            //Closing the socket
            //try
            {
                socket.close();
            }
           // catch(Exception e)
            {
             //   e.printStackTrace();
            }
        }
    }
}