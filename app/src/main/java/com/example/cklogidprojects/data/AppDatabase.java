package com.example.cklogidprojects.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(
        entities = {
                Projeto.class,
                Tecnologia.class,
                ProjetoTecnologia.class,
                Tarefa.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProjetoDao projetoDao();

    public abstract TecnologiaDao tecnologiaDao();

    public abstract TarefaDao tarefaDao();

    private static volatile AppDatabase instancia;

    /** Escritas (insert, update, delete) rodam aqui, fora da thread principal. */
    public static final ExecutorService escritaExecutor = Executors.newFixedThreadPool(4);

    public static AppDatabase getInstance(Context context) {
        if (instancia == null) {
            synchronized (AppDatabase.class) {
                if (instancia == null) {
                    instancia = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "backlog.db"
                    ).build();
                }
            }
        }
        return instancia;
    }
}