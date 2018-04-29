package org.wiprodigital.urlutils.implementation;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.wiprodigital.urlutils.interfaces.IDomainParser;

import java.io.IOException;

//Master change
public class DomainParser implements IDomainParser {

    private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DomainParser.class);

    @Override
    public Elements getElements(String urlString, String... elementTypes) {
        Document document = null;
        Elements subdomainPages = new Elements();
        try {
            //we should use local interface to use external
            //libraries cleanly
            document = Jsoup.connect(urlString).get();
            for(String elementType : elementTypes) {
                subdomainPages.addAll(document.select(elementType));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return subdomainPages;
    }
}
