package com.example.assetManagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.assetManagment.entity.*;
import com.example.assetManagment.repository.*;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private AssetRepository assetRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private ServiceRequestRepository serviceRequestRepo;

    @Autowired
    private AssetRequestRepository assetRequestRepo;

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("admin", new Admin());
        return "forward:/adminLogin.jsp";  
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Admin admin, HttpSession session, Model model) {
        Admin existing = adminRepo.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
        if (existing != null) {
            session.setAttribute("adminId", existing.getId());
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "forward:/adminLogin.jsp";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        model.addAttribute("assets", assetRepo.findAll());
         return "forward:/adminDashboard.jsp";
    }
}
