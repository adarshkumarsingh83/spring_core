package com.adarsh.spring.manager;

import com.adarsh.spring.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Scope(value = "singleton")
@Service(value = "sampleManagerImpl")
public class SampleManagerImpl implements SampleManager {

    @Autowired
    SampleRepository sampleRepository;

    public void setSampleRepository(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public String toString() {
        return "SampleService [customerDAO=" + sampleRepository + "]";
    }

}
