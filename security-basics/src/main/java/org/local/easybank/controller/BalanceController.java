package org.local.easybank.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    @GetMapping("/balance")
    public String getBalanceDetails() {
        return "This is balance details from DB";
    }
}
