package com.devsisters.example

object PingServiceGrpc {
  val METHOD_PING: _root_.io.grpc.MethodDescriptor[com.devsisters.example.PingRequest, com.devsisters.example.PingReply] =
    _root_.io.grpc.MethodDescriptor.newBuilder()
      .setType(_root_.io.grpc.MethodDescriptor.MethodType.UNARY)
      .setFullMethodName(_root_.io.grpc.MethodDescriptor.generateFullMethodName("com.devsisters.example.PingService", "Ping"))
      .setRequestMarshaller(new com.trueaccord.scalapb.grpc.Marshaller(com.devsisters.example.PingRequest))
      .setResponseMarshaller(new com.trueaccord.scalapb.grpc.Marshaller(com.devsisters.example.PingReply))
      .build()
  
  val SERVICE: _root_.io.grpc.ServiceDescriptor =
    _root_.io.grpc.ServiceDescriptor.newBuilder("com.devsisters.example.PingService")
      .setSchemaDescriptor(new _root_.com.trueaccord.scalapb.grpc.ConcreteProtoFileDescriptorSupplier(com.devsisters.example.MessagesProto.javaDescriptor))
      .addMethod(METHOD_PING)
      .build()
  
  trait PingService extends _root_.com.trueaccord.scalapb.grpc.AbstractService {
    override def serviceCompanion = PingService
    def ping(request: com.devsisters.example.PingRequest): scala.concurrent.Future[com.devsisters.example.PingReply]
  }
  
  object PingService extends _root_.com.trueaccord.scalapb.grpc.ServiceCompanion[PingService] {
    implicit def serviceCompanion: _root_.com.trueaccord.scalapb.grpc.ServiceCompanion[PingService] = this
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = com.devsisters.example.MessagesProto.javaDescriptor.getServices().get(0)
  }
  
  trait PingServiceBlockingClient {
    def serviceCompanion = PingService
    def ping(request: com.devsisters.example.PingRequest): com.devsisters.example.PingReply
  }
  
  class PingServiceBlockingStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[PingServiceBlockingStub](channel, options) with PingServiceBlockingClient {
    override def ping(request: com.devsisters.example.PingRequest): com.devsisters.example.PingReply = {
      _root_.io.grpc.stub.ClientCalls.blockingUnaryCall(channel.newCall(METHOD_PING, options), request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): PingServiceBlockingStub = new PingServiceBlockingStub(channel, options)
  }
  
  class PingServiceStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[PingServiceStub](channel, options) with PingService {
    override def ping(request: com.devsisters.example.PingRequest): scala.concurrent.Future[com.devsisters.example.PingReply] = {
      com.trueaccord.scalapb.grpc.Grpc.guavaFuture2ScalaFuture(_root_.io.grpc.stub.ClientCalls.futureUnaryCall(channel.newCall(METHOD_PING, options), request))
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): PingServiceStub = new PingServiceStub(channel, options)
  }
  
  def bindService(serviceImpl: PingService, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition =
    _root_.io.grpc.ServerServiceDefinition.builder(SERVICE)
    .addMethod(
      METHOD_PING,
      _root_.io.grpc.stub.ServerCalls.asyncUnaryCall(new _root_.io.grpc.stub.ServerCalls.UnaryMethod[com.devsisters.example.PingRequest, com.devsisters.example.PingReply] {
        override def invoke(request: com.devsisters.example.PingRequest, observer: _root_.io.grpc.stub.StreamObserver[com.devsisters.example.PingReply]): Unit =
          serviceImpl.ping(request).onComplete(com.trueaccord.scalapb.grpc.Grpc.completeObserver(observer))(
            executionContext)
      }))
    .build()
  
  def blockingStub(channel: _root_.io.grpc.Channel): PingServiceBlockingStub = new PingServiceBlockingStub(channel)
  
  def stub(channel: _root_.io.grpc.Channel): PingServiceStub = new PingServiceStub(channel)
  
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = com.devsisters.example.MessagesProto.javaDescriptor.getServices().get(0)
  
}