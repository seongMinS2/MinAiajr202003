import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx2 {

    public static void main(String[] args) {
        URL url = null;

        String address = "https://www.google.com/search?q=java&oq=java&aqs=chrome..69i57j0j69i60j69i61j69i65l2j69i60l2.547j0j9&sourceid=chrome&ie=UTF-8";

        try {
            url = new URL(address);
            URLConnection conn = url.openConnection();

            System.out.println("conn.toString():"+conn);
            System.out.println("getAllowUserInteraction():" +
                    conn.getAllowUserInteraction());
            System.out.println("getConnectTimeout():" +
                    conn.getConnectTimeout());
//            System.out.println("getContent():" + conn.getContent());
            System.out.println("getContentEncoding():" +
                    conn.getContentEncoding());
            System.out.println("getContentLength():" +
                    conn.getContentLength());
            System.out.println("getContentType():" +
                    conn.getContentType());
            System.out.println("getDate():" + conn.getDate());
            System.out.println("getDefaultAllowUserInteraction():" +
                    conn.getDefaultAllowUserInteraction());
            System.out.println("getDefaultUseCaches():" +
                    conn.getDefaultUseCaches());
            System.out.println("getDoInput():" + conn.getDoInput());
            System.out.println("getDoOutput():" + conn.getDoOutput());
            System.out.println("getExpiration():" + conn.getExpiration());
            System.out.println("getHeaderFields():" +
                    conn.getHeaderFields());
            System.out.println("getIfModifiedSince():" +
                    conn.getIfModifiedSince());
            System.out.println("getLastModified():" +
                    conn.getLastModified());
            System.out.println("getReadTimeout():" +
                    conn.getReadTimeout());
            System.out.println("getURL():" + conn.getURL());
            System.out.println("getUseCaches():" +
                    conn.getUseCaches());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
