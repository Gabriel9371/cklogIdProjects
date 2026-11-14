package com.example.cklogidprojects.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "projeto")
public class Projeto {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String titulo = "";

    public String descricao;

    @NonNull
    public StatusProjeto status = StatusProjeto.IDEIA;

    /** 1 = baixa, 2 = média, 3 = alta. */
    public int prioridade = 2;

    /** Momento da criação, em milissegundos (System.currentTimeMillis()). */
    public long criadoEm = System.currentTimeMillis();
}