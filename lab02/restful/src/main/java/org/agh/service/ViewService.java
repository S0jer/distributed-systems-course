package org.agh.service;


import org.springframework.stereotype.Service;

@Service
public class ViewService {
    public String getSearchPage() {
        return "form";
    }

    public String getResultPage() {
        return "response";
    }

    public String getLoginPage() {
        return "start";
    }
}
