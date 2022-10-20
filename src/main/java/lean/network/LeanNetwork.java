package lean.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LeanNetwork {
    public static void testURLConnection(){
        try {
            URL url = new URL("https://run.mocky.io/v3/4275977d-dc35-489b-8499-2e0df6edf867");
            HttpURLConnection uc =(HttpURLConnection)url.openConnection();
            uc.setRequestMethod("GET");
            uc.setConnectTimeout(10000);
            uc.setReadTimeout(10000);
            uc.connect();
            if (uc.getResponseCode() == 200) {
                InputStream is = uc.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                while (bf.ready()) {
                    sb.append((char) bf.read());
                }
                System.out.println(sb.toString());
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void testURLConnectionPost(){
        try {
            URL url = new URL("https://run.mocky.io/v3/4275977d-dc35-489b-8499-2e0df6edf867");
            HttpURLConnection uc =(HttpURLConnection)url.openConnection();
            uc.setRequestMethod("POST");
            uc.setConnectTimeout(10000);
            uc.setReadTimeout(10000);
            uc.setDoOutput(true);
            uc.setRequestProperty("Content-TYpe","application/x-www-form-urlencoded");
            uc.getOutputStream().write("name=me".getBytes());
            uc.connect();
            if (uc.getResponseCode() == 200) {
                InputStream is = uc.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                while (bf.ready()) {
                    sb.append((char) bf.read());
                }
                System.out.println(sb.toString());
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
