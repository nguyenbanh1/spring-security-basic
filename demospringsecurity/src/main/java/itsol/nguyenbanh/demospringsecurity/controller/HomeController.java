package itsol.nguyenbanh.demospringsecurity.controller;

import itsol.nguyenbanh.demospringsecurity.dao.RoleDAO;
import itsol.nguyenbanh.demospringsecurity.dao.StaffDAO;
import itsol.nguyenbanh.demospringsecurity.dao.Staff_RoleDAO;
import itsol.nguyenbanh.demospringsecurity.entities.Role;
import itsol.nguyenbanh.demospringsecurity.entities.Staff;
import itsol.nguyenbanh.demospringsecurity.entities.Staff_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class HomeController {


    @Autowired
    private StaffDAO staffDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private Staff_RoleDAO staff_roleDAO;

    @RequestMapping(value = "get/public/user/{id}")
    public String getPublicStaff(@PathVariable("id")int id){

        return "user :" + id;

    }


    @RequestMapping(value = "get/private/user/{id}")
    public Staff getPrivateStaff(@PathVariable("id")int id){

        return staffDAO.findById(id).orElse(new Staff());
    }



    @RequestMapping(value = "get/admin/{id}")
    public String getAdmin(@PathVariable("id")int id){

        return "Admin : " + id;
    }

    @RequestMapping(value = "get/home")
    public String getHome(){

        return "HOME";
    }


    @RequestMapping(value = "staffs/all",method = RequestMethod.GET)
    public String postStaff(){
        return "oke";
    }

    @RequestMapping(value = "roles",method = RequestMethod.POST,produces = {"application/json"})
    public void postRole(@RequestBody List<Role> roles){

        for(Role e : roles){
            roleDAO.save(e);
        }

    }
    @RequestMapping(value = "staff_roles",method = RequestMethod.POST,produces = {"application/json"})
    public void postStaff_Role(@RequestBody List<Staff_Role> staff_roles){
        for(Staff_Role e : staff_roles){
            staff_roleDAO.save(e);
        }
    }

}
