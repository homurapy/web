package com.example.web.service;

import com.example.web.model.Student;
import com.example.web.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student findById (Long id) throws Exception {
        return studentRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Student> findAll () {
        return studentRepository.findAll();
    }

    public void deleteById (Long id) {
        try {
            studentRepository.delete(findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update (Student student) {
        try {
            Student newStudent = findById(student.getId());
            newStudent.setName(student.getName());
            newStudent.setAge(student.getAge());
            studentRepository.save(newStudent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student add (Student student) {
        return studentRepository.save(student);
    }
}
