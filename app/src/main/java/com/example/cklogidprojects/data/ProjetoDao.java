package com.example.cklogidprojects.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProjetoDao {

    @Insert
    long inserir(Projeto projeto);

    @Update
    void atualizar(Projeto projeto);

    @Delete
    void excluir(Projeto projeto);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void vincularTecnologia(ProjetoTecnologia vinculo);

    @Delete
    void desvincularTecnologia(ProjetoTecnologia vinculo);

    @Transaction
    @Query("SELECT * FROM projeto ORDER BY prioridade DESC, criadoEm DESC")
    LiveData<List<ProjetoComTecnologias>> listarTodos();

    @Transaction
    @Query("SELECT * FROM projeto WHERE status = :status ORDER BY prioridade DESC, criadoEm DESC")
    LiveData<List<ProjetoComTecnologias>> listarPorStatus(StatusProjeto status);

    @Transaction
    @Query("SELECT * FROM projeto WHERE id = :id")
    ProjetoComTecnologias buscarPorId(long id);
}