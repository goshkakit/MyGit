package ru.ncedu.java.tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class DateCollectionsImpl implements DateCollections {
    int dateFormat = DateFormat.MEDIUM;
    @Override
    public void setDateStyle(int dateStyle) {
        this.dateFormat = dateStyle;
    }

    @Override
    public Calendar toCalendar(String dateString) throws ParseException {
        DateFormat df = DateFormat.getDateInstance(dateFormat);
        Date myDate = new Date();
        Calendar cal = null;
        try {
            myDate = df.parse(dateString);
            cal=Calendar.getInstance();
            cal.setTime(myDate);
            return cal;
        } catch (ParseException e){
            throw e;
        }
    }

    @Override
    public String toString(Calendar date) {
        return null;
    }

    @Override
    public void initMainMap(int elementsNumber, Calendar firstDate) {

    }

    @Override
    public void setMainMap(Map<String, Element> map) {

    }

    @Override
    public Map<String, Element> getMainMap() {
        return null;
    }

    @Override
    public SortedMap<String, Element> getSortedSubMap() {
        return null;
    }

    @Override
    public List<Element> getMainList() {
        return null;
    }

    @Override
    public void sortList(List<Element> list) {

    }

    @Override
    public void removeFromList(List<Element> list) {

    }

    public static void main(String[] args) {
        DateCollectionsImpl date = new DateCollectionsImpl();
        date.toCalendar("Jan 12, 1952");
    }
}
