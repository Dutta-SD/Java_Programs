package org.local.easybank.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class AccountController {
    @GetMapping(value = "/account")
    public String getAccountDetails() {
        return "Here are your account details";
    }
}
