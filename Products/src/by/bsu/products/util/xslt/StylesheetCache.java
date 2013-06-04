/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsu.products.util.xslt;

import java.io.*;
import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

/**
 * A utility class that caches XSLT stylesheets in memory.
 * 
*/
public final class StylesheetCache {

    ////http://onjava.com/pub/a/onjava/excerpt/java_xslt_ch5/index.html?page=9
    private static Map<String, Templates> cache = new HashMap();
    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static Transformer newTransformer(String xsltFileName)
            throws TransformerConfigurationException {

        File xsltFile = new File(xsltFileName);
        Templates template = cache.get(xsltFileName);

        if (template == null) {
            lock.writeLock().lock();
            try {
                if (!cache.containsKey(xsltFileName)) {
                    Source xslSource = new StreamSource(xsltFile);
                    TransformerFactory transFact = TransformerFactory.newInstance();
                    Templates templates = transFact.newTemplates(xslSource);
                    template = templates;
                    cache.put(xsltFileName, template);
                }
                else {
                    template = cache.get(xsltFileName);
                }
            } finally {
                lock.writeLock().unlock();
            }
        }

        return template.newTransformer();
    }

    private StylesheetCache() {
    }
}
