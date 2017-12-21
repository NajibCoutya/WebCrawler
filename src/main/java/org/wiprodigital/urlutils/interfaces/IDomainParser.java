package org.wiprodigital.urlutils.interfaces;

import org.jsoup.select.Elements;


public interface IDomainParser {
    Elements getElements(String urlString, String... elementType);
}
