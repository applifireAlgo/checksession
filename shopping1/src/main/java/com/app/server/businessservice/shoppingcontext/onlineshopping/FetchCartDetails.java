package com.app.server.businessservice.shoppingcontext.onlineshopping;
import com.app.server.businessservice.shoppingcontext.FetchCartDetailsBzService;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import java.util.List;

@Component
public class FetchCartDetails {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private FetchCartDetailsBzService fetchCartDetailsBzService;

    @Autowired
    private SessionDataMgtService sessionService;

    public List<com.app.shared.shoppingcontext.FetchCartDetails> fetchcartDetails() throws SpartanDataNotFoundException, Exception {
        java.lang.String userIdFromSession = (java.lang.String) sessionService.getSessionData("userId");
        if (userIdFromSession == null) {
            throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
        }
        java.util.List<com.app.shared.shoppingcontext.FetchCartDetails> fetchCartDetailsList1 = fetchCartDetailsBzService.executeQueryFetchCartDetails(userIdFromSession);
        return fetchCartDetailsList1;
    }
}
