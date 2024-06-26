// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nba_stats.proto

// Protobuf Java Version: 4.26.1
package org.agh.edu.pl.gen;

public interface DetailedStatisticsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:DetailedStatistics)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>float minutes = 1;</code>
   * @return The minutes.
   */
  float getMinutes();

  /**
   * <code>float points = 2;</code>
   * @return The points.
   */
  float getPoints();

  /**
   * <code>.FieldGoalStats fieldGoals = 3;</code>
   * @return Whether the fieldGoals field is set.
   */
  boolean hasFieldGoals();
  /**
   * <code>.FieldGoalStats fieldGoals = 3;</code>
   * @return The fieldGoals.
   */
  FieldGoalStats getFieldGoals();
  /**
   * <code>.FieldGoalStats fieldGoals = 3;</code>
   */
  FieldGoalStatsOrBuilder getFieldGoalsOrBuilder();

  /**
   * <code>.FieldGoalStats threePointers = 4;</code>
   * @return Whether the threePointers field is set.
   */
  boolean hasThreePointers();
  /**
   * <code>.FieldGoalStats threePointers = 4;</code>
   * @return The threePointers.
   */
  FieldGoalStats getThreePointers();
  /**
   * <code>.FieldGoalStats threePointers = 4;</code>
   */
  FieldGoalStatsOrBuilder getThreePointersOrBuilder();

  /**
   * <code>.FreeThrowStats freeThrows = 5;</code>
   * @return Whether the freeThrows field is set.
   */
  boolean hasFreeThrows();
  /**
   * <code>.FreeThrowStats freeThrows = 5;</code>
   * @return The freeThrows.
   */
  FreeThrowStats getFreeThrows();
  /**
   * <code>.FreeThrowStats freeThrows = 5;</code>
   */
  FreeThrowStatsOrBuilder getFreeThrowsOrBuilder();

  /**
   * <code>float rebounds = 6;</code>
   * @return The rebounds.
   */
  float getRebounds();

  /**
   * <code>float assists = 7;</code>
   * @return The assists.
   */
  float getAssists();

  /**
   * <code>float steals = 8;</code>
   * @return The steals.
   */
  float getSteals();

  /**
   * <code>float blocks = 9;</code>
   * @return The blocks.
   */
  float getBlocks();

  /**
   * <code>float personalFouls = 10;</code>
   * @return The personalFouls.
   */
  float getPersonalFouls();

  /**
   * <code>float turnovers = 11;</code>
   * @return The turnovers.
   */
  float getTurnovers();
}
