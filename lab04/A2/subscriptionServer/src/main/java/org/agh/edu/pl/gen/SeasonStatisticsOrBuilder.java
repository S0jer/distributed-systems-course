// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nba_stats.proto

// Protobuf Java Version: 4.26.1
package org.agh.edu.pl.gen;

public interface SeasonStatisticsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:SeasonStatistics)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string season = 1;</code>
   * @return The season.
   */
  java.lang.String getSeason();
  /**
   * <code>string season = 1;</code>
   * @return The bytes for season.
   */
  com.google.protobuf.ByteString
      getSeasonBytes();

  /**
   * <code>.DetailedStatistics averageStats = 2;</code>
   * @return Whether the averageStats field is set.
   */
  boolean hasAverageStats();
  /**
   * <code>.DetailedStatistics averageStats = 2;</code>
   * @return The averageStats.
   */
  DetailedStatistics getAverageStats();
  /**
   * <code>.DetailedStatistics averageStats = 2;</code>
   */
  DetailedStatisticsOrBuilder getAverageStatsOrBuilder();
}
