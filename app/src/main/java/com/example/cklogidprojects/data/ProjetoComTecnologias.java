package com.example.cklogidprojects.data;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

/**
 * Não é uma tabela: é o resultado de uma consulta que traz um Projeto
 * junto com a lista das suas Tecnologias (relação N:N).
 */
public class ProjetoComTecnologias {

    @Embedded
    public Projeto projeto;

    @Relation(
            parentColumn = "id",
            entityColumn = "id",
            associateBy = @Junction(
                    value = ProjetoTecnologia.class,
                    parentColumn = "projetoId",
                    entityColumn = "tecnologiaId"
            )
    )
    public List<Tecnologia> tecnologias;
}