package com.example.cklogidprojects.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TecnologiaDao {

    /** Devolve o id novo, ou -1 se já existia uma tecnologia com esse nome. */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long inserir(Tecnologia tecnologia);

    @Query("SELECT * FROM tecnologia WHERE nome = :nome LIMIT 1")
    Tecnologia buscarPorNome(String nome);

    @Query("SELECT * FROM tecnologia ORDER BY nome")
    LiveData<List<Tecnologia>> listarTodas();
}