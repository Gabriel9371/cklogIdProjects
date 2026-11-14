package com.example.cklogidprojects.data;

/**
 * Estados possíveis de um projeto no backlog.
 * O Room guarda o enum como texto (o nome da constante).
 */
public enum StatusProjeto {
    IDEIA,
    FAZENDO,
    PARADO,
    CONCLUIDO
}