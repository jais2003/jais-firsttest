public class DriverManagerFactory {
    public static  DriverManager getManger(DriverType type)
    {
        DriverManager driverManager = null;
        switch (type)
        {
            case CHROME:
                driverManager = new ChromeDriverManger();
                break;
//            case FIREFOX:
//                driverManager = new FirefoxDriverManager();
//                break;
//            default:
//                driverManager = new EdgeDriverManager();
//                break;

        }
        return driverManager;
    }

}