package br.com.senaijandira.exemplofragment.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.senaijandira.exemplofragment.R;

public class Fragment1 extends Fragment {



    //no fragment vc pode usar o comando getContext() para obter o contexto
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //carrega o xml na variavel v
        View v = inflater.inflate(R.layout.fragment_layout1, container, false);



        return v;
    }
}
