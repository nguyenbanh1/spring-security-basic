package itsol.nguyenbanh.demospringsecurity.service;

import itsol.nguyenbanh.demospringsecurity.dao.StaffDAO;
import itsol.nguyenbanh.demospringsecurity.entities.CustomUserDetails;
import itsol.nguyenbanh.demospringsecurity.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StaffDAO staffDAO;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Staff staff = staffDAO.findByUsername(username).orElse(new Staff());

        SimpleGrantedAuthority a = new SimpleGrantedAuthority(username);

        return new CustomUserDetails(staff);
    }
}
