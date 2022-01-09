package com.sandiplearns.springlearn.sample.enterprise.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Business Logic
@Component
class BusinessService {
    public long calculateSum() {
        return 150;
    }

}

// return in right format
// Controller is a specialised component
@RestController
public class Controller {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/sum")
    public long displaySum() {
        // use business service
        return businessService.calculateSum();
    }

}

// get data
class DataService {

}