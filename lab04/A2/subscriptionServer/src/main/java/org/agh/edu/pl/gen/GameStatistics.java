// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nba_stats.proto

// Protobuf Java Version: 4.26.1
package org.agh.edu.pl.gen;

/**
 * Protobuf type {@code GameStatistics}
 */
public final class GameStatistics extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:GameStatistics)
    GameStatisticsOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      GameStatistics.class.getName());
  }
  // Use GameStatistics.newBuilder() to construct.
  private GameStatistics(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private GameStatistics() {
    gameId_ = "";
    date_ = "";
    opponent_ = "";
    outcome_ = 0;
    gamePerformanceGrade_ = 0;
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return NbaStatsProto.internal_static_GameStatistics_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return NbaStatsProto.internal_static_GameStatistics_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GameStatistics.class, GameStatistics.Builder.class);
  }

  private int bitField0_;
  public static final int GAMEID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object gameId_ = "";
  /**
   * <code>string gameId = 1;</code>
   * @return The gameId.
   */
  @java.lang.Override
  public java.lang.String getGameId() {
    java.lang.Object ref = gameId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      gameId_ = s;
      return s;
    }
  }
  /**
   * <code>string gameId = 1;</code>
   * @return The bytes for gameId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getGameIdBytes() {
    java.lang.Object ref = gameId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      gameId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATE_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object date_ = "";
  /**
   * <code>string date = 2;</code>
   * @return The date.
   */
  @java.lang.Override
  public java.lang.String getDate() {
    java.lang.Object ref = date_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      date_ = s;
      return s;
    }
  }
  /**
   * <code>string date = 2;</code>
   * @return The bytes for date.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDateBytes() {
    java.lang.Object ref = date_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      date_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OPPONENT_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object opponent_ = "";
  /**
   * <code>string opponent = 3;</code>
   * @return The opponent.
   */
  @java.lang.Override
  public java.lang.String getOpponent() {
    java.lang.Object ref = opponent_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      opponent_ = s;
      return s;
    }
  }
  /**
   * <code>string opponent = 3;</code>
   * @return The bytes for opponent.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getOpponentBytes() {
    java.lang.Object ref = opponent_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      opponent_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OUTCOME_FIELD_NUMBER = 4;
  private int outcome_ = 0;
  /**
   * <code>.GameOutcome outcome = 4;</code>
   * @return The enum numeric value on the wire for outcome.
   */
  @java.lang.Override public int getOutcomeValue() {
    return outcome_;
  }
  /**
   * <code>.GameOutcome outcome = 4;</code>
   * @return The outcome.
   */
  @java.lang.Override public GameOutcome getOutcome() {
    GameOutcome result = GameOutcome.forNumber(outcome_);
    return result == null ? GameOutcome.UNRECOGNIZED : result;
  }

  public static final int GAMEPERFORMANCEGRADE_FIELD_NUMBER = 5;
  private int gamePerformanceGrade_ = 0;
  /**
   * <code>.GamePerformance gamePerformanceGrade = 5;</code>
   * @return The enum numeric value on the wire for gamePerformanceGrade.
   */
  @java.lang.Override public int getGamePerformanceGradeValue() {
    return gamePerformanceGrade_;
  }
  /**
   * <code>.GamePerformance gamePerformanceGrade = 5;</code>
   * @return The gamePerformanceGrade.
   */
  @java.lang.Override public GamePerformance getGamePerformanceGrade() {
    GamePerformance result = GamePerformance.forNumber(gamePerformanceGrade_);
    return result == null ? GamePerformance.UNRECOGNIZED : result;
  }

  public static final int STATS_FIELD_NUMBER = 6;
  private DetailedStatistics stats_;
  /**
   * <code>.DetailedStatistics stats = 6;</code>
   * @return Whether the stats field is set.
   */
  @java.lang.Override
  public boolean hasStats() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.DetailedStatistics stats = 6;</code>
   * @return The stats.
   */
  @java.lang.Override
  public DetailedStatistics getStats() {
    return stats_ == null ? DetailedStatistics.getDefaultInstance() : stats_;
  }
  /**
   * <code>.DetailedStatistics stats = 6;</code>
   */
  @java.lang.Override
  public DetailedStatisticsOrBuilder getStatsOrBuilder() {
    return stats_ == null ? DetailedStatistics.getDefaultInstance() : stats_;
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
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(gameId_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, gameId_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(date_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, date_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(opponent_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 3, opponent_);
    }
    if (outcome_ != GameOutcome.WIN.getNumber()) {
      output.writeEnum(4, outcome_);
    }
    if (gamePerformanceGrade_ != GamePerformance.TERRIBLE.getNumber()) {
      output.writeEnum(5, gamePerformanceGrade_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(6, getStats());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(gameId_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, gameId_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(date_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, date_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(opponent_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(3, opponent_);
    }
    if (outcome_ != GameOutcome.WIN.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(4, outcome_);
    }
    if (gamePerformanceGrade_ != GamePerformance.TERRIBLE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(5, gamePerformanceGrade_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(6, getStats());
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
    if (!(obj instanceof GameStatistics)) {
      return super.equals(obj);
    }
    GameStatistics other = (GameStatistics) obj;

    if (!getGameId()
        .equals(other.getGameId())) return false;
    if (!getDate()
        .equals(other.getDate())) return false;
    if (!getOpponent()
        .equals(other.getOpponent())) return false;
    if (outcome_ != other.outcome_) return false;
    if (gamePerformanceGrade_ != other.gamePerformanceGrade_) return false;
    if (hasStats() != other.hasStats()) return false;
    if (hasStats()) {
      if (!getStats()
          .equals(other.getStats())) return false;
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
    hash = (37 * hash) + GAMEID_FIELD_NUMBER;
    hash = (53 * hash) + getGameId().hashCode();
    hash = (37 * hash) + DATE_FIELD_NUMBER;
    hash = (53 * hash) + getDate().hashCode();
    hash = (37 * hash) + OPPONENT_FIELD_NUMBER;
    hash = (53 * hash) + getOpponent().hashCode();
    hash = (37 * hash) + OUTCOME_FIELD_NUMBER;
    hash = (53 * hash) + outcome_;
    hash = (37 * hash) + GAMEPERFORMANCEGRADE_FIELD_NUMBER;
    hash = (53 * hash) + gamePerformanceGrade_;
    if (hasStats()) {
      hash = (37 * hash) + STATS_FIELD_NUMBER;
      hash = (53 * hash) + getStats().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static GameStatistics parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GameStatistics parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GameStatistics parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GameStatistics parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GameStatistics parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GameStatistics parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GameStatistics parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static GameStatistics parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static GameStatistics parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static GameStatistics parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GameStatistics parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static GameStatistics parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(GameStatistics prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code GameStatistics}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GameStatistics)
          GameStatisticsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return NbaStatsProto.internal_static_GameStatistics_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return NbaStatsProto.internal_static_GameStatistics_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GameStatistics.class, GameStatistics.Builder.class);
    }

    // Construct using gen.GameStatistics.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage
              .alwaysUseFieldBuilders) {
        getStatsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      gameId_ = "";
      date_ = "";
      opponent_ = "";
      outcome_ = 0;
      gamePerformanceGrade_ = 0;
      stats_ = null;
      if (statsBuilder_ != null) {
        statsBuilder_.dispose();
        statsBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return NbaStatsProto.internal_static_GameStatistics_descriptor;
    }

    @java.lang.Override
    public GameStatistics getDefaultInstanceForType() {
      return GameStatistics.getDefaultInstance();
    }

    @java.lang.Override
    public GameStatistics build() {
      GameStatistics result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public GameStatistics buildPartial() {
      GameStatistics result = new GameStatistics(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(GameStatistics result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.gameId_ = gameId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.date_ = date_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.opponent_ = opponent_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.outcome_ = outcome_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.gamePerformanceGrade_ = gamePerformanceGrade_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000020) != 0)) {
        result.stats_ = statsBuilder_ == null
            ? stats_
            : statsBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof GameStatistics) {
        return mergeFrom((GameStatistics)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GameStatistics other) {
      if (other == GameStatistics.getDefaultInstance()) return this;
      if (!other.getGameId().isEmpty()) {
        gameId_ = other.gameId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getDate().isEmpty()) {
        date_ = other.date_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getOpponent().isEmpty()) {
        opponent_ = other.opponent_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (other.outcome_ != 0) {
        setOutcomeValue(other.getOutcomeValue());
      }
      if (other.gamePerformanceGrade_ != 0) {
        setGamePerformanceGradeValue(other.getGamePerformanceGradeValue());
      }
      if (other.hasStats()) {
        mergeStats(other.getStats());
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
            case 10: {
              gameId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              date_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              opponent_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 32: {
              outcome_ = input.readEnum();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
            case 40: {
              gamePerformanceGrade_ = input.readEnum();
              bitField0_ |= 0x00000010;
              break;
            } // case 40
            case 50: {
              input.readMessage(
                  getStatsFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000020;
              break;
            } // case 50
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
    private int bitField0_;

    private java.lang.Object gameId_ = "";
    /**
     * <code>string gameId = 1;</code>
     * @return The gameId.
     */
    public java.lang.String getGameId() {
      java.lang.Object ref = gameId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gameId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string gameId = 1;</code>
     * @return The bytes for gameId.
     */
    public com.google.protobuf.ByteString
        getGameIdBytes() {
      java.lang.Object ref = gameId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gameId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string gameId = 1;</code>
     * @param value The gameId to set.
     * @return This builder for chaining.
     */
    public Builder setGameId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      gameId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string gameId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearGameId() {
      gameId_ = getDefaultInstance().getGameId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string gameId = 1;</code>
     * @param value The bytes for gameId to set.
     * @return This builder for chaining.
     */
    public Builder setGameIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      gameId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object date_ = "";
    /**
     * <code>string date = 2;</code>
     * @return The date.
     */
    public java.lang.String getDate() {
      java.lang.Object ref = date_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        date_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string date = 2;</code>
     * @return The bytes for date.
     */
    public com.google.protobuf.ByteString
        getDateBytes() {
      java.lang.Object ref = date_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        date_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string date = 2;</code>
     * @param value The date to set.
     * @return This builder for chaining.
     */
    public Builder setDate(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      date_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string date = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearDate() {
      date_ = getDefaultInstance().getDate();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string date = 2;</code>
     * @param value The bytes for date to set.
     * @return This builder for chaining.
     */
    public Builder setDateBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      date_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object opponent_ = "";
    /**
     * <code>string opponent = 3;</code>
     * @return The opponent.
     */
    public java.lang.String getOpponent() {
      java.lang.Object ref = opponent_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        opponent_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string opponent = 3;</code>
     * @return The bytes for opponent.
     */
    public com.google.protobuf.ByteString
        getOpponentBytes() {
      java.lang.Object ref = opponent_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        opponent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string opponent = 3;</code>
     * @param value The opponent to set.
     * @return This builder for chaining.
     */
    public Builder setOpponent(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      opponent_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string opponent = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearOpponent() {
      opponent_ = getDefaultInstance().getOpponent();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string opponent = 3;</code>
     * @param value The bytes for opponent to set.
     * @return This builder for chaining.
     */
    public Builder setOpponentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      opponent_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private int outcome_ = 0;
    /**
     * <code>.GameOutcome outcome = 4;</code>
     * @return The enum numeric value on the wire for outcome.
     */
    @java.lang.Override public int getOutcomeValue() {
      return outcome_;
    }
    /**
     * <code>.GameOutcome outcome = 4;</code>
     * @param value The enum numeric value on the wire for outcome to set.
     * @return This builder for chaining.
     */
    public Builder setOutcomeValue(int value) {
      outcome_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>.GameOutcome outcome = 4;</code>
     * @return The outcome.
     */
    @java.lang.Override
    public GameOutcome getOutcome() {
      GameOutcome result = GameOutcome.forNumber(outcome_);
      return result == null ? GameOutcome.UNRECOGNIZED : result;
    }
    /**
     * <code>.GameOutcome outcome = 4;</code>
     * @param value The outcome to set.
     * @return This builder for chaining.
     */
    public Builder setOutcome(GameOutcome value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000008;
      outcome_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.GameOutcome outcome = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearOutcome() {
      bitField0_ = (bitField0_ & ~0x00000008);
      outcome_ = 0;
      onChanged();
      return this;
    }

    private int gamePerformanceGrade_ = 0;
    /**
     * <code>.GamePerformance gamePerformanceGrade = 5;</code>
     * @return The enum numeric value on the wire for gamePerformanceGrade.
     */
    @java.lang.Override public int getGamePerformanceGradeValue() {
      return gamePerformanceGrade_;
    }
    /**
     * <code>.GamePerformance gamePerformanceGrade = 5;</code>
     * @param value The enum numeric value on the wire for gamePerformanceGrade to set.
     * @return This builder for chaining.
     */
    public Builder setGamePerformanceGradeValue(int value) {
      gamePerformanceGrade_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>.GamePerformance gamePerformanceGrade = 5;</code>
     * @return The gamePerformanceGrade.
     */
    @java.lang.Override
    public GamePerformance getGamePerformanceGrade() {
      GamePerformance result = GamePerformance.forNumber(gamePerformanceGrade_);
      return result == null ? GamePerformance.UNRECOGNIZED : result;
    }
    /**
     * <code>.GamePerformance gamePerformanceGrade = 5;</code>
     * @param value The gamePerformanceGrade to set.
     * @return This builder for chaining.
     */
    public Builder setGamePerformanceGrade(GamePerformance value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000010;
      gamePerformanceGrade_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.GamePerformance gamePerformanceGrade = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearGamePerformanceGrade() {
      bitField0_ = (bitField0_ & ~0x00000010);
      gamePerformanceGrade_ = 0;
      onChanged();
      return this;
    }

    private DetailedStatistics stats_;
    private com.google.protobuf.SingleFieldBuilder<
            DetailedStatistics, DetailedStatistics.Builder, DetailedStatisticsOrBuilder> statsBuilder_;
    /**
     * <code>.DetailedStatistics stats = 6;</code>
     * @return Whether the stats field is set.
     */
    public boolean hasStats() {
      return ((bitField0_ & 0x00000020) != 0);
    }
    /**
     * <code>.DetailedStatistics stats = 6;</code>
     * @return The stats.
     */
    public DetailedStatistics getStats() {
      if (statsBuilder_ == null) {
        return stats_ == null ? DetailedStatistics.getDefaultInstance() : stats_;
      } else {
        return statsBuilder_.getMessage();
      }
    }
    /**
     * <code>.DetailedStatistics stats = 6;</code>
     */
    public Builder setStats(DetailedStatistics value) {
      if (statsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        stats_ = value;
      } else {
        statsBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>.DetailedStatistics stats = 6;</code>
     */
    public Builder setStats(
        DetailedStatistics.Builder builderForValue) {
      if (statsBuilder_ == null) {
        stats_ = builderForValue.build();
      } else {
        statsBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>.DetailedStatistics stats = 6;</code>
     */
    public Builder mergeStats(DetailedStatistics value) {
      if (statsBuilder_ == null) {
        if (((bitField0_ & 0x00000020) != 0) &&
          stats_ != null &&
          stats_ != DetailedStatistics.getDefaultInstance()) {
          getStatsBuilder().mergeFrom(value);
        } else {
          stats_ = value;
        }
      } else {
        statsBuilder_.mergeFrom(value);
      }
      if (stats_ != null) {
        bitField0_ |= 0x00000020;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.DetailedStatistics stats = 6;</code>
     */
    public Builder clearStats() {
      bitField0_ = (bitField0_ & ~0x00000020);
      stats_ = null;
      if (statsBuilder_ != null) {
        statsBuilder_.dispose();
        statsBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.DetailedStatistics stats = 6;</code>
     */
    public DetailedStatistics.Builder getStatsBuilder() {
      bitField0_ |= 0x00000020;
      onChanged();
      return getStatsFieldBuilder().getBuilder();
    }
    /**
     * <code>.DetailedStatistics stats = 6;</code>
     */
    public DetailedStatisticsOrBuilder getStatsOrBuilder() {
      if (statsBuilder_ != null) {
        return statsBuilder_.getMessageOrBuilder();
      } else {
        return stats_ == null ?
            DetailedStatistics.getDefaultInstance() : stats_;
      }
    }
    /**
     * <code>.DetailedStatistics stats = 6;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
            DetailedStatistics, DetailedStatistics.Builder, DetailedStatisticsOrBuilder>
        getStatsFieldBuilder() {
      if (statsBuilder_ == null) {
        statsBuilder_ = new com.google.protobuf.SingleFieldBuilder<
                DetailedStatistics, DetailedStatistics.Builder, DetailedStatisticsOrBuilder>(
                getStats(),
                getParentForChildren(),
                isClean());
        stats_ = null;
      }
      return statsBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:GameStatistics)
  }

  // @@protoc_insertion_point(class_scope:GameStatistics)
  private static final GameStatistics DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GameStatistics();
  }

  public static GameStatistics getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GameStatistics>
      PARSER = new com.google.protobuf.AbstractParser<GameStatistics>() {
    @java.lang.Override
    public GameStatistics parsePartialFrom(
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

  public static com.google.protobuf.Parser<GameStatistics> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GameStatistics> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public GameStatistics getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

