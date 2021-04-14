/*
 * Copyright (c) 2015 Espark And ©Adarsh Development Services @copyright All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Espark nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.espark.adarsh.test;

import com.espark.adarsh.bean.Employee;
import com.espark.adarsh.bean.Gender;
import com.espark.adarsh.validator.BeanValidator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class ValidationTest {

    @Qualifier(value = "validator")
    @Autowired(required = true)
    private BeanValidator<Employee> validator;

    @Test
    public void testBeanValidation1() throws Exception {
        Employee employee = new Employee() {
            {
                setFirstName("adarsh");
                setLastName("kumar");
                setGender(Gender.MALE);
                setEmailAddress("adarsh.kumar@espark.com");
                setDateOfBirth(getDob("13-sep-1983"));
            }
        };
        this.validator.validate(employee);
    }

    @Test
    public void testBeanValidation2() throws Exception {
        Employee employee = new Employee() {
            {
                setFirstName(" ");
                setLastName("kumar");
                setGender(Gender.MALE);
                setEmailAddress("adarsh.kumar@espark.com");
                setDateOfBirth(getDob("13-sep-2983"));
            }
        };
        Assertions.assertThrows(RuntimeException.class, () -> {
            this.validator.validate(employee);
        });

    }

    @Test
    public void testBeanValidation3() throws Exception {
        Employee employee = new Employee() {
            {
                setFirstName("adarsh");
                setLastName(" ");
                setGender(Gender.MALE);
                setEmailAddress("adarsh.kumar@espark.com");
                setDateOfBirth(getDob("13-sep-1983"));
            }
        };
        Assertions.assertThrows(RuntimeException.class, () -> {
            this.validator.validate(employee);
        });
    }

    @Test
    public void testBeanValidation4() throws Exception {
        Employee employee = new Employee() {
            {
                setFirstName("adarsh");
                setLastName("kumar ");
                setGender(Gender.MALE);
                setEmailAddress("adarsh.kumar.espark.com");
                setDateOfBirth(getDob("13-sep-2983"));
            }
        };
        Assertions.assertThrows(RuntimeException.class, () -> {
            this.validator.validate(employee);
        });
    }

    @Test
    public void testBeanValidation5() throws Exception {
        Employee employee = new Employee() {
            {
                setFirstName("adarsh");
                setLastName("kumar");
                setGender(Gender.MALE);
                setEmailAddress("adarsh.kumar@espark.com");
                setDateOfBirth(getDob("13-sep-2983"));
            }
        };
        Assertions.assertThrows(RuntimeException.class, () -> {
            this.validator.validate(employee);
        });
    }

    private Date getDob(String date) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        return formatter.parse(date);
    }

}
