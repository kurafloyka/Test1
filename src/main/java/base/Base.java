package base;


import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Date;

public class Base {
    public static WebDriver webDriver= null;
    public static Logger LOGGER = LoggerFactory.getLogger(Base.class);
    public Timestamp timestamp;
    public Date date;

}
