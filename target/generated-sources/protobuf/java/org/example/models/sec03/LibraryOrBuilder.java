// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec03/collection.proto

package org.example.models.sec03;

public interface LibraryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:sec03.Library)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>repeated .sec03.Book books = 2;</code>
   */
  java.util.List<org.example.models.sec03.Book> 
      getBooksList();
  /**
   * <code>repeated .sec03.Book books = 2;</code>
   */
  org.example.models.sec03.Book getBooks(int index);
  /**
   * <code>repeated .sec03.Book books = 2;</code>
   */
  int getBooksCount();
  /**
   * <code>repeated .sec03.Book books = 2;</code>
   */
  java.util.List<? extends org.example.models.sec03.BookOrBuilder> 
      getBooksOrBuilderList();
  /**
   * <code>repeated .sec03.Book books = 2;</code>
   */
  org.example.models.sec03.BookOrBuilder getBooksOrBuilder(
      int index);
}
