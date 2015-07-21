package com.bobpaulin.modularity.parser.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.bobpaulin.modularity.api.MediaParser;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		context.registerService(MediaParser.class, new MediaParserImpl(), null);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
