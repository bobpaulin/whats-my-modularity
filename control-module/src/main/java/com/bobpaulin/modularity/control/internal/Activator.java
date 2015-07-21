package com.bobpaulin.modularity.control.internal;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.bobpaulin.modularity.api.MediaParser;
import com.bobpaulin.modularity.api.PartOfSpeechService;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		MediaParser mediaParser = context.getService(context.getServiceReference(MediaParser.class));
		PartOfSpeechService posService = context.getService(context.getServiceReference(PartOfSpeechService.class));
		
		ControlCommand command = new ControlCommand();
		command.setMediaParser(mediaParser);
		command.setPosService(posService);
		
		
		Hashtable config = new Hashtable();
		config.put("osgi.command.scope", "mod");
		config.put("osgi.command.function", new String[] { "convert" });

		context.registerService(ControlCommand.class, command, config);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
