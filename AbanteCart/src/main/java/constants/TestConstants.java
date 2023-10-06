package constants;

public final class TestConstants {

	private TestConstants() {
		
	}
	
	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH+"/executables/chromedriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
	
	
	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

}
