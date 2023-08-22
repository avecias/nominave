/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mx.avecias.nominave.model.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import mx.avecias.nominave.model.enums.DateEnum;

/**
 *
 * @author avecias
 * date: Aug 18, 2023 1:20:22 PM
 *
 */
public class CfdiFormat {

    Date formatFecha(String a) throws ParseException {
        if(a == null || a.isEmpty()){
            return null;
        }return new SimpleDateFormat(DateEnum.ISO_8601DT.getValue()).parse(a);
    }

}
