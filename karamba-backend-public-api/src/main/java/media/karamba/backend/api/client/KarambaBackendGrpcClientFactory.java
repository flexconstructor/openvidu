package media.karamba.backend.api.client;

import io.grpc.ManagedChannel;
import media.karamba.backend.api.client.impl.KarambaBackendProviderAsyncImpl;
import media.karamba.backend.api.client.impl.KarambaBackendProviderImpl;
import media.karamba.backend.api.config.KarambaBackendConfiguration;

public class KarambaBackendGrpcClientFactory {

    private static KarambaBackendProviderAsync backendProviderAsync;
    private static KarambaBackendProvider backendProvider;

    public static KarambaBackendProviderAsync createAsyncProvider(ManagedChannel channel,
                                                                  KarambaBackendConfiguration configuration) throws Exception {
        if (backendProvider != null) {
            throw new Exception("Backend provider already exists");
        }

        if (backendProviderAsync != null) {
            return backendProviderAsync;
        }

        backendProviderAsync = new KarambaBackendProviderAsyncImpl(channel, configuration);
        return backendProviderAsync;

    }

    public static KarambaBackendProvider createBlockedProvider(ManagedChannel channel,
                                                               KarambaBackendConfiguration configuration) throws Exception {
        if (backendProviderAsync != null) {
            throw new Exception("Backend provider already exists");
        }

        if (backendProvider != null) {
            return backendProvider;
        }

        backendProvider = new KarambaBackendProviderImpl( channel, configuration);
        return backendProvider;
    }
}
