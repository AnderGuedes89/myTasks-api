package com.tasks.myTasks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.myTasks.models.Task;
import com.tasks.myTasks.repository.TaskRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="Kanban - API REST")
@CrossOrigin(origins="*")
public class TaskResource {
	
	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping("/tarefas")
	@ApiOperation(value="Método utilizado para recuperar todos as tarefas existentes")
	public List<Task> tasksList(){
		return taskRepository.findAll();
	}
	
	@GetMapping("/tarefa/{id}")
	@ApiOperation(value="Método utilizado para recuperar uma tarefa específica")
	public Task task(@PathVariable(value="id") long id){
		return taskRepository.findById(id);
	}
	
	@PostMapping("/tarefa")
	@ApiOperation(value="Método utilizado para adicionar uma nova tarefa")
	public Task saveTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	@DeleteMapping("/tarefa")
	@ApiOperation(value="Método utilizado para deletar uma tarefa específica")
	public void deleteTask(@RequestBody Task task) {
		taskRepository.delete(task);
	}
	
	@PutMapping("/tarefa")
	@ApiOperation(value="Método utilizado para editar uma tarefa específica")
	public Task updateTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}

}
