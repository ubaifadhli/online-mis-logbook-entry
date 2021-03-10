import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class ApplicationProperties {
    private final ClassLoader classLoader = getClass().getClassLoader();
    private Properties properties;

    public ApplicationProperties() {
        try {
            properties = new Properties();

            InputStream rootPath = classLoader.getResourceAsStream("application.properties");

            properties.load(rootPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public String getFilePath(String propertyName) throws URISyntaxException {
        String propertyValue = getProperty(propertyName);

        URL filePath = classLoader.getResource(propertyValue);

        if (filePath == null)
            throw new IllegalArgumentException("File not found. " + propertyName);
        else
            return new File(filePath.toURI()).getPath();
    }
}
