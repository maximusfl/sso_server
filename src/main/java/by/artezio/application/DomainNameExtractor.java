package by.artezio.application;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DomainNameExtractor {

    public String extractDomainName(String url) {
        int start = url.indexOf("://");
        if (start < 0) {
            start = 0;
        } else {
            start += 3;
        }
        int end = url.indexOf('/', start);
        if (end < 0) {
            end = url.length();
        }
        String domainName = url.substring(start, end);

        int port = domainName.indexOf(':');
        if (port >= 0) {
            domainName = domainName.substring(0, port);
        }
        return domainName;
    }
}
