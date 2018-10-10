package br.com.senaijandira.mybooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.senaijandira.mybooks.fragments.FragLivro;
import br.com.senaijandira.mybooks.fragments.FragLivroLer;
import br.com.senaijandira.mybooks.fragments.FragLivroLido;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;



    TabLayout tabMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fm  = getSupportFragmentManager();

        abrirLivro();

        tabMenu = findViewById(R.id.menuTab);

        tabMenu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

//                switch (tab.getPosition()){
//                    case 0:
//                        abrirLivro();
//                    case 1:
//                        abrirLivroler();
//                    case 2:
//                        abrirLivroLido();
//
//
//                }

                if(tab.getPosition() == 0){
                    abrirLivro();
                }else if(tab.getPosition() == 1){
                    abrirLivroler();
                }else if(tab.getPosition() == 2){
                    abrirLivroLido();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





    }

    public void abrirLivro(){

//        FragLivro.LivrosAdapter livrosAdapter = new FragLivro.LivrosAdapter(this);

        //FragmentTransaction ft = fm.beginTransaction();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frameLayout, new FragLivro());

        ft.commit();
    }

    public void abrirLivroler(){

        //FragmentTransaction ft = fm.beginTransaction();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();

        //ft.replace(R.id.frameLayout, new FragLivroLer());
        ft.replace(R.id.frameLayout, new FragLivroLer());

        ft.commit();
    }

    public void abrirLivroLido(){

        //FragmentTransaction ft = fm.beginTransaction();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();

        //ft.replace(R.id.frameLayout, new FragLivroLer());
        ft.replace(R.id.frameLayout, new FragLivroLido());

        ft.commit();

    }

    public void abrirCadastro(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
    }
}
