package br.com.senaijandira.mybooks.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import br.com.senaijandira.mybooks.dao.UsuarioDao;
import br.com.senaijandira.mybooks.model.Usuario;

@Database(entities = {Usuario.class}, version = 2)
public abstract class UsuarioDataBase extends RoomDatabase{

    public abstract UsuarioDao usuarioDao();
}
