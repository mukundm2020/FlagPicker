/**
 * 
 */
package com.hcl.flagpicker.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Dinesh P
 *
 */
@Aspect
@Component
public class FlagAspects {
	@Before("execution(* com.hcl.flagpicker.service.*.*(..))")
	public void beforeGetFlagByCountry() {
		System.out.println("before get flag by country !! -----------------------------------------------");
	}

}
