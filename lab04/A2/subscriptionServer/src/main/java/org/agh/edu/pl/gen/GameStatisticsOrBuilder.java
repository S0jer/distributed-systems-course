// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nba_stats.proto

// Protobuf Java Version: 4.26.1
package org.agh.edu.pl.gen;

public interface GameStatisticsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GameStatistics)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string gameId = 1;</code>
   * @return The gameId.
   */
  java.lang.String getGameId();
  /**
   * <code>string gameId = 1;</code>
   * @return The bytes for gameId.
   */
  com.google.protobuf.ByteString
      getGameIdBytes();

  /**
   * <code>string date = 2;</code>
   * @return The date.
   */
  java.lang.String getDate();
  /**
   * <code>string date = 2;</code>
   * @return The bytes for date.
   */
  com.google.protobuf.ByteString
      getDateBytes();

  /**
   * <code>string opponent = 3;</code>
   * @return The opponent.
   */
  java.lang.String getOpponent();
  /**
   * <code>string opponent = 3;</code>
   * @return The bytes for opponent.
   */
  com.google.protobuf.ByteString
      getOpponentBytes();

  /**
   * <code>.GameOutcome outcome = 4;</code>
   * @return The enum numeric value on the wire for outcome.
   */
  int getOutcomeValue();
  /**
   * <code>.GameOutcome outcome = 4;</code>
   * @return The outcome.
   */
  GameOutcome getOutcome();

  /**
   * <code>.GamePerformance gamePerformanceGrade = 5;</code>
   * @return The enum numeric value on the wire for gamePerformanceGrade.
   */
  int getGamePerformanceGradeValue();
  /**
   * <code>.GamePerformance gamePerformanceGrade = 5;</code>
   * @return The gamePerformanceGrade.
   */
  GamePerformance getGamePerformanceGrade();

  /**
   * <code>.DetailedStatistics stats = 6;</code>
   * @return Whether the stats field is set.
   */
  boolean hasStats();
  /**
   * <code>.DetailedStatistics stats = 6;</code>
   * @return The stats.
   */
  DetailedStatistics getStats();
  /**
   * <code>.DetailedStatistics stats = 6;</code>
   */
  DetailedStatisticsOrBuilder getStatsOrBuilder();
}
