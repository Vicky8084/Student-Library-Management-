package com.Library.student_library_management.controller;

import com.Library.student_library_management.model.Student;
import com.Library.student_library_management.requestDTO.StudentRequestDTO;
import com.Library.student_library_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    private StudentService studentService;
    @Autowired
    private StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        String response=studentService.addStudent(studentRequestDTO);
        return response;
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
        Student student=studentService.findStudentById(id);
        return student;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudent(){
        List<Student> studentList=studentService.findAllStudent();
        return studentList;
    }

    @GetMapping("/findByPages")
    public List<Student> findByPages(@RequestParam int pageNumber, @RequestParam int pageSize,@RequestParam String sortBy,@RequestParam String order){
        return studentService.fineALlByPages(pageNumber,pageSize,sortBy,order);
    }

//    @GetMapping("/findAllByPages")
//    public List<Student> findStudentByPages(@RequestParam int pageNumber, @RequestParam int pageSize){
//        List<Student> studentList=studentService.findStudentByPages(pageNumber,pageSize);
//        return studentList;
//    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody StudentRequestDTO studentRequestDTO){
        String response=studentService.updateStudent(id, studentRequestDTO);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        String response=studentService.deleteStudent(id);
        return response;
    }

    @GetMapping("/findByEmail")
    public Student findStudentByEmail(@RequestParam String email){
        return studentService.findStudentByEmail(email);
    }

    @GetMapping("/findStudentByDept")
    public List<Student> findStudentByDept(@RequestParam String dept){
        return studentService.findStudentByDept(dept);
    }

    @GetMapping("/findStudentBySem")
    public List<Student> findStudentBySem(@RequestParam String sem){
        return studentService.findStudentBySem(sem);
    }

    @GetMapping("/findByEmail")
    public Student findByEmail(@RequestParam String email){
        return studentService.findByEmail(email);
    }
}
