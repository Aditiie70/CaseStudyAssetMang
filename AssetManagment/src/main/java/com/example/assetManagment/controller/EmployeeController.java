package com.example.assetManagment.controller;


import com.example.assetManagment.entity.*;
import com.example.assetManagment.repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private AssetRepository assetRepo;

    @Autowired
    private ServiceRequestRepository serviceRequestRepo;

    @Autowired
    private AssetRequestRepository assetRequestRepo;

    // Show registration
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "forward:/register.jsp";  
    }

    // registration
    @PostMapping("/register")
    public String register(@ModelAttribute Employee employee) {
        employeeRepo.save(employee);
        return "redirect:/employee/login";
    }

    // Show login 
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "forward:/login.jsp";  
    }

    //login
    @PostMapping("/login")
    public String login(@ModelAttribute Employee employee, HttpSession session, Model model) {
        Employee existing = employeeRepo.findByEmailAndPassword(employee.getEmail(), employee.getPassword());
        if (existing != null) {
            session.setAttribute("employeeId", existing.getId());
            return "redirect:/employee/dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials!");
            return "forward:/login.jsp";
        }
    }

    // Emp dashboard
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        model.addAttribute("assets", assetRepo.findAll());
        return "forward:/dashboard.jsp";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/employee/login";
    }
}
