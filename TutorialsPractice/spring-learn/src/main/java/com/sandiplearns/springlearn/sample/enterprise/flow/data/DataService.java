// get data
package com.sandiplearns.springlearn.sample.enterprise.flow.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DataService {
    public List<Integer> retrieveData() {
        return Arrays.asList(12, -24, 56, 78, 90);
    }

}
