package com.adarsh.spring.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
@Scope(value = "singleton")
@Repository(value ="sampleRepositoryImpl" )
public class SampleRepositoryImpl implements SampleRepository{

    @Override
    public String toString() {
        return "Hello , This is SampleRepository";
    }
}
