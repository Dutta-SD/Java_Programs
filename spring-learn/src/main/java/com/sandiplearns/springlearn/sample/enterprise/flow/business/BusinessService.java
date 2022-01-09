// Business Logic
package com.sandiplearns.springlearn.sample.enterprise.flow.business;

import java.util.List;

import com.sandiplearns.springlearn.sample.enterprise.flow.data.DataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessService {

    @Autowired
    private DataService dataService;

    // Calculate sum with passed parameter
    public long calculateSum() {
        List<Integer> data = dataService.retrieveData();
        return data.stream().reduce(Integer::sum).get();
    }
}