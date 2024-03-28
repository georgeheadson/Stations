package org.example.stations.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DefaultController {

    /**
     * Метод формирует страницу из HTML-файла index.html,
     * который находится в папке resources/templates.
     * Это делает библиотека Thymeleaf.
     */
    @RequestMapping("/")
    public String index() {
        return "redirect:/mixedup";
    }

    @RequestMapping("/mixedup")
    public ModelAndView mixedup() {
        List<String> items = new ArrayList<String>();
        items.add("Simple Item 1");
        items.add("Simple Item 2");
        items.add("Simple Item 3");
        items.add("Simple Item 4");
        items.add("Simple Item 5");

        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("mixedup");
        retVal.addObject("listTitle", "<span style=\"color: green;\">A Test Unordered List</span>");
        retVal.addObject("items", items);

        return retVal;
    }

}