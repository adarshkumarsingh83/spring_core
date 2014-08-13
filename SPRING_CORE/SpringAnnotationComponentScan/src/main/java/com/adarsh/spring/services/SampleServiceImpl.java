package com.adarsh.spring.services;

import com.adarsh.spring.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Scope(value = "singleton")
@Service(value = "sampleServiceImpl")
public class SampleServiceImpl implements SampleService {


    @Autowired(required = true)
    @Qualifier("sampleRepositoryImpl")
    SampleRepository sampleRepository;

    public void setSampleRepository(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public String toString() {
        return "SampleService [sampleRepository=" + sampleRepository + "]";
    }

}
