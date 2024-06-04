// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sec06/bank-service.proto

package org.example.models.sec06;

/**
 * Protobuf type {@code sec06.DepositRequest}
 */
public final class DepositRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:sec06.DepositRequest)
    DepositRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DepositRequest.newBuilder() to construct.
  private DepositRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DepositRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DepositRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.example.models.sec06.BankServiceOuterClass.internal_static_sec06_DepositRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.example.models.sec06.BankServiceOuterClass.internal_static_sec06_DepositRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.example.models.sec06.DepositRequest.class, org.example.models.sec06.DepositRequest.Builder.class);
  }

  private int requestCase_ = 0;
  @SuppressWarnings("serial")
  private java.lang.Object request_;
  public enum RequestCase
      implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    ACCOUNT_NUMBER(1),
    DEPOSIT_AMOUNT(2),
    REQUEST_NOT_SET(0);
    private final int value;
    private RequestCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static RequestCase valueOf(int value) {
      return forNumber(value);
    }

    public static RequestCase forNumber(int value) {
      switch (value) {
        case 1: return ACCOUNT_NUMBER;
        case 2: return DEPOSIT_AMOUNT;
        case 0: return REQUEST_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public RequestCase
  getRequestCase() {
    return RequestCase.forNumber(
        requestCase_);
  }

  public static final int ACCOUNT_NUMBER_FIELD_NUMBER = 1;
  /**
   * <code>int32 account_number = 1;</code>
   * @return Whether the accountNumber field is set.
   */
  @java.lang.Override
  public boolean hasAccountNumber() {
    return requestCase_ == 1;
  }
  /**
   * <code>int32 account_number = 1;</code>
   * @return The accountNumber.
   */
  @java.lang.Override
  public int getAccountNumber() {
    if (requestCase_ == 1) {
      return (java.lang.Integer) request_;
    }
    return 0;
  }

  public static final int DEPOSIT_AMOUNT_FIELD_NUMBER = 2;
  /**
   * <code>.sec06.DepositAmount deposit_amount = 2;</code>
   * @return Whether the depositAmount field is set.
   */
  @java.lang.Override
  public boolean hasDepositAmount() {
    return requestCase_ == 2;
  }
  /**
   * <code>.sec06.DepositAmount deposit_amount = 2;</code>
   * @return The depositAmount.
   */
  @java.lang.Override
  public org.example.models.sec06.DepositAmount getDepositAmount() {
    if (requestCase_ == 2) {
       return (org.example.models.sec06.DepositAmount) request_;
    }
    return org.example.models.sec06.DepositAmount.getDefaultInstance();
  }
  /**
   * <code>.sec06.DepositAmount deposit_amount = 2;</code>
   */
  @java.lang.Override
  public org.example.models.sec06.DepositAmountOrBuilder getDepositAmountOrBuilder() {
    if (requestCase_ == 2) {
       return (org.example.models.sec06.DepositAmount) request_;
    }
    return org.example.models.sec06.DepositAmount.getDefaultInstance();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (requestCase_ == 1) {
      output.writeInt32(
          1, (int)((java.lang.Integer) request_));
    }
    if (requestCase_ == 2) {
      output.writeMessage(2, (org.example.models.sec06.DepositAmount) request_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (requestCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(
            1, (int)((java.lang.Integer) request_));
    }
    if (requestCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (org.example.models.sec06.DepositAmount) request_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.example.models.sec06.DepositRequest)) {
      return super.equals(obj);
    }
    org.example.models.sec06.DepositRequest other = (org.example.models.sec06.DepositRequest) obj;

    if (!getRequestCase().equals(other.getRequestCase())) return false;
    switch (requestCase_) {
      case 1:
        if (getAccountNumber()
            != other.getAccountNumber()) return false;
        break;
      case 2:
        if (!getDepositAmount()
            .equals(other.getDepositAmount())) return false;
        break;
      case 0:
      default:
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    switch (requestCase_) {
      case 1:
        hash = (37 * hash) + ACCOUNT_NUMBER_FIELD_NUMBER;
        hash = (53 * hash) + getAccountNumber();
        break;
      case 2:
        hash = (37 * hash) + DEPOSIT_AMOUNT_FIELD_NUMBER;
        hash = (53 * hash) + getDepositAmount().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.example.models.sec06.DepositRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.models.sec06.DepositRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.models.sec06.DepositRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.models.sec06.DepositRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.models.sec06.DepositRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.models.sec06.DepositRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.models.sec06.DepositRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.example.models.sec06.DepositRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.example.models.sec06.DepositRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.example.models.sec06.DepositRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.example.models.sec06.DepositRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.example.models.sec06.DepositRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.example.models.sec06.DepositRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code sec06.DepositRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:sec06.DepositRequest)
      org.example.models.sec06.DepositRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.example.models.sec06.BankServiceOuterClass.internal_static_sec06_DepositRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.example.models.sec06.BankServiceOuterClass.internal_static_sec06_DepositRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.example.models.sec06.DepositRequest.class, org.example.models.sec06.DepositRequest.Builder.class);
    }

    // Construct using org.example.models.sec06.DepositRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (depositAmountBuilder_ != null) {
        depositAmountBuilder_.clear();
      }
      requestCase_ = 0;
      request_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.example.models.sec06.BankServiceOuterClass.internal_static_sec06_DepositRequest_descriptor;
    }

    @java.lang.Override
    public org.example.models.sec06.DepositRequest getDefaultInstanceForType() {
      return org.example.models.sec06.DepositRequest.getDefaultInstance();
    }

    @java.lang.Override
    public org.example.models.sec06.DepositRequest build() {
      org.example.models.sec06.DepositRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.example.models.sec06.DepositRequest buildPartial() {
      org.example.models.sec06.DepositRequest result = new org.example.models.sec06.DepositRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      buildPartialOneofs(result);
      onBuilt();
      return result;
    }

    private void buildPartial0(org.example.models.sec06.DepositRequest result) {
      int from_bitField0_ = bitField0_;
    }

    private void buildPartialOneofs(org.example.models.sec06.DepositRequest result) {
      result.requestCase_ = requestCase_;
      result.request_ = this.request_;
      if (requestCase_ == 2 &&
          depositAmountBuilder_ != null) {
        result.request_ = depositAmountBuilder_.build();
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.example.models.sec06.DepositRequest) {
        return mergeFrom((org.example.models.sec06.DepositRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.example.models.sec06.DepositRequest other) {
      if (other == org.example.models.sec06.DepositRequest.getDefaultInstance()) return this;
      switch (other.getRequestCase()) {
        case ACCOUNT_NUMBER: {
          setAccountNumber(other.getAccountNumber());
          break;
        }
        case DEPOSIT_AMOUNT: {
          mergeDepositAmount(other.getDepositAmount());
          break;
        }
        case REQUEST_NOT_SET: {
          break;
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              request_ = input.readInt32();
              requestCase_ = 1;
              break;
            } // case 8
            case 18: {
              input.readMessage(
                  getDepositAmountFieldBuilder().getBuilder(),
                  extensionRegistry);
              requestCase_ = 2;
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int requestCase_ = 0;
    private java.lang.Object request_;
    public RequestCase
        getRequestCase() {
      return RequestCase.forNumber(
          requestCase_);
    }

    public Builder clearRequest() {
      requestCase_ = 0;
      request_ = null;
      onChanged();
      return this;
    }

    private int bitField0_;

    /**
     * <code>int32 account_number = 1;</code>
     * @return Whether the accountNumber field is set.
     */
    public boolean hasAccountNumber() {
      return requestCase_ == 1;
    }
    /**
     * <code>int32 account_number = 1;</code>
     * @return The accountNumber.
     */
    public int getAccountNumber() {
      if (requestCase_ == 1) {
        return (java.lang.Integer) request_;
      }
      return 0;
    }
    /**
     * <code>int32 account_number = 1;</code>
     * @param value The accountNumber to set.
     * @return This builder for chaining.
     */
    public Builder setAccountNumber(int value) {

      requestCase_ = 1;
      request_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 account_number = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearAccountNumber() {
      if (requestCase_ == 1) {
        requestCase_ = 0;
        request_ = null;
        onChanged();
      }
      return this;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        org.example.models.sec06.DepositAmount, org.example.models.sec06.DepositAmount.Builder, org.example.models.sec06.DepositAmountOrBuilder> depositAmountBuilder_;
    /**
     * <code>.sec06.DepositAmount deposit_amount = 2;</code>
     * @return Whether the depositAmount field is set.
     */
    @java.lang.Override
    public boolean hasDepositAmount() {
      return requestCase_ == 2;
    }
    /**
     * <code>.sec06.DepositAmount deposit_amount = 2;</code>
     * @return The depositAmount.
     */
    @java.lang.Override
    public org.example.models.sec06.DepositAmount getDepositAmount() {
      if (depositAmountBuilder_ == null) {
        if (requestCase_ == 2) {
          return (org.example.models.sec06.DepositAmount) request_;
        }
        return org.example.models.sec06.DepositAmount.getDefaultInstance();
      } else {
        if (requestCase_ == 2) {
          return depositAmountBuilder_.getMessage();
        }
        return org.example.models.sec06.DepositAmount.getDefaultInstance();
      }
    }
    /**
     * <code>.sec06.DepositAmount deposit_amount = 2;</code>
     */
    public Builder setDepositAmount(org.example.models.sec06.DepositAmount value) {
      if (depositAmountBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        request_ = value;
        onChanged();
      } else {
        depositAmountBuilder_.setMessage(value);
      }
      requestCase_ = 2;
      return this;
    }
    /**
     * <code>.sec06.DepositAmount deposit_amount = 2;</code>
     */
    public Builder setDepositAmount(
        org.example.models.sec06.DepositAmount.Builder builderForValue) {
      if (depositAmountBuilder_ == null) {
        request_ = builderForValue.build();
        onChanged();
      } else {
        depositAmountBuilder_.setMessage(builderForValue.build());
      }
      requestCase_ = 2;
      return this;
    }
    /**
     * <code>.sec06.DepositAmount deposit_amount = 2;</code>
     */
    public Builder mergeDepositAmount(org.example.models.sec06.DepositAmount value) {
      if (depositAmountBuilder_ == null) {
        if (requestCase_ == 2 &&
            request_ != org.example.models.sec06.DepositAmount.getDefaultInstance()) {
          request_ = org.example.models.sec06.DepositAmount.newBuilder((org.example.models.sec06.DepositAmount) request_)
              .mergeFrom(value).buildPartial();
        } else {
          request_ = value;
        }
        onChanged();
      } else {
        if (requestCase_ == 2) {
          depositAmountBuilder_.mergeFrom(value);
        } else {
          depositAmountBuilder_.setMessage(value);
        }
      }
      requestCase_ = 2;
      return this;
    }
    /**
     * <code>.sec06.DepositAmount deposit_amount = 2;</code>
     */
    public Builder clearDepositAmount() {
      if (depositAmountBuilder_ == null) {
        if (requestCase_ == 2) {
          requestCase_ = 0;
          request_ = null;
          onChanged();
        }
      } else {
        if (requestCase_ == 2) {
          requestCase_ = 0;
          request_ = null;
        }
        depositAmountBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.sec06.DepositAmount deposit_amount = 2;</code>
     */
    public org.example.models.sec06.DepositAmount.Builder getDepositAmountBuilder() {
      return getDepositAmountFieldBuilder().getBuilder();
    }
    /**
     * <code>.sec06.DepositAmount deposit_amount = 2;</code>
     */
    @java.lang.Override
    public org.example.models.sec06.DepositAmountOrBuilder getDepositAmountOrBuilder() {
      if ((requestCase_ == 2) && (depositAmountBuilder_ != null)) {
        return depositAmountBuilder_.getMessageOrBuilder();
      } else {
        if (requestCase_ == 2) {
          return (org.example.models.sec06.DepositAmount) request_;
        }
        return org.example.models.sec06.DepositAmount.getDefaultInstance();
      }
    }
    /**
     * <code>.sec06.DepositAmount deposit_amount = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.example.models.sec06.DepositAmount, org.example.models.sec06.DepositAmount.Builder, org.example.models.sec06.DepositAmountOrBuilder> 
        getDepositAmountFieldBuilder() {
      if (depositAmountBuilder_ == null) {
        if (!(requestCase_ == 2)) {
          request_ = org.example.models.sec06.DepositAmount.getDefaultInstance();
        }
        depositAmountBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.example.models.sec06.DepositAmount, org.example.models.sec06.DepositAmount.Builder, org.example.models.sec06.DepositAmountOrBuilder>(
                (org.example.models.sec06.DepositAmount) request_,
                getParentForChildren(),
                isClean());
        request_ = null;
      }
      requestCase_ = 2;
      onChanged();
      return depositAmountBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:sec06.DepositRequest)
  }

  // @@protoc_insertion_point(class_scope:sec06.DepositRequest)
  private static final org.example.models.sec06.DepositRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.example.models.sec06.DepositRequest();
  }

  public static org.example.models.sec06.DepositRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DepositRequest>
      PARSER = new com.google.protobuf.AbstractParser<DepositRequest>() {
    @java.lang.Override
    public DepositRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<DepositRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DepositRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.example.models.sec06.DepositRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

