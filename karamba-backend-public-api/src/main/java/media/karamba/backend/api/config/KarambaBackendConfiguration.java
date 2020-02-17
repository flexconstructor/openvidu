package media.karamba.backend.api.config;


public class KarambaBackendConfiguration {
    private final String partersId;
    private final String applicationId;
    private final String applicationSecret;

    public KarambaBackendConfiguration(String partersId, String applicationId, String applicationSecret) {
        this.partersId = partersId;
        this.applicationId = applicationId;
        this.applicationSecret = applicationSecret;
    }

    public String getPartersId() {
        return partersId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getApplicationSecret() {
        return applicationSecret;
    }
}
