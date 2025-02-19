package com.aspro.aspro.util;

import java.math.BigDecimal;

public class ValueParser {
    public static Long parseLong(String value){
        Long result;
        try{
            result  = Long.valueOf(value);
        } catch(NumberFormatException e){
            result = null;
        }
        return result;
    }

    public static BigDecimal parseBigDecimal(String value){
        BigDecimal result;
        try{
            result = new BigDecimal(value);
        } catch (NumberFormatException e){
            result = null;
        }
        return result;
    }

    public static Short parseShort(String value){
        Short result;
        try{
            result = Short.valueOf(value);
        } catch(NumberFormatException e){
            result = null;
        }
        return result;
    }
}
