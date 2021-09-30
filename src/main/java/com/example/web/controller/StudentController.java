package com.example.web.controller;

import com.example.web.model.Student;
import com.example.web.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    @ModelAttribute("students")
    public List<Student> findAll () {
        return studentService.findAll();
    }

    @PostMapping
    public String addPerson (@ModelAttribute Student student, Model model) {
        studentService.add(student);
        model.addAttribute("message", "Студент " + student.getName() + " ,был добавлен");
        return "redirect:/student";
    }
    @GetMapping("/{id}")
    public String delete(@PathVariable Long id){
        studentService.deleteById(id);
        return "redirect:/student";
    }
}




