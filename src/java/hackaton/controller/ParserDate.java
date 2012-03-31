package hackaton.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParserDate {

    public Date parseDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date datum = new Date();
            String datumRet = format.format(datum);
            Date datumparse = format.parse(date);
            return datumparse;
        } catch (Exception e) {
            return null;
        }
    }
}
