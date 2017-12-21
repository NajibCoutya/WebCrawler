package org.wiprodigital.urlutils.implementation;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.wiprodigital.urlutils.interfaces.IDomainParser;

import static org.junit.Assert.assertEquals;

public class DomainParserTest {
    static String WEBSITE = "http://wiprodigital.com";
    static Elements parsedElements = null;
    static IDomainParser parser = null;

    @Before
    public void setup() {
        parser = new DomainParser();
    }

    @Test
    public void shouldFindLinks() {
        parsedElements = parser.getElements(WEBSITE, "a[href]", "img");
        assertEquals("Should have 84 parsed elements", 84, parsedElements.size());

    }

    @Test
    public void shouldContainWhoWeAreLink() {
        String whoWeAreURL = "http://wiprodigital.com/who-we-are";
        parsedElements = parser.getElements(WEBSITE, "a[href]");
        String soughtURL = null;
        for(Element element : parsedElements) {
            soughtURL = element.attr("href");
            if(whoWeAreURL.equals(soughtURL)) {
                break;
            }
        }
        assertEquals("Expect pared elements to contain who we are link", whoWeAreURL, soughtURL);

    }


}
