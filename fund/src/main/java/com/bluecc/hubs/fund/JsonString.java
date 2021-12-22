package com.bluecc.hubs.fund;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonString {
    String value;
    public static JsonString string(String value){
        return new JsonString(value);
    }
}

