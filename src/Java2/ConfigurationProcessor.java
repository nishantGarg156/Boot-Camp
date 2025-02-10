package Java2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigurationProcessor {
    public static class ConfigurationException extends Exception {
        public ConfigurationException(String message) {
            super(message);
        }
    }
    public class Configuration {
        private String databaseUrl;
        private int maxConnections;
        private boolean debugMode;
        public Configuration(String databaseUrl, int maxConnections, boolean debugMode) {
            this.databaseUrl = databaseUrl;
            this.maxConnections = maxConnections;
            this.debugMode = debugMode;
        }
        @Override
        public String toString() {
            return String.format("Config{url='%s', maxConn=%d, debug=%b}",
                    databaseUrl, maxConnections, debugMode);
        }
    }
    public Configuration readConfiguration(String filePath)
            throws FileNotFoundException, ConfigurationException {
        if (filePath == null) {
            throw new NullPointerException("File path cannot be null");
        }
        try (Scanner scanner = new Scanner(new File(filePath))) {
            if (!scanner.hasNextLine()) {
                throw new ConfigurationException("Empty configuration file");
            }
            String[] configs = new String[3];
            for (int i = 0; i < 3; i++) {
                if (!scanner.hasNextLine()) {
                    throw new ConfigurationException("Incomplete configuration");
                }
                configs[i] = scanner.nextLine().trim();
            }
            try {
                return new Configuration(
                        configs[0],
                        Integer.parseInt(configs[1]),
                        Boolean.parseBoolean(configs[2])
                );
            } catch (NumberFormatException e) {
                throw new ConfigurationException("Invalid numeric configuration");
            }
        }
    }
    public static void main(String[] args) {
        ConfigurationProcessor processor = new ConfigurationProcessor();

        try {
            Configuration config = processor.readConfiguration("config.txt");
            System.out.println("Configuration loaded: " + config);
        } catch (FileNotFoundException e) {
            System.err.println("Configuration file not found");
        } catch (ConfigurationException e) {
            System.err.println("Configuration error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Null pointer error: " + e.getMessage());
        }
    }
}
