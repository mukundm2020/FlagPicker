/**
 * 
 */
package com.hcl.flagpicker.util;

import org.springframework.stereotype.Component;

/**
 * @author Dinesh P
 *
 */
@Component
public class FlagUtils {
	public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }

}
