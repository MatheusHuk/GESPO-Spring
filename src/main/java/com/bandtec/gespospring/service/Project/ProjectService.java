package com.bandtec.gespospring.service.Project;

import com.bandtec.gespospring.DTO.request.ProjectDTO;
import com.bandtec.gespospring.DTO.request.ProjectUpdateDTO;
import com.bandtec.gespospring.entity.table.Project;

import java.util.List;

public interface ProjectService {
   void save(ProjectDTO projects);
   Project findById(Integer id);
   Boolean update(ProjectUpdateDTO project);
   Boolean delete(Integer id);
   List<Project> findByEmployee(Integer id);
   Boolean addResourceAllocation(Integer employeeId, Integer projectId);
   Boolean removeResourceAllocation(Integer employeeId, Integer projectId);
}
