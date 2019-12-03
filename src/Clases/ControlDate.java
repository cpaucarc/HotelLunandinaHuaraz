/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ANGEL
 */
public class ControlDate {
    // Métodos de fechas

    public String fecha_AMD(Date fecha) {
        SimpleDateFormat formatoAMD = new SimpleDateFormat("YYYY/MM/dd");
        return formatoAMD.format(fecha);//Retorna la fecha en tipo String
    }

    public Date Parse_Fecha(String fecha) {
        Date dat = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-d");
            dat = formato.parse(fecha);
        } catch (ParseException ex) {

        }
        return dat;
    }

    public int CalcularDias(JDateChooser fechaEntrada, JDateChooser fechaSalida) {
        int dias;
        if (fechaEntrada.getDate() != null && fechaSalida.getDate() != null) {
            Calendar fecha_Entrada = fechaEntrada.getCalendar();
            Calendar fecha_Salida = fechaSalida.getCalendar();
            dias = -1;
            while (fecha_Entrada.before(fecha_Salida) || fecha_Entrada.equals(fecha_Salida)) {
                dias++;
                fecha_Entrada.add(Calendar.DATE, 1);
            }
        } else {
            return dias = -1;
        }
        return dias;
    }

    public Date sumarDias(Date fecha, int dias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DAY_OF_YEAR, dias);
        return cal.getTime();
    }
}
