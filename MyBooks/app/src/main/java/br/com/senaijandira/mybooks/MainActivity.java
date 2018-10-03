package br.com.senaijandira.mybooks;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.senaijandira.mybooks.adapter.LivroAdapter;

public class MainActivity extends AppCompatActivity {


    LivroAdapter livroAdapter;

    FragmentManager fm;
    TabLayout tabMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void abrirLivro(View view) {

//        FragLivro.LivrosAdapter livrosAdapter = new FragLivro.LivrosAdapter(this);





        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frameLayout, new Fragment());

        ft.commit();
    }
}
