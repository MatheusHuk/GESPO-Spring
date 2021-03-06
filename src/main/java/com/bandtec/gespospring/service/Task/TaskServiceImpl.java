package com.bandtec.gespospring.service.Task;

import com.bandtec.gespospring.DTO.request.TaskUpdateDTO;
import com.bandtec.gespospring.entity.table.Task;
import com.bandtec.gespospring.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void save(List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

    @Override
    public Task findById(Integer id) {
        return taskRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Boolean update(TaskUpdateDTO task) {
        return taskRepository.findById(task.getId()).map( tas -> {
            tas.setCategory(task.getCategory());
            tas.setDescription(task.getDescription());
            tas.setTitle(task.getTitle());
            tas.setPercentProject(task.getPercentProject());
            tas.setDeadline(task.getDeadline());
            return true;
        }).orElse( null);
    }

    @Override
    public Boolean delete(Integer id) {
        return taskRepository.findById(id).map(task -> {
            taskRepository.delete(task);
            return true;
        }).orElse(false);
    }

    @Override
    public List<Task> findByProject(Integer projectId) {
        return taskRepository.findByProject_Id(projectId);
    }
}
