package org.greyytechnologies.utils;

public class ConfigReader extends Baseclass
{
    public String getReportConfigPath()
    {
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if (reportConfigPath!= null)
            return reportConfigPath;
        else throw new RuntimeException("Report Config Path is not specified in the configuration.properties file");
    }
}
