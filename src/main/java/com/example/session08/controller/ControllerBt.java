package com.example.session08.controller;

import com.example.session08.model.Employee;
import com.example.session08.model.User;
import com.example.session08.model.UserBt05;
import com.example.session08.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ControllerBt {
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user,
                             BindingResult result,
                             Model model) {
        userValidator.validate(user, result);

        if (result.hasErrors()) {
            return "registration";
        }

        model.addAttribute("user", user);
        return "result";
    }

//    Bt05
    @GetMapping("/users")
    public ModelAndView listUsers() {
        List<UserBt05> users = new ArrayList<>();
        users.add(new UserBt05("Nguyễn Văn A", 25, new Date(1999 - 1900, 4, 15), "a@gmail.com", "0912345678"));
        users.add(new UserBt05("Trần Thị B", 30, new Date(1994 - 1900, 1, 22), "b@yahoo.com", "0987654321"));
        users.add(new UserBt05("Lê Văn C", 28, new Date(1996 - 1900, 7, 3), "c@hotmail.com", "0909090909"));

        ModelAndView modelAndView = new ModelAndView("userList");
        modelAndView.addObject("users", users);

        return modelAndView;
    }

//    Bt06
private List<Employee> employeeList = new ArrayList<>();

    @GetMapping("/employees")
    public String listEmployees(Model model, @RequestParam(value = "success",required = false) String success) {
        model.addAttribute("employees", employeeList);
        model.addAttribute("success", success);
        return "listEmployee";
    }

    @GetMapping("/employees/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/employees")
    public String addEmployee(@ModelAttribute("employee") Employee employee,
                              RedirectAttributes redirectAttributes) {
        employeeList.add(employee);
        redirectAttributes.addAttribute("success", "Thêm nhân viên thành công!");
        return "redirect:/employees";
    }
}
