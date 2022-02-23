package com.geekbrains.geekspring.controllers;

import com.geekbrains.geekspring.entities.Course;
import com.geekbrains.geekspring.entities.Student;
import com.geekbrains.geekspring.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/students")
@Transactional
public class StudentsController {
    private StudentsService studentsService;

    @Autowired
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @RequestMapping("/list")
    @Transactional
    public String showStudentsList(Model model) {
        List<Student> allStudents = studentsService.getAllStudentsList();
        model.addAttribute("studentsList", allStudents);
        return "students-list";
    }

    @RequestMapping("/remove/{id}")
    @Transactional
    public String removeStudent(@PathVariable("id") long id){
        studentsService.removeById(id);
        return "notification-on-removal";

    }

    @RequestMapping("/showcourses/{id}")
    public String showStudentCourses(@PathVariable("id") long id, Model model){
        List<Course> courseList = studentsService.getCoursesByStudentId(id);
        model.addAttribute("studentCourses", courseList);
        return "student-courses-list";
    }

}
