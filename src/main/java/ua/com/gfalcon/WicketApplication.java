package ua.com.gfalcon;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import ua.com.gfalcon.view.HomePage;



/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see ua.com.gfalcon.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }


    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();

        // add your configuration here
    }

}
