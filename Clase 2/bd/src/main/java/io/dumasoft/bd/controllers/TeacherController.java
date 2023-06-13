package io.dumasoft.bd.controllers;

import io.dumasoft.bd.models.dao.IPersonalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private IPersonalDao personalDao;

    @Autowired
    public TeacherController(@Qualifier("teacherDaoImpl") IPersonalDao personalDao) {
        this.personalDao = personalDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("teachers", personalDao.findAll());
        return "teacher/list";
    }
}
