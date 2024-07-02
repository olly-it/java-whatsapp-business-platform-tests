package it.olly.whatsapp4business.controller;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/**")
public class WebhookController {

    @GetMapping
    @ResponseBody
    public String get(HttpServletRequest request) {
        System.out.println("GOT GET REQUEST - " + request.getServletPath() + " ? " + request.getQueryString());
        String mode = request.getParameter("hub.mode");
        if (mode != null && mode.equalsIgnoreCase("subscribe")) {
            return request.getParameter("hub.challenge");
        }
        return "";
    }

    @PostMapping
    public void post(HttpServletRequest request) {
        System.out.println("GOT POST REQUEST - " + request.getServletPath() + " ? " + request.getQueryString());
        try {
            String string = IOUtils.toString(request.getReader());
            System.out.println("BODY: " + string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
