package com.codegym.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@Controller
public class AjaxController {
    @GetMapping("/")
    public String showindex(Model model){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("timenow", dtf.format(now));
        return "index";
    }

    @PostMapping(value = "/gettimezone")
    @ResponseBody
    public String createSmartphone(@RequestParam("val") String timezone) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone(timezone));
        String curentdate=df.format(date);
        return curentdate;
    }
}
