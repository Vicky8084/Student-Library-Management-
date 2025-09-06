package com.Library.student_library_management.Converter;

import com.Library.student_library_management.model.Student;
import com.Library.student_library_management.requestDTO.StudentRequestDTO;

public class StudentConverter {
    public static Student convertStudentRequestDtoIntoStudent(StudentRequestDTO studentRequestDTO){
        Student student=new Student();
        student.setName(studentRequestDTO.getName());
        student.setMobileNumber(studentRequestDTO.getMobileNumber());
        student.setEmail(studentRequestDTO.getEmail());
        student.setDept(studentRequestDTO.getDept());
        student.setSem(studentRequestDTO.getSem());
        student.setAddress(studentRequestDTO.getAddress());
        student.setDob(studentRequestDTO.getDob());
        student.setGender(studentRequestDTO.getGender());
        student.setSection(studentRequestDTO.getSection());
        return student;
    }

}
