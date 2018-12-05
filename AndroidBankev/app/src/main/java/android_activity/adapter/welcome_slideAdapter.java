package android_activity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import sjc.fatec.sp.br.bankev20.R;

public class welcome_slideAdapter extends PagerAdapter {


    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.drawable.doguinho_14,
            R.drawable.doguinho_2,
            R.drawable.doguinho10,
            R.drawable.doguinho_8
    };
    // list of titles
    public String[] lst_title = {
            "Seja Bem-Vindo ao BANKEV!",
            "Visibilidade",
            "Unificado",
            "Um amorzinho"
    }   ;
    // list of descriptions
    public String[] lst_description = {
            "Aqui, será possivel administrar todas suas contas e faturas num unico lugar, de maneira facil e rápida!",
            "Ter visão dos seus gastos é um visor importante. Separando em categorias, faça a sua própria analise!",
            "Sem dinheiro em seu banco favorito? Agora é possivel utilizar seus outros bancos como se fosse um!",
            "Encontre as melhores fotos de doguinhos aqui!\nClique aqui para iniciar! <3"
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };


    public welcome_slideAdapter(Context context) {
        this.context = context;
    }


    public int getCount() {
        return lst_title.length;
    }


    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }


    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_welcome_slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.welcome_slide);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }


    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
