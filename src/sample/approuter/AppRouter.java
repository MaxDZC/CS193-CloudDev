package sample.approuter;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {

    public AppRouter() {
        this.addRouting("/{location}", "/#!/{location}");
        
        addRouting("/_ah/mail/{address}", "/mail/receive?address={address}");
        addRouting(
            "/{app}/edit/{key}/{version}",
            "/{app}/edit?key={key}&version={version}");
        addRouting(
            "/{app}/delete/{key}/{version}",
            "/{app}/delete?key={key}&version={version}");
        addRouting(
            "/{app}/find/*path",
            "/{app}/find?path={path}");
    }   
} 