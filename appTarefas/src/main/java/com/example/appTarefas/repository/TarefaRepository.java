package com.example.appTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appTarefas.model.TarefaModel;

public interface TarefaRepository extends JpaRepository<TarefaModel,Long>{
	

}
