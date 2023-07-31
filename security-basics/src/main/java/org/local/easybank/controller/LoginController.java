package org.local.easybank.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.local.easybank.entity.EasyBankUser;
import org.local.easybank.repository.EasyBankUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class LoginController {

    private final EasyBankUserRepository easyBankUserRepository;

    @PostMapping("/register")
    public ResponseEntity<Object> registerNewUser(@RequestBody EasyBankUser user) {
        try {
            EasyBankUser save = easyBankUserRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(save);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
