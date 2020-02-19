package media.karamba.backend.api.client.impl;

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannel;
import media.karamba.backend.api.client.KarambaBackendProviderAsync;
import media.karamba.backend.api.config.KarambaBackendConfiguration;
import media.karamba.backend.api.grpc.CreateRoomRequest;
import media.karamba.backend.api.grpc.CreateRoomResponse;
import media.karamba.backend.api.grpc.MediaControlServiceGrpc;
import media.karamba.backend.api.utils.SignGenerator;

import java.util.Date;

public class KarambaBackendProviderAsyncImpl implements KarambaBackendProviderAsync {
    private final MediaControlServiceGrpc.MediaControlServiceFutureStub stub;
    private final KarambaBackendConfiguration configuration;

    public KarambaBackendProviderAsyncImpl(ManagedChannel channel, KarambaBackendConfiguration configuration) {
        stub = MediaControlServiceGrpc.newFutureStub(channel);
        this.configuration = configuration;
    }

    @Override
    public ListenableFuture<CreateRoomResponse> createRoom(String roomName, String roomDescription, String requestId) throws Exception {
        long timestamp = new Date().getTime();
        String accessToken = SignGenerator.generate();
        return this.stub.createRoom(CreateRoomRequest.newBuilder()

                .build());
    }
}
