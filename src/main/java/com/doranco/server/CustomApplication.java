package com.doranco.server;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.doranco.filter.AuthenticationFilter;
import com.doranco.filter.CORSFilter;


public class CustomApplication extends ResourceConfig  {
	
	public CustomApplication() {
    	
        packages("com.doranco.controller");
        
        register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
					        		 Level.INFO,
					        		 LoggingFeature.Verbosity.PAYLOAD_ANY,
					        		 10000
					        		)
        		);
 
       register(AuthenticationFilter.class);
//       register(CORSFilter.class);
    }

}
