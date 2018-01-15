package com.ljm.server.protocol.http.header;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedListMultimap;
import com.ljm.server.protocol.http.HttpHeader;
import com.ljm.server.protocol.http.IMessageHeaders;

import java.util.List;
import java.util.Set;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public class HttpMessageHeaders implements IMessageHeaders {

    private final LinkedListMultimap<String, HttpHeader> headersMultiMap;

    public HttpMessageHeaders() {
        this.headersMultiMap = LinkedListMultimap.create();
    }

    @Override
    public List<HttpHeader> getHeader(String headerName) {
        return this.headersMultiMap.get(headerName);
    }

    @Override
    public List<HttpHeader> getHeaders() {
        return this.headersMultiMap.values();
    }

    @Override
    public void addHeader(HttpHeader httpHeader) {
        this.headersMultiMap.put(httpHeader.getName(), httpHeader);
    }

    @Override
    public void removeHeader(HttpHeader httpHeader) {
        this.headersMultiMap.remove(httpHeader.getName(), httpHeader);
    }

    @Override
    public void removeHeaders(String headerName) {
        this.headersMultiMap.removeAll(headerName);
    }


    @Override
    public boolean hasHeader(String headerName) {
        return this.headersMultiMap.containsKey(headerName);
    }

    @Override
    public Set<String> getHeaderNames() {
        return this.headersMultiMap.keySet();
    }
}
