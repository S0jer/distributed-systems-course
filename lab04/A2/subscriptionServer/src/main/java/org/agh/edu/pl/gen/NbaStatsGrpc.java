package org.agh.edu.pl.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: nba_stats.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NbaStatsGrpc {

  private NbaStatsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "NbaStats";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<NbaStatsSubscription,
          PlayerStatisticsResponse> getSubscribeNbaStatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeNbaStats",
      requestType = NbaStatsSubscription.class,
      responseType = PlayerStatisticsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<NbaStatsSubscription,
          PlayerStatisticsResponse> getSubscribeNbaStatsMethod() {
    io.grpc.MethodDescriptor<NbaStatsSubscription, PlayerStatisticsResponse> getSubscribeNbaStatsMethod;
    if ((getSubscribeNbaStatsMethod = NbaStatsGrpc.getSubscribeNbaStatsMethod) == null) {
      synchronized (NbaStatsGrpc.class) {
        if ((getSubscribeNbaStatsMethod = NbaStatsGrpc.getSubscribeNbaStatsMethod) == null) {
          NbaStatsGrpc.getSubscribeNbaStatsMethod = getSubscribeNbaStatsMethod =
              io.grpc.MethodDescriptor.<NbaStatsSubscription, PlayerStatisticsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeNbaStats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  NbaStatsSubscription.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PlayerStatisticsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NbaStatsMethodDescriptorSupplier("SubscribeNbaStats"))
              .build();
        }
      }
    }
    return getSubscribeNbaStatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SeasonAveragesRequest,
          SeasonAveragesResponse> getGetSeasonAveragesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSeasonAverages",
      requestType = SeasonAveragesRequest.class,
      responseType = SeasonAveragesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SeasonAveragesRequest,
          SeasonAveragesResponse> getGetSeasonAveragesMethod() {
    io.grpc.MethodDescriptor<SeasonAveragesRequest, SeasonAveragesResponse> getGetSeasonAveragesMethod;
    if ((getGetSeasonAveragesMethod = NbaStatsGrpc.getGetSeasonAveragesMethod) == null) {
      synchronized (NbaStatsGrpc.class) {
        if ((getGetSeasonAveragesMethod = NbaStatsGrpc.getGetSeasonAveragesMethod) == null) {
          NbaStatsGrpc.getGetSeasonAveragesMethod = getGetSeasonAveragesMethod =
              io.grpc.MethodDescriptor.<SeasonAveragesRequest, SeasonAveragesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSeasonAverages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SeasonAveragesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SeasonAveragesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NbaStatsMethodDescriptorSupplier("GetSeasonAverages"))
              .build();
        }
      }
    }
    return getGetSeasonAveragesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NbaStatsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NbaStatsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NbaStatsStub>() {
        @java.lang.Override
        public NbaStatsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NbaStatsStub(channel, callOptions);
        }
      };
    return NbaStatsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NbaStatsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NbaStatsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NbaStatsBlockingStub>() {
        @java.lang.Override
        public NbaStatsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NbaStatsBlockingStub(channel, callOptions);
        }
      };
    return NbaStatsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NbaStatsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NbaStatsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NbaStatsFutureStub>() {
        @java.lang.Override
        public NbaStatsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NbaStatsFutureStub(channel, callOptions);
        }
      };
    return NbaStatsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribeNbaStats(NbaStatsSubscription request,
                                   io.grpc.stub.StreamObserver<PlayerStatisticsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeNbaStatsMethod(), responseObserver);
    }

    /**
     */
    default void getSeasonAverages(SeasonAveragesRequest request,
                                   io.grpc.stub.StreamObserver<SeasonAveragesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSeasonAveragesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NbaStats.
   */
  public static abstract class NbaStatsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return NbaStatsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NbaStats.
   */
  public static final class NbaStatsStub
      extends io.grpc.stub.AbstractAsyncStub<NbaStatsStub> {
    private NbaStatsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NbaStatsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NbaStatsStub(channel, callOptions);
    }

    /**
     */
    public void subscribeNbaStats(NbaStatsSubscription request,
                                  io.grpc.stub.StreamObserver<PlayerStatisticsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeNbaStatsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSeasonAverages(SeasonAveragesRequest request,
                                  io.grpc.stub.StreamObserver<SeasonAveragesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSeasonAveragesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NbaStats.
   */
  public static final class NbaStatsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NbaStatsBlockingStub> {
    private NbaStatsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NbaStatsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NbaStatsBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<PlayerStatisticsResponse> subscribeNbaStats(
        NbaStatsSubscription request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeNbaStatsMethod(), getCallOptions(), request);
    }

    /**
     */
    public SeasonAveragesResponse getSeasonAverages(SeasonAveragesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSeasonAveragesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service NbaStats.
   */
  public static final class NbaStatsFutureStub
      extends io.grpc.stub.AbstractFutureStub<NbaStatsFutureStub> {
    private NbaStatsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NbaStatsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NbaStatsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SeasonAveragesResponse> getSeasonAverages(
        SeasonAveragesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSeasonAveragesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIBE_NBA_STATS = 0;
  private static final int METHODID_GET_SEASON_AVERAGES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE_NBA_STATS:
          serviceImpl.subscribeNbaStats((NbaStatsSubscription) request,
              (io.grpc.stub.StreamObserver<PlayerStatisticsResponse>) responseObserver);
          break;
        case METHODID_GET_SEASON_AVERAGES:
          serviceImpl.getSeasonAverages((SeasonAveragesRequest) request,
              (io.grpc.stub.StreamObserver<SeasonAveragesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSubscribeNbaStatsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
                    NbaStatsSubscription,
                    PlayerStatisticsResponse>(
                service, METHODID_SUBSCRIBE_NBA_STATS)))
        .addMethod(
          getGetSeasonAveragesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
                    SeasonAveragesRequest,
                    SeasonAveragesResponse>(
                service, METHODID_GET_SEASON_AVERAGES)))
        .build();
  }

  private static abstract class NbaStatsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NbaStatsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return NbaStatsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NbaStats");
    }
  }

  private static final class NbaStatsFileDescriptorSupplier
      extends NbaStatsBaseDescriptorSupplier {
    NbaStatsFileDescriptorSupplier() {}
  }

  private static final class NbaStatsMethodDescriptorSupplier
      extends NbaStatsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NbaStatsMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (NbaStatsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NbaStatsFileDescriptorSupplier())
              .addMethod(getSubscribeNbaStatsMethod())
              .addMethod(getGetSeasonAveragesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
