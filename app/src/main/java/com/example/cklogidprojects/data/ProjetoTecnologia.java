package com.example.cklogidprojects.data;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

/**
 * Tabela de ligação da relação N:N entre Projeto e Tecnologia.
 * A chave primária é composta: o mesmo par não pode se repetir.
 */
@Entity(
        tableName = "projeto_tecnologia",
        primaryKeys = {"projetoId", "tecnologiaId"},
        foreignKeys = {
                @ForeignKey(
                        entity = Projeto.class,
                        parentColumns = "id",
                        childColumns = "projetoId",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Tecnologia.class,
                        parentColumns = "id",
                        childColumns = "tecnologiaId",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {@Index("tecnologiaId")}
)
public class ProjetoTecnologia {

    public long projetoId;
    public long tecnologiaId;

    public ProjetoTecnologia(long projetoId, long tecnologiaId) {
        this.projetoId = projetoId;
        this.tecnologiaId = tecnologiaId;
    }
}