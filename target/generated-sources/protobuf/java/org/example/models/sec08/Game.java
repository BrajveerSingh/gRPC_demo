// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec08/game.proto

package org.example.models.sec08;

public final class Game {
  private Game() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sec08_GuessRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sec08_GuessRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sec08_GuessResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sec08_GuessResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020sec08/game.proto\022\005sec08\"\035\n\014GuessReques" +
      "t\022\r\n\005guess\030\001 \001(\005\"?\n\rGuessResponse\022\017\n\007att" +
      "empt\030\001 \001(\005\022\035\n\006result\030\002 \001(\0162\r.sec08.Resul" +
      "t*0\n\006Result\022\013\n\007CORRECT\020\000\022\013\n\007TOO_LOW\020\001\022\014\n" +
      "\010TOO_HIGH\020\0022I\n\013GuessNumber\022:\n\tMakeGuess\022" +
      "\023.sec08.GuessRequest\032\024.sec08.GuessRespon" +
      "se(\0010\001B\034\n\030org.example.models.sec08P\001b\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_sec08_GuessRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_sec08_GuessRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sec08_GuessRequest_descriptor,
        new java.lang.String[] { "Guess", });
    internal_static_sec08_GuessResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_sec08_GuessResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sec08_GuessResponse_descriptor,
        new java.lang.String[] { "Attempt", "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}