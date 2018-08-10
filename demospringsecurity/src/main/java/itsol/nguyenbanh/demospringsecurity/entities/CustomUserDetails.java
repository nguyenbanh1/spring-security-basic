package itsol.nguyenbanh.demospringsecurity.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails extends Staff implements UserDetails {


    public CustomUserDetails(final Staff staff){
        this.setId(staff.getId());
        this.setUsername(staff.getUsername());
        this.setPassword(staff.getPassword());
        this.setStaff_roles(staff.getStaff_roles());
        this.setEnabled(staff.isEnabled());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
