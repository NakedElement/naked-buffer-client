package uk.co.nakedelement.bufferclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class TestingProperties 
{
	private static final Logger log = Logger.getLogger(TestingProperties.class);

	private final Properties props = new Properties();

	public TestingProperties(String propsFileName)
	{
		loadProps(new File("src/test/resources/" + propsFileName), props);	
		loadProps(getLocalUserPropeFilePath(propsFileName), props);			
	}


	public String getProperty(String key)
	{
		return props.getProperty(key);
	}

	public String getProperty(String key, String defaultValue)
	{
		return props.getProperty(key, defaultValue);
	}

	private static File getLocalUserPropeFilePath(String propsFileName)
	{
		final File userHome = new File(System.getProperty("user.home"));
		return new File(userHome, propsFileName);
	}

	private static void loadProps(File propertyFilePath, Properties props)
	{

		if (propertyFilePath.exists())
		{
			log.info("Properties files: " + propertyFilePath.getAbsolutePath());

			try
			{
				final FileInputStream in = new FileInputStream(propertyFilePath);

				try
				{
					props.load(in);
				}
				finally
				{
					in.close();
				}
			} 
			catch (IOException e) 
			{
				throw new RuntimeException(e);
			}
		}
	}
}

