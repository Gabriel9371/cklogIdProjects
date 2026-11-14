package com.example.cklogidprojects.data;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TarefaDao {

    @Insert
    long inserir(Tarefa tarefa);

    @Update
    void atualizar(Tarefa tarefa);

    @Delete
    void excluir(Tarefa tarefa);

    @Query("SELECT * FROM tarefa WHERE projetoId = :projetoId ORDER BY concluida, id")
    LiveData<List<Tarefa>> listarPorProjeto(long projetoId);

    @Query("SELECT COUNT(*) FROM tarefa WHERE projetoId = :projetoId")
    int contarPorProjeto(long projetoId);

    @Query("SELECT COUNT(*) FROM tarefa WHERE projetoId = :projetoId AND concluida = 1")
    int contarConcluidas(long projetoId);
}