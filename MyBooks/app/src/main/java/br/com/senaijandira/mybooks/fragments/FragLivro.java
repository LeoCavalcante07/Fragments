package br.com.senaijandira.mybooks.fragments;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import br.com.senaijandira.mybooks.Login;
import br.com.senaijandira.mybooks.R;
import br.com.senaijandira.mybooks.Utils;
import br.com.senaijandira.mybooks.adapter.LivroAdapter;
import br.com.senaijandira.mybooks.db.MyBooksDatabase;
import br.com.senaijandira.mybooks.model.Livro;
import br.com.senaijandira.mybooks.model.Usuario;

public class FragLivro extends Fragment {

    LivroAdapter livroAdapter;

    ListView listViewLivros;

    Usuario usuarioLogado;

    public static Livro[] livros;

    //Variavel de acesso ao Bnaco
    private MyBooksDatabase myBooksDb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;

        v = inflater.inflate(R.layout.fragment_livro, container, false);

        usuarioLogado = Login.usuarioLogado;

        //Criado a instancia do banco de dados
        myBooksDb = Room.databaseBuilder(getContext(), MyBooksDatabase.class, Utils.DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        listViewLivros = v.findViewById(R.id.listViewLivros);
        livroAdapter = new LivroAdapter(getContext(), myBooksDb);
        listViewLivros.setAdapter(livroAdapter);


        livros = new Livro[]{};

        return v;
    }


    @Override
    public void onResume() {
        super.onResume();


        carregarLivros();

    }



    public void carregarLivros(){

        livros = myBooksDb.daoLivro().selecionarTodos(usuarioLogado.getId());
        livroAdapter.clear();
        livroAdapter.addAll(livros);

    }









}





