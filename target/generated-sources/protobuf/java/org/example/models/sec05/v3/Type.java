// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec05/v3/television.proto

package org.example.models.sec05.v3;

/**
 * Protobuf enum {@code sec05.v3.Type}
 */
public enum Type
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>HD = 0;</code>
   */
  HD(0),
  /**
   * <code>UHD = 1;</code>
   */
  UHD(1),
  /**
   * <code>OLED = 2;</code>
   */
  OLED(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>HD = 0;</code>
   */
  public static final int HD_VALUE = 0;
  /**
   * <code>UHD = 1;</code>
   */
  public static final int UHD_VALUE = 1;
  /**
   * <code>OLED = 2;</code>
   */
  public static final int OLED_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Type valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Type forNumber(int value) {
    switch (value) {
      case 0: return HD;
      case 1: return UHD;
      case 2: return OLED;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Type>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Type> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Type>() {
          public Type findValueByNumber(int number) {
            return Type.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return org.example.models.sec05.v3.TelevisionOuterClass.getDescriptor().getEnumTypes().get(0);
  }

  private static final Type[] VALUES = values();

  public static Type valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Type(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:sec05.v3.Type)
}

