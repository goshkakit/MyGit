package ru.ncedu.java.tasks;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordProcessorImpl implements WordProcessor {
    public String lineField = null;
    @Override
    public String getText() {
        //может понадобиться проверка на неудачный set
        return lineField;
    }

    @Override
    public void setSource(String src) throws IllegalArgumentException{
        if(src == null){
            throw new IllegalArgumentException();
        }else {
            lineField = src;
        }
    }

    @Override
    public void setSourceFile(String srcFile) throws IOException,IllegalArgumentException {
        if(srcFile == null){
            throw new IllegalArgumentException();
        }else {
            byte[] encoded = Files.readAllBytes(Paths.get(srcFile));
            lineField = new String(encoded);
        }
    }

    @Override
    public void setSource(FileInputStream fis) throws IOException,IllegalArgumentException {
        if(fis == null){
            throw new IllegalArgumentException();
        }else {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, fis.available());
            lineField = new String(buffer);
        }
    }

    @Override
    public Set<String> wordsStartWith(String begin) throws IllegalStateException {
        if (lineField == null) {
            throw new IllegalStateException();
        } else {
            lineField = lineField.toLowerCase();
            Set<String> set = new HashSet<String>(Arrays.asList(lineField.split("[\\s\\n\\t\\r]+")));
            Iterator<String> iterator = set.iterator();
            Set<String> newSet = new HashSet<>();
            if (begin == null || begin.equals("")) {
                return set;
            } else {
                while (iterator.hasNext()) {
                    String addStr = iterator.next();
                    if (addStr.startsWith(begin.toLowerCase())) {
                        newSet.add(addStr);
                    }
                }
            }
            return newSet;
        }
    }

    public static void main(String[] args) {
        WordProcessorImpl text = new WordProcessorImpl();
        text.setSource("hey been  h  f    f   f  j  iiii    ip hey");
        System.out.println(text.wordsStartWith("h"));
        System.out.println(text.getText());
    }
}
