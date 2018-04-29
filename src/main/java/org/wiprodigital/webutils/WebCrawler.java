package org.wiprodigital.webutils;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.wiprodigital.urlutils.implementation.DomainParser;
import org.wiprodigital.urlutils.interfaces.IDomainParser;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WebCrawler {

    private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(WebCrawler.class);

    public static void main(String[] args) {

        //starter domain page for the crawler
        String mainDomain = args[0];

        //list of sub domain pages to be crawled
        Queue<String> pagesForCrawling = new LinkedList<>();
        pagesForCrawling.add(mainDomain);

        //Set of already crawled domain pages
        HashSet<String> crawledPages = new HashSet<>();
        crawledPages.add(mainDomain);

        while (!pagesForCrawling.isEmpty()) {
		//change to master
            String domainPage = pagesForCrawling.poll();
            logger.info("[BEGIN CRAWLING WEBSITE] ["+ domainPage + "]");

            IDomainParser parser = new DomainParser();

            Elements elements = parser.getElements(mainDomain, "a[href]", "img");

            if (elements == null) continue;

            for(Element element : elements) {
                String foundPage = element.attr("href");
                String staticPage = element.attr("src");

                if(foundPage.matches("http.*")) {
                    if (!foundPage.matches(mainDomain + ".*")) {
                        logger.info("[EXTERNAL SITE] [" + foundPage + "]");
                    } else if (!crawledPages.contains(foundPage)) {
                        crawledPages.add(foundPage);
                        logger.info("[SUB-DOMAIN PAGE] [" + foundPage + "]");
                        pagesForCrawling.add(foundPage);
                    }
                }

                if(staticPage.matches("http.*")) {
                    logger.info("[STATIC PAGE] [" + staticPage + "]");
                }
            }

            logger.info("[FINISHED CRAWLING SUB-DOMAIN PAGE]\n\n");
        }

        logger.info("[END CRAWLING WEBSITE]\n\n");
    }

}

