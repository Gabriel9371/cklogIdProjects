package com.example.cklogidprojects.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "tecnologia",
        indices = {@Index(value = "nome", unique = true)}
)
public class Tecnologia {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String nome = "";
}