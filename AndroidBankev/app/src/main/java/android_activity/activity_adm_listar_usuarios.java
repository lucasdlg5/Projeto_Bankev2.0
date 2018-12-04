package android_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android_activity.adapter.viewAdapter_nome_usuario_list;
import hello.Conexao;
import hello.Usuario;
import sjc.fatec.sp.br.bankev20.R;

public class activity_adm_listar_usuarios extends AppCompatActivity implements viewAdapter_nome_usuario_list.ItemClickListener {


    List<String> nomes = new ArrayList<String>();
    List<Usuario> nomes_list = new ArrayList<>();
    private viewAdapter_nome_usuario_list nomeAdapter;


    private Conexao c = new Conexao();

//    TextView textView = findViewById(R.id.textView2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_listar_usuarios);

        try {
            nomes_list = c.sendGetRecuperaTodosUsuarios();

            for (int i = 0; i < nomes_list.size(); i++) {

                nomes.add(nomes_list.get(i).getNomeCompleto());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }



        addAdapter();
    }

    public void addAdapter (){
        RecyclerView rvNomes = findViewById(R.id.rvNomes);
        rvNomes.setLayoutManager(new LinearLayoutManager(this));
        nomeAdapter = new viewAdapter_nome_usuario_list(this, nomes);
        nomeAdapter.setmItemCLickListener(this);
        rvNomes.setAdapter(nomeAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {

    }


}
