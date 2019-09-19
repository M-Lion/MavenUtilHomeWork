package MavenHomeWork;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

    public class LoadProps {

        static Properties props;

        static FileInputStream inputStream;

        public String getProperty(String key) {

            props = new Properties();
            try {
                inputStream = new FileInputStream("src\\main\\Resources\\BrowserDriver\\testdataConfig.properties");
                props.load(inputStream);
                inputStream.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return props.getProperty(key);
        }

        @Test

        public void trialTest() {
            System.out.println(getProperty("url"));
        }

    }


