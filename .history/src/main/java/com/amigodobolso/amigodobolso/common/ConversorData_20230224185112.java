package com.amigodobolso.amigodobolso.common;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ConversorData {
    
    public static String converterDateParaDataEHora(java.util.Date date){

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return formatador.format(date);
    }
}
