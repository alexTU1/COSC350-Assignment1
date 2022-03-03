import java.io.*;
import java.net.*;

class TCPKRServer22 {

  public static void main(String argv[]) throws Exception
    {
      String clientSentence;
      String capitalizedSentence;

      try (ServerSocket welcomeSocket = new ServerSocket(12211)) {
 
      while(true) {
 
           Socket connectionSocket = welcomeSocket.accept();

           BufferedReader inFromClient =
             new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

           DataOutputStream  outToClient =
             new DataOutputStream(connectionSocket.getOutputStream());

           clientSentence = inFromClient.readLine();
           
           System.out.println("String received\n" + clientSentence);
           
           

           String inputLine;
           URL obj = new URL(clientSentence);
           HttpURLConnection con = (HttpURLConnection) obj.openConnection();
           con.setRequestMethod("GET");
           con.setRequestProperty("User-Agent","Mozilla/5.0");
           BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())); 
                        while ((inputLine = in.readLine()) != null) 
                           System.out.println(inputLine);   

           System.out.println("W1 request sent at: " + java.time.LocalTime.now());

           System.out.println("W1 response received at: " + java.time.LocalTime.now());
           capitalizedSentence = clientSentence.toUpperCase() + '\n';

           outToClient.writeBytes(capitalizedSentence);
        }
      }
    }
}