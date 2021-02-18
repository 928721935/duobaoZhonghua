package com.jida.common.util;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

@Slf4j
public class Dom4jUtil {
    public static void createXml(){
        Element people = DocumentHelper.createElement("people");
        Element name = DocumentHelper.createElement("name");
        Element age = DocumentHelper.createElement("age");
        Element sex = DocumentHelper.createElement("sex");
        people.add(name);
        people.add(age);
        people.add(sex);
        name.addAttribute("a","1");
        Document document = DocumentHelper.createDocument(people);
        log.info(document.asXML());
        try {
            Document document1 = DocumentHelper.parseText(document.asXML());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createXml();
    }
}
