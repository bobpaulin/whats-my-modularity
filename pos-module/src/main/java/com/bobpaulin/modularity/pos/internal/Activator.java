package com.bobpaulin.modularity.pos.internal;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.remoteserviceadmin.RemoteConstants;

import com.bobpaulin.modularity.api.PartOfSpeechService;

public class Activator implements BundleActivator{
	
	@Override
	public void start(BundleContext context) throws Exception {
		Dictionary props = new Properties();

		props.put(RemoteConstants.SERVICE_EXPORTED_INTERFACES, PartOfSpeechService.class.getName());
		context.registerService(PartOfSpeechService.class, new PartOfSpeechServiceImpl(), props);
		
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

