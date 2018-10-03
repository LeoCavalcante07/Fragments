package br.com.senaijandira.mybooks;

import android.app.Fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.senaijandira.mybooks.adapter.LivroAdapter;
import br.com.senaijandira.mybooks.fragments.FragLivro;
import br.com.senaijandira.mybooks.fragments.FragLivroLer;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;
    LivroAdapter livroAdapter;


    TabLayout tabMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fm  = getSupportFragmentManager();


        tabMenu = findViewById(R.id.menuTab);

        tabMenu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    abrirLivro();
                }else if(tab.getPosition() == 1){
                    abrirLivroler();
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

    public void abrirLivro() {

//        FragLivro.LivrosAdapter livrosAdapter = new FragLivro.LivrosAdapter(this);





        //FragmentTransaction ft = fm.beginTransaction();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frameLayout, new FragLivro());

        ft.commit();
    }



    public void abrirLivroler() {

//        FragLivro.LivrosAdapter livrosAdapter = new FragLivro.LivrosAdapter(this);





        //FragmentTransaction ft = fm.beginTransaction();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();

        //ft.replace(R.id.frameLayout, new FragLivroLer());
        ft.replace(R.id.frameLayout, new FragLivroLer());

        ft.commit();
    }

    public void openFragmentLivro(){

    }

    public void abrirCadastro(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
        //startActivity(new Intent(this, CadastroActivity.class));
    }
}
