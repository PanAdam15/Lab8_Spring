package com.example.demo.services;

import com.example.demo.domain.Student;
import com.example.demo.dtos.StudentConverter;
import com.example.demo.dtos.StudentDto;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    private StudentConverter studentConverter;

    public List<StudentDto> getAllStudents() {
        return (List<StudentDto>) studentRepository.findAll().stream()
                .map(studentConverter::convert)
                .collect(Collectors.toList());
    }

}
