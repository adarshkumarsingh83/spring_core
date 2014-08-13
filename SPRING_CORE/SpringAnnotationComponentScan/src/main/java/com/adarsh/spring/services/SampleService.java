package com.adarsh.spring.services;

import com.adarsh.spring.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public interface SampleService {

    public String toString();

    public void setSampleRepository(SampleRepository sampleRepository);

}
