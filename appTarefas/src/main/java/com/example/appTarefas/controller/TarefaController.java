package com.example.appTarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appTarefas.model.TarefaModel;
import com.example.appTarefas.repository.TarefaRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@GetMapping
	public List<TarefaModel> getAllTarefas(){
		return tarefaRepository.findAll();
	}
	
	@PostMapping
	public TarefaModel createTarefa(@RequestBody TarefaModel tarefaModel) {
		return tarefaRepository.save(tarefaModel);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<TarefaModel> updateTarefa(@PathVariable Long id, @RequestBody TarefaModel tarefaDetalhe){
		TarefaModel tarefa = tarefaRepository.findById(id).orElseThrow();
		tarefa.setTitle(tarefaDetalhe.getTitle());
		tarefa.setCompleted(tarefaDetalhe.isCompleted());
		return ResponseEntity.ok(tarefaRepository.save(tarefa));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTarefa(@PathVariable Long id){
		tarefaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
