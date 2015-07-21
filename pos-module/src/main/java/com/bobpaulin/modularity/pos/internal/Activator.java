package com.bobpaulin.modularity.pos.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.bobpaulin.modularity.api.PartOfSpeechService;

public class Activator implements BundleActivator{
	
	@Override
	public void start(BundleContext context) throws Exception {
		context.registerService(PartOfSpeechService.class, new PartOfSpeechServiceImpl(), null);
		
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

