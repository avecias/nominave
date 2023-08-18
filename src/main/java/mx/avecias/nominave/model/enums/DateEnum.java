/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package mx.avecias.nominave.model.enums;

/**
 *
 * @author avecias
 */
public enum DateEnum {
    
    ISO_8601DT("yyyy-MM-dd'T'HH:mm:ss");

    private final String value;

    private DateEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
    
}
