import java.io.*;
import java.net.*;
class TCPKRClient22 {

    public static void main(String argv[]) throws Exception
    {
        String sentence;
        String sentence2;
        String modifiedSentence;
        String modifiedSentence2;

        BufferedReader inFromUser =
        new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Start Time: " + java.time.LocalTime.now());

        Socket clientSocket = new Socket("localhost", 12211);

        System.out.println("Enter string: ");

        DataOutputStream outToServer =
          new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer =
          new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        sentence = inFromUser.readLine();

        System.out.println("Enter string 2: ");

        sentence2 = inFromUser.readLine();

        outToServer.writeBytes(sentence + '\n');

        modifiedSentence = inFromServer.readLine();

        //outToServer.writeBytes(sentence2 + '\n');

        //modifiedSentence2 = inFromServer.readLine();

        System.out.println("FROM SERVER: \n" + modifiedSentence);
        //System.out.println("FROM SERVER: " + modifiedSentence2);
        
        System.out.println("End Time: " + java.time.LocalTime.now());
        clientSocket.close();
                  
    }
}