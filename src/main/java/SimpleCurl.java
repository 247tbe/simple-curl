import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SimpleCurl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initialInput;
        List<String> tokenizedInput = new ArrayList<>();

        try {
            initialInput = br.readLine();
            StringTokenizer st = new StringTokenizer(initialInput);

            while (st.hasMoreTokens()) {
                tokenizedInput.add(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Socket socket = null;
        BufferedReader input = null;
//        BufferedWriter output = null;
//        Scanner scanner = new Scanner(System.in);

        try {
//            socket = new Socket(tokenizedInput.get(1), Integer.parseInt(tokenizedInput.get(2)));

//            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            URL url = new URL(tokenizedInput.get(tokenizedInput.size() - 1));
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            StringTokenizer st2 = new StringTokenizer(url.toString());
            List<String> tokenizedUrlString = new ArrayList<>();

            while (st2.hasMoreTokens()) {
                tokenizedUrlString.add(st2.nextToken("/"));
            }

            if (tokenizedUrlString.get(tokenizedUrlString.size() - 1).equals("get")) {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.getResponseCode();

                input = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = input.readLine()) != null) {
                    response.append(inputLine);
                }

                System.out.println(response.toString());
            }

//            while (true) {
//                System.out.print("Please input message >> ");
//                String outputMessage = scanner.nextLine();
//
//                output.write(outputMessage + "\n");
//                output.flush();
//
//                String inputMessage = input.readLine();
//                System.out.println("Server : " + inputMessage);
//
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
//                scanner.close();
//                output.close();
                input.close();
//                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
