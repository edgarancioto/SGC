package sgc.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jdesktop.beansbinding.Converter;

public class DataConverter  extends Converter<Date, String> {

    private SimpleDateFormat format;

    public DataConverter() {
        this.format = new SimpleDateFormat("HH:mm");
    }

    public DataConverter(String simpleDateFormat) {
        this.format = new SimpleDateFormat(simpleDateFormat);
    }
    
    @Override
    public String convertForward(Date value) {
        return format.format(value);
    }

    @Override
    public Date convertReverse(String value) {
        Date data = null;
        try {
            return data = format.parse(value);
        } catch (ParseException ex) {
            data = null;
        }
        return data;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }
}