package media.karamba.backend.api.client;

import media.karamba.backend.api.grpc.CreateRoomResponse;

public interface KarambaBackendProvider {

    CreateRoomResponse createRoom(String roomName, String roomDescription,  String requestId) throws Exception;
}
