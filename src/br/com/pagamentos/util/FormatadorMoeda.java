package br.com.pagamentos.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatadorMoeda {

    private FormatadorMoeda(){
    }

    public static String formatar (BigDecimal valor){
        NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        return formato.format(valor);
    }

}
