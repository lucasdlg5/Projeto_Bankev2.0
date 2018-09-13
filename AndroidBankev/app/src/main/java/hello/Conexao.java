package hello;

import android.app.AlertDialog;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Conexao{

    private final String USER_AGENT = "Mozilla/5.0";


    // HTTP GET request

    public List<hello.Usuario> sendGet() throws Exception {
        String url = "127.0.0.1:5543/usuario/login";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        List<hello.Usuario> found = findAllItems(new JSONArray(response.toString()));

        return found;
    }

    public List<hello.Usuario> findAllItems(JSONArray response) {

        List<hello.Usuario> found = new LinkedList<>();

        try {


            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);

                found.add(new hello.Usuario(obj.getString("userName"), obj.getString("password")));
            }

        } catch (JSONException e) {
            // handle exception
        }

        return found;
    }

    public Boolean logarUsuario(String login, String senha){
        JSONObject objetoUsuario = new JSONObject();
        try{
        objetoUsuario.put("userName", login);
        objetoUsuario.put("password", senha);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;
    }

    public String sendPost(String login, String senha) {
        try {
        URL url = new URL("192.168.43.125:5543/usuario/login");

        //URL url = new URL("127.0.0.1:5543/usuario/login");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        conn.setRequestProperty("Accept","application/json");
            return "Ate aqui foi";
        /*conn.setDoOutput(true);
        conn.setDoInput(true);

        JSONObject objetoUsuario = new JSONObject();
        try{
            objetoUsuario.put("userName", login);
            objetoUsuario.put("password", senha);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "Falha na criacao do JSON";
        }
            return "Ate aqui foi";
        Log.i("JSON", objetoUsuario.toString());
        DataOutputStream os = new DataOutputStream(conn.getOutputStream());
        os.writeBytes(objetoUsuario.toString());

        os.flush();
        os.close();

        Log.i("STATUS", String.valueOf(conn.getResponseCode()));
        Log.i("MSG" , conn.getResponseMessage());

        final InputStream stream = conn.getInputStream();
        conn.disconnect();
       */
        //return new Scanner(stream, "UTF-8").next();
        } catch (Exception e) {
        e.printStackTrace();
        return "Não funcionou";
        }

    }
}
