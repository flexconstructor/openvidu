package media.karamba.backend.api.client.impl;

import media.karamba.backend.api.client.KarambaBackendProvider;
import media.karamba.backend.api.config.KarambaBackendConfiguration;
import media.karamba.backend.api.grpc.CreateRoomRequest;
import media.karamba.backend.api.grpc.CreateRoomResponse;
import media.karamba.backend.api.grpc.MediaControlServiceGrpc;
import media.karamba.backend.api.utils.SignGenerator;

import java.util.Date;

public class KarambaBackendProviderImpl  implements KarambaBackendProvider {
    private final MediaControlServiceGrpc.MediaControlServiceBlockingStub stub;
    private final KarambaBackendConfiguration configuration;

    public KarambaBackendProviderImpl(MediaControlServiceGrpc.MediaControlServiceBlockingStub stub,
                                      KarambaBackendConfiguration configuration) {
        this.stub = stub;
        this.configuration = configuration;
    }

    @Override
    public CreateRoomResponse createRoom(String roomName, String requestId) throws Exception {
        long timestamp = new Date().getTime();
        String accessToken = SignGenerator.generate();
        return this.stub.createRoom(CreateRoomRequest.newBuilder()
                .setPartnerID(configuration.getPartersId())
                .setRequestTimestamp(timestamp)
                .setRequestKey(requestId)
                .setAccessToken(accessToken)
                .build());
    }
}
