package utilities;
public class EnvConfig {

    private String baseUrl;
    private String excelFilePath;
    private String LinkedinURL;

    public EnvConfig() {
        // Load configuration values from properties files, environment variables, or any other source.
        // For simplicity, we'll hardcode values here.
        baseUrl = "https://bookcart.azurewebsites.net/login";
        LinkedinURL = "https://www.linkedin.com/home";
        excelFilePath = "C:\\Users\\ykorvi\\Desktop\\TestData.xlsx";
    }

    public String getBaseUrl() 
    {
        return baseUrl;
    }

    public String getExcelFilePath() {
        return excelFilePath;
    }
    
   
	public String LinkedinURL() 
	{
		// TODO Auto-generated method stub
		return LinkedinURL;
	}
}
