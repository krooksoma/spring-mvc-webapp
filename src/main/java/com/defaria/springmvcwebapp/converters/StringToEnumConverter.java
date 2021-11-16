package com.defaria.springmvcwebapp.converters;

import com.defaria.springmvcwebapp.beans.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {

        switch (source) {
            case "Male":
                return Gender.MALE;
            case "Female":
                return Gender.FEMALE;
            case "Non-Binary":
                return Gender.NONBINARY;
            default:
                return Gender.OTHERS;
        }

    }


}
