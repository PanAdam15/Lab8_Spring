package com.example.demo.services;

import com.example.demo.converters.StudentMapper;
import com.example.demo.dtos.StudentConverter;
import com.example.demo.dtos.StudentDto;
import com.example.demo.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl extends StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    @Override
    public List<StudentDto> getAllStudents() {
        return (List<StudentDto>) studentRepository.findAll().stream()
                .map(studentMapper::mapStudentToStudentDto)
                .collect(Collectors.toList());
    }


    public List<StudentDto> getAllStudentsNoAttachment() {
        return studentRepository.findAllNoAttachment();
    }

}
