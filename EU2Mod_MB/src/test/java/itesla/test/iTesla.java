/**
 * Copyright (c) 2016, All partners of the iTesla project (http://www.itesla-project.eu/consortium)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package itesla.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;

import itesla.converter.Converter;
import itesla.converter.ParParser;

/**
 * @author Marc Sabate <sabatem@aia.es>
 */
public class iTesla {

	private static Converter converter;
	private static Converter converter_init;
	private static final String pathFRM = "C:\\Users\\sabaterm\\Documents\\iTesla\\Conversor Proves Nom\\edftur1c.frm";
	private static final String pathOUT = "C:\\Users\\sabaterm\\Documents\\iTesla\\Conversor Proves Nom\\";

	public static void main(String[] args) throws IOException {
		converter = new Converter(pathFRM, pathOUT, false);
		converter_init = new Converter(pathFRM, pathOUT, true);
		try {
			converter.convert2MO();
			//converter.printLinkNames();
			converter_init.convert2MO();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * Function that returns all the sets of parameters in a hashmap.
		 * The key of this hashmap is the reference id of the parameters set.
		 * The value of this hashmap is another hashmap wih the name of the parameter and its value
		 */
		HashMap<Integer, HashMap<String, String>> allParameterSets = converter.parData.getParameters();
		
		
		/*
		 * Function that returns a specific set of parameters given by its reference id
		 */
		Integer idSet = 2;
		HashMap<String, String> nthParameterSet = converter.parData.getSetParameters(idSet);
		
		for (Map.Entry<String, String> entry : nthParameterSet.entrySet()) {
			System.out.println(entry.getKey() + "; " + entry.getValue());
		}
		
		/*
		 * Function that returns the names of the input and output pins of the regulator in a listArray
		 */
//		List<String> pinNames = new ArrayList<String>();
//		pinNames = converter.getConnections();
//		for (String pinName : pinNames) {
//			System.out.println(pinName);
//		}
		
		
		HashMap<String, String> interfaceVariables = converter.getInterfaceVariables();
		for (Map.Entry<String, String> entry : interfaceVariables.entrySet()) {
			System.out.println(entry.getKey() + "; " + entry.getValue());
		}
		
		
		List<String> init_friParameters = converter.getInit_friParameters();
		for (String initParameter : init_friParameters) {
			System.out.println(initParameter);
		}
		System.out.println("-------------------");
		List<String> init_InterfaceParameters = converter.getInit_InterfaceParameters();
		for (String initInterfaceParameter : init_InterfaceParameters) {
			System.out.println(initInterfaceParameter);
		}
		
		System.out.println("THE END");		
	}

}
