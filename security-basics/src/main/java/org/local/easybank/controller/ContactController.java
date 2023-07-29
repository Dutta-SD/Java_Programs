package org.local.easybank.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ContactController {
    @GetMapping("/contact")
    public String getContactDetails() {
        return "This is contact details";
    }
}
