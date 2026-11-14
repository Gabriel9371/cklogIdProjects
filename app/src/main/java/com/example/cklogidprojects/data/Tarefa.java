package com.example.cklogidprojects.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "tarefa",
        foreignKeys = @ForeignKey(
                entity = Projeto.class,
                parentColumns = "id",
                childColumns = "projetoId",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index("projetoId")}
)
public class Tarefa {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public long projetoId;

    @NonNull
    public String titulo = "";

    public boolean concluida;
}