package br.com.senaijandira.exemplofragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import br.com.senaijandira.exemplofragment.fragments.Fragment1;
import br.com.senaijandira.exemplofragment.fragments.Fragment2;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;
    TabLayout tab_menu;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        //Código para o TAB MENU
        tab_menu = findViewById(R.id.tab_menu);

        tab_menu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == 0){ //se for 0 é a primeira tab
                    openFragment1(null);
                }else if(tab.getPosition() == 1){ // se for 1 é a segunda tab, pois a primeira é o indice 0
                    openFragment2(null);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ////**         FIM DO CÓDIGO TAB LAYOUT            **///////


        bottomNav = findViewById(R.id.menu_bottom_nav);

        //serve para identificar quando esta mudando o item clicado
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu_frag1){ //v}e se o item selecionado é o frag1
                    openFragment1(null);
                    return true;
                }else if(item.getItemId() == R.id.menu_frag2){
                    openFragment2(null);
                    return true;
                }

                return false;
            }
        });

    }




    public void openFragment2(View view) {

        FragmentTransaction ft = fm.beginTransaction();//responsavel por fazer a transação da fragments

        ft.replace(R.id.frame_layout, new Fragment2());

        ft.commit(); //envia as alterações
    }

    public void openFragment1(View view) {

        FragmentTransaction ft = fm.beginTransaction();//responsavel por fazer a transação da fragments

        ft.replace(R.id.frame_layout, new Fragment1());

        ft.commit(); //envia as alterações



    }
}
