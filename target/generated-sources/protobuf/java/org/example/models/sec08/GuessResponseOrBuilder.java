// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec08/game.proto

package org.example.models.sec08;

public interface GuessResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:sec08.GuessResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 attempt = 1;</code>
   * @return The attempt.
   */
  int getAttempt();

  /**
   * <code>.sec08.Result result = 2;</code>
   * @return The enum numeric value on the wire for result.
   */
  int getResultValue();
  /**
   * <code>.sec08.Result result = 2;</code>
   * @return The result.
   */
  org.example.models.sec08.Result getResult();
}
