package itsol.nguyenbanh.demospringsecurity.dao;

import itsol.nguyenbanh.demospringsecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleDAO extends JpaRepository<Role,Integer> {
}
