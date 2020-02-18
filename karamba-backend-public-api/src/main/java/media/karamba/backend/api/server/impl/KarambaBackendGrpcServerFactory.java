package media.karamba.backend.api.server.impl;

import media.karamba.backend.api.server.KarambaBackendGrpcServer;
import media.karamba.backend.api.server.KarambaBackendGrpcServerListener;

public class KarambaBackendGrpcServerFactory {

    private static KarambaBackendGrpcServer karambaBackendGrpcServer;

    public static KarambaBackendGrpcServer createServer(KarambaBackendGrpcServerListener listener){
        if(karambaBackendGrpcServer != null){
            return karambaBackendGrpcServer;
        }
        karambaBackendGrpcServer = new KarambaBackendGrpcServerImpl(listener);
        return karambaBackendGrpcServer;

    }
}
