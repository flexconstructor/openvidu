package media.karamba.backend.api.server.impl;

import io.grpc.stub.StreamObserver;
import media.karamba.backend.api.grpc.CreateRoomRequest;
import media.karamba.backend.api.grpc.CreateRoomResponse;
import media.karamba.backend.api.grpc.MediaControlServiceGrpc;
import media.karamba.backend.api.server.KarambaBackendGrpcServer;
import media.karamba.backend.api.server.KarambaBackendGrpcServerListener;

public class KarambaBackendGrpcServerImpl extends MediaControlServiceGrpc.MediaControlServiceImplBase
        implements KarambaBackendGrpcServer {

    private final KarambaBackendGrpcServerListener grpcServerListener;

    public KarambaBackendGrpcServerImpl(KarambaBackendGrpcServerListener grpcServerListener) {
        this.grpcServerListener = grpcServerListener;
    }

    @Override
    public  void createRoom(CreateRoomRequest request, StreamObserver<CreateRoomResponse> observer){
        observer.onNext(this.grpcServerListener.onCreateRoomRequest(request));
        observer.onCompleted();
    }
}
