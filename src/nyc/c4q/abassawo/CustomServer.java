package nyc.c4q.abassawo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by c4q-Abass on 11/4/15.
 */
public class CustomServer {
    public static final int PORT = 6000;
    public static final int HOURS_TO_MILLISECONDS = 60 * 60 * 1000;

    public static void main(String[] args) throws IOException {
        final ServerSocket srvsocket = new ServerSocket(PORT);


        while (!srvsocket.isClosed()) {
            Socket inboundConnection = srvsocket.accept();
            //read UTF from client
            BufferedReader in = new BufferedReader(new InputStreamReader(inboundConnection.getInputStream()));
            int offset = Integer.parseInt(in.readLine());
            int utcOffset = Integer.parseInt(in.readLine());
            System.out.println("SERVER received: " + utcOffset);

            // write datetime string to client
            PrintWriter out = new PrintWriter(inboundConnection.getOutputStream(), true);
            out.println(convertUTCOffsetToISO8601(utcOffset));
        }

    }





    private static String convertUTCOffsetToISO8601(int utcOffset) {
        // update timezone
        TimeZone utc = TimeZone.getTimeZone("UTC");
        utc.setRawOffset(utcOffset * HOURS_TO_MILLISECONDS);

        // apply timezone to datetime formatter
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        dateFormat.setTimeZone(utc);

        // apply datetime formatter to current date
        return dateFormat.format(new Date());  // now
    }

}
