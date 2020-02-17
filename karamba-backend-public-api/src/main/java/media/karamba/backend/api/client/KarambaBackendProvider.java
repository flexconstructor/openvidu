package media.karamba.backend.api.client;

import com.google.common.util.concurrent.ListenableFuture;
import media.karamba.backend.api.grpc.CreateRoomRequest;
import media.karamba.backend.api.grpc.CreateRoomResponse;

public interface KarambaBackendProvider {

    ListenableFuture<CreateRoomResponse> createRoom(String roomName, String requestId) throws Exception;
}
