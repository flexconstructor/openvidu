package media.karamba.backend.api.client;

import com.google.common.util.concurrent.ListenableFuture;
import media.karamba.backend.api.grpc.CreateRoomResponse;

public interface KarambaBackendProviderAsync {

    ListenableFuture<CreateRoomResponse> createRoom(String roomName, String roomDescription,  String requestId) throws Exception;
}
