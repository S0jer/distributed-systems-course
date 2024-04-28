// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nba_stats.proto

// Protobuf Java Version: 4.26.1
package org.agh.edu.pl.gen;

/**
 * Protobuf enum {@code GamePerformance}
 */
public enum GamePerformance
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>TERRIBLE = 0;</code>
   */
  TERRIBLE(0),
  /**
   * <code>BAD = 1;</code>
   */
  BAD(1),
  /**
   * <code>AVERAGE = 2;</code>
   */
  AVERAGE(2),
  /**
   * <code>GOOD = 3;</code>
   */
  GOOD(3),
  /**
   * <code>EXCELLENT = 4;</code>
   */
  EXCELLENT(4),
  UNRECOGNIZED(-1),
  ;

  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      GamePerformance.class.getName());
  }
  /**
   * <code>TERRIBLE = 0;</code>
   */
  public static final int TERRIBLE_VALUE = 0;
  /**
   * <code>BAD = 1;</code>
   */
  public static final int BAD_VALUE = 1;
  /**
   * <code>AVERAGE = 2;</code>
   */
  public static final int AVERAGE_VALUE = 2;
  /**
   * <code>GOOD = 3;</code>
   */
  public static final int GOOD_VALUE = 3;
  /**
   * <code>EXCELLENT = 4;</code>
   */
  public static final int EXCELLENT_VALUE = 4;


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
  public static GamePerformance valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static GamePerformance forNumber(int value) {
    switch (value) {
      case 0: return TERRIBLE;
      case 1: return BAD;
      case 2: return AVERAGE;
      case 3: return GOOD;
      case 4: return EXCELLENT;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<GamePerformance>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      GamePerformance> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<GamePerformance>() {
          public GamePerformance findValueByNumber(int number) {
            return GamePerformance.forNumber(number);
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
    return NbaStatsProto.getDescriptor().getEnumTypes().get(1);
  }

  private static final GamePerformance[] VALUES = values();

  public static GamePerformance valueOf(
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

  private GamePerformance(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:GamePerformance)
}
