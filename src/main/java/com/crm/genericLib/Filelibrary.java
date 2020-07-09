package com.crm.genericLib;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Asish This Class Contains all file library related Information Like
 *         .property .xlx etc
 */

public class Filelibrary {
	/**
	 * read the Data from CommonData.propertiesfile
	 * @return Properties Object
	 * @throws Throwable
	 */
	public Properties getPropertiesObect() throws Throwable {

		FileInputStream inputStream = new FileInputStream("./testData/commonData.properties");
		Properties propObect = new Properties();
		propObect.load(inputStream);
		return propObect;

	}

}
