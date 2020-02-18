package media.karamba.backend.api.server;

import media.karamba.backend.api.grpc.CreateRoomRequest;
import media.karamba.backend.api.grpc.CreateRoomResponse;

public interface KarambaBackendGrpcServerListener {

    CreateRoomResponse onCreateRoomRequest(CreateRoomRequest request);
}
