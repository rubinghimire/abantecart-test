package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;
import constants.TestConstants;

public final class PropertyFileReader {

	private PropertyFileReader() {

	}

	private static Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<>();

	static {
		try {
			FileInputStream file = new FileInputStream(TestConstants.getConfigFilePath());
			property.load(file);
			for(Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
			// For each alternative
			// property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static String get(String key) throws IncorrectPropertyException {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
			throw new PropertyFileReader().new IncorrectPropertyException("Property: " + key + "not found");
		}
		return CONFIGMAP.get(key);
	}
	
	
	class IncorrectPropertyException extends Exception {
		private static final long serialVersionUID = 1L;

		public IncorrectPropertyException(String errorMessage) {
			super(errorMessage);
		}
	}
}

