package com.bandtec.gespospring.repository;

import com.bandtec.gespospring.entity.table.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
