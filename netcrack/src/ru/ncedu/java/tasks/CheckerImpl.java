package ru.ncedu.java.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckerImpl implements Checker {
    Pattern newPattern;
    @Override
    public Pattern getPLSQLNamesPattern() {
        return newPattern = Pattern.compile("^[a-zA-Z][\\w_$]{0,29}$");
    }

    @Override
    public Pattern getHrefURLPattern() {
        return newPattern = Pattern.compile("^<[\\s\\n\\t\\r]?[a-zA-Z][\\s\\n\\t\\r]?[hH][rR][eE][fF][\\s\\n\\t\\r]?.+/?[\\s\\n\\t\\r]?>$");
    }

    @Override
    public Pattern getEMailPattern() {
        return newPattern = Pattern.compile("^[-\\w.&&[^-._]][-\\w.]{0,20}[-\\w.&&[^-._]]@([A-z0-9][-A-z0-9]+\\.)+(ru|com|net|org)$");
    }

    @Override
    public boolean checkAccordance(String inputString, Pattern pattern) throws IllegalArgumentException {
        if(inputString == null && pattern == null){
            return true;
        } else if(inputString == null||pattern == null){
            throw new IllegalArgumentException();
        } else {
            Matcher m = newPattern.matcher(inputString);
            return m.matches();
        }
    }

    @Override
    public List<String> fetchAllTemplates(StringBuffer inputString, Pattern pattern) throws IllegalArgumentException {
        if(inputString == null||pattern == null){
            throw new IllegalArgumentException();
        } else {
            return Arrays.asList(inputString.toString().split("^pattern.pattern().toString()"));
        }
    }

    public static void main(String[] args) {
        CheckerImpl checker = new CheckerImpl();
        System.out.println(checker.checkAccordance("qqqqq@gmail.ru.org", checker.getEMailPattern()));
    }
}
