package itsol.nguyenbanh.demospringsecurity.dao;

import itsol.nguyenbanh.demospringsecurity.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffDAO extends JpaRepository<Staff,Integer> {

    Optional<Staff> findByUsername(String username);
}
