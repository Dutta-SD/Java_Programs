package com.sandiplearns.springlearn.sample.enterprise.flow.web;

import com.sandiplearns.springlearn.sample.enterprise.flow.business.BusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// return in right format
// Controller is a specialised component
@RestController
public class Controller {

    @Autowired
    private BusinessService businessService;

    // API endpoint
    @GetMapping("/sum")
    public long displaySum() {
        // use business service
        return businessService.calculateSum();
    }

}