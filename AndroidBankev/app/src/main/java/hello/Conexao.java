package hello;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Conexao{

    private final String USER_AGENT = "Mozilla/5.0";
    public final String IP =  "http://192.168.42.100";
        public final String PORTA = ":5543";
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

        List<hello.Usuario> found = transformaObjeto(new JSONArray(response.toString()));

        return found;
    }


    public boolean sendPostLogin(String login, String senha) throws MalformedURLException, IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = new URL(IP + PORTA + "/usuario/login");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        conn.setRequestProperty("Accept","application/json");
        conn.setDoOutput(true);
        conn.setDoInput(true);

        JSONObject objetoUsuario = new JSONObject();
        try{
            objetoUsuario.put("userName", login);
            objetoUsuario.put("password", senha);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        Log.i("JSON", objetoUsuario.toString());
        DataOutputStream os = new DataOutputStream(conn.getOutputStream());
        os.writeBytes(objetoUsuario.toString());

        os.flush();
        os.close();

        Log.i("STATUS", String.valueOf(conn.getResponseCode()));
        Log.i("MSG" , conn.getResponseMessage());

        final InputStream stream = conn.getInputStream();
        conn.disconnect();
        if(new Scanner(stream, "UTF-8").next().equals("true")){
            return true;
        }else{
            return false;
        }

    }

    public List<Usuario> sendGetRecuperaUsuario(String login) throws MalformedURLException, IOException, JSONException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = new URL(IP + PORTA + "/buscaListUsuarios/" + login.toString());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        conn.setRequestProperty("User-Agent", USER_AGENT);


        conn.disconnect();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        List<Usuario> found = transformaObjeto(new JSONArray(response.toString()));

        return found;
    }


    public List<hello.Usuario> transformaObjeto(JSONArray response) {

        List<hello.Usuario> found = new LinkedList<>();

        try {

            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);

                found.add(new hello.Usuario(obj.getString("nomeCompleto"), obj.getString("cpf"), obj.getString("email"),obj.getString("user"), obj.getString("senha"), obj.getString("numeroDaConta")));
            }

        } catch (JSONException e) {
            found = null;
        }
        return found;
    }

    public void SendGetCadUsuario(String nome, String cpf, String email, String login, String senha, String conta) throws MalformedURLException, IOException, JSONException{
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = new URL(IP + PORTA + "/addUsuario/" + nome + "/" + cpf + "/" + email + "/" + login + "/" + senha + "/" + conta);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        conn.setRequestProperty("User-Agent", USER_AGENT);


        conn.disconnect();
    }
}
