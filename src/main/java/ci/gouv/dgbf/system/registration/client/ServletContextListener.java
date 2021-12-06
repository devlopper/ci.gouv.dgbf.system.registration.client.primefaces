package ci.gouv.dgbf.system.registration.client;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

import org.cyk.user.interface_.theme.web.jsf.primefaces.atlantis.dgbf.DesktopDefault;
import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.client.controller.component.menu.MenuBuilderMapInstantiator;
import org.cyk.utility.client.deployment.AbstractServletContextListener;

@WebListener
public class ServletContextListener extends AbstractServletContextListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(ServletContext context) {
		super.__initialize__(context);
		DependencyInjection.setQualifierClassTo(ci.gouv.dgbf.system.registration.server.api.System.class, MenuBuilderMapInstantiator.class/*,EntitySaver.class*/);
		DesktopDefault.initialize(null,null);
		org.cyk.utility.security.keycloak.client.ApplicationScopeLifeCycleListener.enable(context, "/keycloak/*","/private/*");
	}	
}