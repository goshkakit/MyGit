package ru.ncedu.java.tasks;

import java.util.*;

public class StringFilterImpl implements StringFilter {
    public StringFilterImpl() {
    }

    ArrayList<String> strings = new ArrayList<String>();

    @Override
    public void add(String s) {
        if (s != null) {
            s = s.toLowerCase();
            if (!strings.contains(s)) {
                strings.add(s);
            }
        } else {
            strings.add(s);
        }
    }

    @Override
    public boolean remove(String s) {
        if (s != null) {
            if (strings.contains(s.toLowerCase())) {
                strings.remove(s);
                return true;
            } else {
                return false;
            }
        } else {
            if (strings.contains(null)) {
                strings.remove(null);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void removeAll() {
        strings.clear();
    }


    @Override
    public Collection<String> getCollection() {
        return strings;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {
        Iterator<String> iterator = strings.iterator();
        if (chars == null || chars.equals("")) {
            return iterator;
        } else {
            ArrayList<String> stringsFiltered = new ArrayList<String>();
            while (iterator.hasNext()) {
                String addStr = iterator.next();
                if (addStr != null && addStr.contains(chars)) {
                    stringsFiltered.add(addStr);
                }
            }
            return stringsFiltered.iterator();
        }
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        Iterator<String> iterator = strings.iterator();
        if (begin == null || begin.equals("")) {
            return iterator;
        } else {
            ArrayList<String> stringsFiltered = new ArrayList<String>();
            while (iterator.hasNext()) {
                String addStr = iterator.next();
                if (addStr != null && addStr.startsWith(begin.toLowerCase())) {
                    stringsFiltered.add(addStr);
                }
            }
            return stringsFiltered.iterator();
        }
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        Iterator<String> iterator = strings.iterator();
        if (format == null || format.equals("")) {
            return iterator;
        } else {
            ArrayList<String> stringsFiltered = new ArrayList<String>();
            while (iterator.hasNext()) {
                String addStr = iterator.next();
                boolean equal = true;
                if (addStr != null && addStr.length() == format.length()) {
                    String[] splittedFormat = format.split("#");
                    String[] splittedString = addStr.split("[0-9]");
                    if (splittedFormat.length == splittedString.length) {
                        for (int i = 0; i < splittedString.length; i++) {
                            if (!splittedFormat[i].equals(splittedString[i])) {
                                equal = false;
                            }
                        }
                    }else{
                        equal = false;
                    }
                    if (equal) {
                        stringsFiltered.add(addStr);
                    }
                }
            }
            return stringsFiltered.iterator();
        }
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        Iterator<String> iterator = strings.iterator();
        if (pattern == null || pattern.equals("")) {
            return iterator;
        } else {
            ArrayList<String> stringsFiltered = new ArrayList<String>();
            int equal = 0;
            while (iterator.hasNext()) {
                String addStr = iterator.next();
                if(pattern.contains("*")) {
                    String[] splittedPattern = pattern.split("\\*");
                    int newSize = splittedPattern.length;
                    if (addStr != null) {
                        for (int i = 0; i < splittedPattern.length; i++) {
                            if(!splittedPattern[i].equals("")) {
                                if (addStr.contains(splittedPattern[i])) {
                                    equal++;
                                }
                            } else {
                                newSize--;
                            }
                        }
                        if (equal==newSize) {
                            stringsFiltered.add(addStr);
                        }
                        equal=0;
                    }
                }
            }
            return stringsFiltered.iterator();
        }
    }

    public static void main(String[] args) {
        StringFilterImpl list = new StringFilterImpl();
        list.add("ss.ssssEE#333");
        list.add("d");
        list.add(null);
        list.add("-(4- 56)=");
        list.add("reflect");
        list.add("protect");
        list.getCollection();
        list.getStringsByPattern("*ect");
        list.remove("d");
    }
}
