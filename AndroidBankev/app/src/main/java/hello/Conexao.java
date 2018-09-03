package hello;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.util.LinkedList;
        import java.util.List;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

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


}
