package com.ista.gestion_capacitaciones.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

    private static final String DATE_FORMAT = "MMM dd, yyyy h:mm:ss a";

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String dateString = jsonParser.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.US);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IOException("Failed to parse date: " + dateString, e);
        }
    }
}


